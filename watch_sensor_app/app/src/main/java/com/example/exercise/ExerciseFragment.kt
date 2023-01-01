/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.exercise

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.health.services.client.data.*
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.wear.ambient.AmbientModeSupport
import com.example.exercise.databinding.FragmentExerciseBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.math.roundToInt


/**
 * Fragment showing the exercise controls and current exercise metrics.
 */




@AndroidEntryPoint


class ExerciseFragment : Fragment() {

    //1024~
    var builder = Retrofit.Builder()
        .baseUrl("http://223.194.45.91:80") //외부IP로 접근
        .addConverterFactory(GsonConverterFactory.create())
    var retrofit = builder.build()

    var myAPI = retrofit.create(MyAPI::class.java)

    var queue: Queue<MutableMap<String, String>> = LinkedList()

    //bmp과 cal 순서 구분 변수
    var count = 0

    //queue에 저장할 현재 데이터
    var cur_bpm:String = ""
    var cur_cal:String = ""
    var cur_time:String = ""


    @Inject
    lateinit var healthServicesManager: HealthServicesManager

    private val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentExerciseBinding? = null
    private val binding get() = _binding!!

    private var serviceConnection = ExerciseServiceConnection()

    private var cachedExerciseState = ExerciseState.USER_ENDED
    private var activeDurationUpdate = ActiveDurationUpdate()
    private var chronoTickJob: Job? = null
    private var uiBindingJob: Job? = null

    private lateinit var ambientController: AmbientModeSupport.AmbientController
    private lateinit var ambientModeHandler: AmbientModeHandler

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = FragmentExerciseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startEndButton.setOnClickListener {
            // App could take a perceptible amount of time to transition between states; put button into
            // an intermediary "disabled" state to provide UI feedback.
            it.isEnabled = false
            startEndExercise()

        }
        binding.pauseResumeButton.setOnClickListener {
            // App could take a perceptible amount of time to transition between states; put button into
            // an intermediary "disabled" state to provide UI feedback.
            it.isEnabled = false
            pauseResumeExercise()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                val capabilities =
                    healthServicesManager.getExerciseCapabilities() ?: return@repeatOnLifecycle
                val supportedTypes = capabilities.supportedDataTypes

                // Set enabled state for relevant text elements.
                binding.heartRateText.isEnabled = DataType.HEART_RATE_BPM in supportedTypes
                binding.caloriesText.isEnabled = DataType.TOTAL_CALORIES in supportedTypes
                binding.distanceText.isEnabled = DataType.DISTANCE in supportedTypes
                binding.lapsText.isEnabled = true
            }
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.keyPressFlow.collect {
                    healthServicesManager.markLap()
                }
            }
        }

        // Ambient Mode
        ambientModeHandler = AmbientModeHandler()
        ambientController = AmbientModeSupport.attach(requireActivity())
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.ambientEventFlow.collect {
                    ambientModeHandler.onAmbientEvent(it)
                }
            }
        }

        // Bind to our service. Views will only update once we are connected to it.
        ExerciseService.bindService(requireContext().applicationContext, serviceConnection)
        bindViewsToService()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Unbind from the service.
        ExerciseService.unbindService(requireContext().applicationContext, serviceConnection)
        _binding = null
    }

    private fun startEndExercise() {
        if (cachedExerciseState.isEnded) {
            tryStartExercise()
        } else {
            checkNotNull(serviceConnection.exerciseService) {
                "Failed to achieve ExerciseService instance"
            }.endExercise()
        }
    }

    private fun tryStartExercise() {
        viewLifecycleOwner.lifecycleScope.launch {
            if (healthServicesManager.isTrackingExerciseInAnotherApp()) {
                // Show the user a confirmation screen.
                findNavController().navigate(R.id.to_newExerciseConfirmation)
            } else if (!healthServicesManager.isExerciseInProgress()) {
                checkNotNull(serviceConnection.exerciseService) {
                    "Failed to achieve ExerciseService instance"
                }.startExercise()
            }
        }
    }

    private fun pauseResumeExercise() {
        val service = checkNotNull(serviceConnection.exerciseService) {
            "Failed to achieve ExerciseService instance"
        }
        if (cachedExerciseState.isPaused) {
            service.resumeExercise()
        } else {
            service.pauseExercise()
        }
    }

    private fun bindViewsToService() {
        if (uiBindingJob != null) return

        uiBindingJob = viewLifecycleOwner.lifecycleScope.launch {
            serviceConnection.repeatWhenConnected { service ->
                // Use separate launch blocks because each .collect executes indefinitely.
                launch {
                    service.exerciseState.collect {
                        updateExerciseStatus(it)
                    }
                }
                launch {
                    service.exerciseMetrics.collect {
                        updateMetrics(it)
                    }
                }
                launch {
                    service.aggregateMetrics.collect {
                        updateAggregateMetrics(it)
                    }
                }
                launch {
                    service.exerciseLaps.collect {
                        updateLaps(it)
                    }
                }
                launch {
                    service.exerciseDurationUpdate.collect {
                        // We don't update the chronometer here since these updates come at irregular
                        // intervals. Instead we store the duration and update the chronometer with
                        // our own regularly-timed intervals.
                        activeDurationUpdate = it
                    }
                }
            }
        }
    }

    private fun unbindViewsFromService() {
        uiBindingJob?.cancel()
        uiBindingJob = null
    }

    private fun updateExerciseStatus(state: ExerciseState) {
        val previousStatus = cachedExerciseState
        if (previousStatus.isEnded && !state.isEnded) {
            // We're starting a new exercise. Clear metrics from any prior exercise.
            resetDisplayedFields()
        }

        if (state == ExerciseState.ACTIVE && !ambientController.isAmbient) {
            startChronometer()
        } else {
            stopChronometer()
        }

        updateButtons(state)
        cachedExerciseState = state
    }

    private fun updateButtons(state: ExerciseState) {
        binding.startEndButton.setText(if (state.isEnded) R.string.start else R.string.end)
        binding.startEndButton.isEnabled = true
        binding.pauseResumeButton.setText(if (state.isPaused) R.string.resume else R.string.pause)
        binding.pauseResumeButton.isEnabled = !state.isEnded
    }
    
    

    
    
    
    private fun updateMetrics(data: Map<DataType, List<DataPoint>>) {
        data[DataType.HEART_RATE_BPM]?.let {
            val bpm = it.last().value.asDouble().roundToInt().toString()
            val dateAndtime: LocalDateTime = LocalDateTime.now()
            binding.heartRateText.text = bpm
            sendQueue(0,bpm, dateAndtime.toString())

        }
    }




    private fun updateAggregateMetrics(data: Map<DataType, AggregateDataPoint>) {

        (data[DataType.TOTAL_CALORIES] as? CumulativeDataPoint)?.let {
            val calories = formatCalories(it.total.asDouble())
            val dateAndtime: LocalDateTime = LocalDateTime.now()
            binding.caloriesText.text = calories
            sendQueue(1,calories.toString() , dateAndtime.toString())

        }
    }

    private fun updateLaps(laps: Int) {
        binding.lapsText.text = laps.toString()
    }

    private fun startChronometer() {
        if (chronoTickJob == null) {
            chronoTickJob = viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    while (true) {
                        delay(CHRONO_TICK_MS)
                        updateChronometer()
                    }
                }
            }
        }
    }

    private fun stopChronometer() {
        chronoTickJob?.cancel()
        chronoTickJob = null
    }

    private fun updateChronometer() {
        // We update the chronometer on our own regular intervals independent of the exercise
        // duration value received. If the exercise is still active, add the difference between
        // the last duration update and now.
        val difference = if (cachedExerciseState == ExerciseState.ACTIVE) {
            Duration.between(activeDurationUpdate.timestamp, Instant.now())
        } else {
            Duration.ZERO
        }
        val duration = activeDurationUpdate.duration + difference
        binding.elapsedTime.text = formatElapsedTime(duration, !ambientController.isAmbient)
    }

    private fun resetDisplayedFields() {
        getString(R.string.empty_metric).let {
            binding.heartRateText.text = it
            binding.caloriesText.text = it
            binding.distanceText.text = it
            binding.lapsText.text = it
        }
        binding.elapsedTime.text = formatElapsedTime(Duration.ZERO, true)
    }

    // -- Ambient Mode support

    private fun setAmbientUiState(isAmbient: Boolean) {
        // Change icons to white while in ambient mode.
        val iconTint = if (isAmbient) {
            Color.WHITE
        } else {
            resources.getColor(R.color.primary_orange, null)
        }
        ColorStateList.valueOf(iconTint).let {
            binding.clockIcon.imageTintList = it
            binding.heartRateIcon.imageTintList = it
            binding.caloriesIcon.imageTintList = it
            binding.distanceIcon.imageTintList = it
            binding.lapsIcon.imageTintList = it
        }

        // Hide the buttons in ambient mode.
        val buttonVisibility = if (isAmbient) View.INVISIBLE else View.VISIBLE
        buttonVisibility.let {
            binding.startEndButton.visibility = it
            binding.pauseResumeButton.visibility = it
        }
    }

    private fun performOneTimeUiUpdate() {
        val service = checkNotNull(serviceConnection.exerciseService) {
            "Failed to achieve ExerciseService instance"
        }
        updateExerciseStatus(service.exerciseState.value)
        updateMetrics(service.exerciseMetrics.value)
        updateLaps(service.exerciseLaps.value)

        activeDurationUpdate = service.exerciseDurationUpdate.value
        updateChronometer()
    }

    inner class AmbientModeHandler {
        internal fun onAmbientEvent(event: AmbientEvent) {
            when (event) {
                is AmbientEvent.Enter -> onEnterAmbient()
                is AmbientEvent.Exit -> onExitAmbient()
                is AmbientEvent.Update -> onUpdateAmbient()
            }
        }

        private fun onEnterAmbient() {
            // Note: Apps should also handle low-bit ambient and burn-in protection.
            unbindViewsFromService()
            setAmbientUiState(true)
            performOneTimeUiUpdate()
        }

        private fun onExitAmbient() {
            performOneTimeUiUpdate()
            setAmbientUiState(false)
            bindViewsToService()

        }

        private fun onUpdateAmbient() {
            performOneTimeUiUpdate()
        }
    }

    companion object {
        const val CHRONO_TICK_MS = 200L
    }


    private fun send_server(){
        val sharedPref = activity?.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        val phone = sharedPref?.getString("phone", "")
        Log.d(TAG,"login: $phone")

        var user_ID: RequestBody = RequestBody.create(MediaType.parse("text/plain"), phone)
        var data = queue.peek()
        Log.d(TAG,"등록할 data : $data")

        var datetime: RequestBody = RequestBody.create(MediaType.parse("text/plain"), data["time"])
        var bpm_data: RequestBody = RequestBody.create(MediaType.parse("text/plain"), data["bpm"])
        var cal_data: RequestBody = RequestBody.create(MediaType.parse("text/plain"), data["cal"])
        // Retrofit 객체를 생성하고 이 객체를 이용해서, API service 를 create 해준다.

        // post 한다는 request를 보내는 부분.
        var call = myAPI.bpm_send(user_ID, datetime, bpm_data,cal_data)

        // 만약 서버로 부터 response를 받는다면.
        call.enqueue(
            object : Callback<ResponseBody?> {
                override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                    if (response.isSuccessful) {
                        Log.d("API", "등록 완료")
                        queue.poll()
                        //Log.d(TAG,"등록 후 queue : $queue")
                    } else {
                        Log.d("API", "Post Status Code : " + response.code())
                        Log.d("API", response.errorBody().toString())
                        Log.d("API", call.request().body().toString())
                    }
                }

                override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                    Log.d("API", "Fail msg : " + t.message)
                }
            })

    }
    private fun sendQueue(type: Int, data: String, time: String){

        if (count == 0) {//bpm 들어올 차례
            if (type == 0){//bpm
                cur_bpm = data
                cur_time = time //bpm기준 시간
                count = 1
                Log.d(TAG,"bpm저장")
            }
            if (type == 1){//cal(오류)
                cur_bpm = ""
                cur_time = time //cal기준 시간
                cur_cal = data

                //큐로 보내기
                val cur_data = mutableMapOf("time" to cur_time, "bpm" to cur_bpm, "cal" to cur_cal)
                queue.add(cur_data)
                send_server()
                Log.d(TAG,"bpm누락 경우 queue : $queue")
                count = 0
            }
        }

        else if (count == 1) { //cal 들어올 차례
            if (type == 1) {//cal
                cur_cal = data

                //큐로 보내기
                val cur_data = mutableMapOf("time" to cur_time, "bpm" to cur_bpm, "cal" to cur_cal)
                queue.add(cur_data)
                send_server()

                Log.d(TAG,"정상 queue : $queue")
                count = 0
            }
            if (type == 0) {//bpm(오류)
                //cal은 누적값이니까 그 전 값 가져오기
                //현재 time은 bpm기준 시간
                //큐로 보내기
                val cur_data = mutableMapOf("time" to cur_time, "bpm" to cur_bpm, "cal" to cur_cal)
                queue.add(cur_data)
                Log.d(TAG,"cal누락 경우 queue : $queue")
                send_server()
                //
                cur_bpm = data
                cur_time = time //bpm기준 시간

                count = 1
            }
        }
    }

}

