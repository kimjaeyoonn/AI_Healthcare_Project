package com.example.exercise;

import java.lang.System;

/**
 * Fragment showing the exercise controls and current exercise metrics.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 y2\u00020\u0001:\u0002xyB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010N\u001a\u00020OH\u0002J$\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\b\u0010X\u001a\u00020OH\u0016J\u001a\u0010Y\u001a\u00020O2\u0006\u0010Z\u001a\u00020Q2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\b\u0010[\u001a\u00020OH\u0002J\b\u0010\\\u001a\u00020OH\u0002J\b\u0010]\u001a\u00020OH\u0002J \u0010^\u001a\u00020O2\u0006\u0010_\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020!2\u0006\u0010a\u001a\u00020!H\u0002J\b\u0010b\u001a\u00020OH\u0002J\u0010\u0010c\u001a\u00020O2\u0006\u0010d\u001a\u00020eH\u0002J\b\u0010f\u001a\u00020OH\u0002J\b\u0010g\u001a\u00020OH\u0002J\b\u0010h\u001a\u00020OH\u0002J\b\u0010i\u001a\u00020OH\u0002J\b\u0010j\u001a\u00020OH\u0002J\u001c\u0010k\u001a\u00020O2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020n0lH\u0002J\u0010\u0010o\u001a\u00020O2\u0006\u0010p\u001a\u00020\u0017H\u0002J\b\u0010q\u001a\u00020OH\u0002J\u0010\u0010r\u001a\u00020O2\u0006\u0010p\u001a\u00020\u0017H\u0002J\u0010\u0010s\u001a\u00020O2\u0006\u0010t\u001a\u00020\u001bH\u0002J\"\u0010u\u001a\u00020O2\u0018\u0010`\u001a\u0014\u0012\u0004\u0012\u00020m\u0012\n\u0012\b\u0012\u0004\u0012\u00020w0v0lH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\n \u0011*\u0004\u0018\u00010303X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R,\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0:09X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\n \u0011*\u0004\u0018\u00010@0@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bJ\u0010K\u00a8\u0006z"}, d2 = {"Lcom/example/exercise/ExerciseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/exercise/databinding/FragmentExerciseBinding;", "activeDurationUpdate", "Lcom/example/exercise/ActiveDurationUpdate;", "ambientController", "Landroidx/wear/ambient/AmbientModeSupport$AmbientController;", "Landroidx/wear/ambient/AmbientModeSupport;", "ambientModeHandler", "Lcom/example/exercise/ExerciseFragment$AmbientModeHandler;", "binding", "getBinding", "()Lcom/example/exercise/databinding/FragmentExerciseBinding;", "builder", "Lretrofit2/Retrofit$Builder;", "kotlin.jvm.PlatformType", "getBuilder", "()Lretrofit2/Retrofit$Builder;", "setBuilder", "(Lretrofit2/Retrofit$Builder;)V", "cachedExerciseState", "Landroidx/health/services/client/data/ExerciseState;", "chronoTickJob", "Lkotlinx/coroutines/Job;", "count", "", "getCount", "()I", "setCount", "(I)V", "cur_bpm", "", "getCur_bpm", "()Ljava/lang/String;", "setCur_bpm", "(Ljava/lang/String;)V", "cur_cal", "getCur_cal", "setCur_cal", "cur_time", "getCur_time", "setCur_time", "healthServicesManager", "Lcom/example/exercise/HealthServicesManager;", "getHealthServicesManager", "()Lcom/example/exercise/HealthServicesManager;", "setHealthServicesManager", "(Lcom/example/exercise/HealthServicesManager;)V", "myAPI", "Lcom/example/exercise/MyAPI;", "getMyAPI", "()Lcom/example/exercise/MyAPI;", "setMyAPI", "(Lcom/example/exercise/MyAPI;)V", "queue", "Ljava/util/Queue;", "", "getQueue", "()Ljava/util/Queue;", "setQueue", "(Ljava/util/Queue;)V", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "serviceConnection", "Lcom/example/exercise/ExerciseServiceConnection;", "uiBindingJob", "viewModel", "Lcom/example/exercise/MainViewModel;", "getViewModel", "()Lcom/example/exercise/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bindViewsToService", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "pauseResumeExercise", "performOneTimeUiUpdate", "resetDisplayedFields", "sendQueue", "type", "data", "time", "send_server", "setAmbientUiState", "isAmbient", "", "startChronometer", "startEndExercise", "stopChronometer", "tryStartExercise", "unbindViewsFromService", "updateAggregateMetrics", "", "Landroidx/health/services/client/data/DataType;", "Landroidx/health/services/client/data/AggregateDataPoint;", "updateButtons", "state", "updateChronometer", "updateExerciseStatus", "updateLaps", "laps", "updateMetrics", "", "Landroidx/health/services/client/data/DataPoint;", "AmbientModeHandler", "Companion", "app_release"})
@dagger.hilt.android.AndroidEntryPoint()
public final class ExerciseFragment extends androidx.fragment.app.Fragment {
    private retrofit2.Retrofit.Builder builder;
    private retrofit2.Retrofit retrofit;
    private com.example.exercise.MyAPI myAPI;
    @org.jetbrains.annotations.NotNull()
    private java.util.Queue<java.util.Map<java.lang.String, java.lang.String>> queue;
    private int count = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cur_bpm = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cur_cal = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String cur_time = "";
    @javax.inject.Inject()
    public com.example.exercise.HealthServicesManager healthServicesManager;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.exercise.databinding.FragmentExerciseBinding _binding;
    private com.example.exercise.ExerciseServiceConnection serviceConnection;
    private androidx.health.services.client.data.ExerciseState cachedExerciseState = androidx.health.services.client.data.ExerciseState.USER_ENDED;
    private com.example.exercise.ActiveDurationUpdate activeDurationUpdate;
    private kotlinx.coroutines.Job chronoTickJob;
    private kotlinx.coroutines.Job uiBindingJob;
    private androidx.wear.ambient.AmbientModeSupport.AmbientController ambientController;
    private com.example.exercise.ExerciseFragment.AmbientModeHandler ambientModeHandler;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.exercise.ExerciseFragment.Companion Companion = null;
    public static final long CHRONO_TICK_MS = 200L;
    
    public ExerciseFragment() {
        super();
    }
    
    public final retrofit2.Retrofit.Builder getBuilder() {
        return null;
    }
    
    public final void setBuilder(retrofit2.Retrofit.Builder p0) {
    }
    
    public final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    public final void setRetrofit(retrofit2.Retrofit p0) {
    }
    
    public final com.example.exercise.MyAPI getMyAPI() {
        return null;
    }
    
    public final void setMyAPI(com.example.exercise.MyAPI p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Queue<java.util.Map<java.lang.String, java.lang.String>> getQueue() {
        return null;
    }
    
    public final void setQueue(@org.jetbrains.annotations.NotNull()
    java.util.Queue<java.util.Map<java.lang.String, java.lang.String>> p0) {
    }
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCur_bpm() {
        return null;
    }
    
    public final void setCur_bpm(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCur_cal() {
        return null;
    }
    
    public final void setCur_cal(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCur_time() {
        return null;
    }
    
    public final void setCur_time(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.exercise.HealthServicesManager getHealthServicesManager() {
        return null;
    }
    
    public final void setHealthServicesManager(@org.jetbrains.annotations.NotNull()
    com.example.exercise.HealthServicesManager p0) {
    }
    
    private final com.example.exercise.MainViewModel getViewModel() {
        return null;
    }
    
    private final com.example.exercise.databinding.FragmentExerciseBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void startEndExercise() {
    }
    
    private final void tryStartExercise() {
    }
    
    private final void pauseResumeExercise() {
    }
    
    private final void bindViewsToService() {
    }
    
    private final void unbindViewsFromService() {
    }
    
    private final void updateExerciseStatus(androidx.health.services.client.data.ExerciseState state) {
    }
    
    private final void updateButtons(androidx.health.services.client.data.ExerciseState state) {
    }
    
    private final void updateMetrics(java.util.Map<androidx.health.services.client.data.DataType, ? extends java.util.List<androidx.health.services.client.data.DataPoint>> data) {
    }
    
    private final void updateAggregateMetrics(java.util.Map<androidx.health.services.client.data.DataType, ? extends androidx.health.services.client.data.AggregateDataPoint> data) {
    }
    
    private final void updateLaps(int laps) {
    }
    
    private final void startChronometer() {
    }
    
    private final void stopChronometer() {
    }
    
    private final void updateChronometer() {
    }
    
    private final void resetDisplayedFields() {
    }
    
    private final void setAmbientUiState(boolean isAmbient) {
    }
    
    private final void performOneTimeUiUpdate() {
    }
    
    private final void send_server() {
    }
    
    private final void sendQueue(int type, java.lang.String data, java.lang.String time) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\u0007J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/example/exercise/ExerciseFragment$AmbientModeHandler;", "", "(Lcom/example/exercise/ExerciseFragment;)V", "onAmbientEvent", "", "event", "Lcom/example/exercise/AmbientEvent;", "onAmbientEvent$app_release", "onEnterAmbient", "onExitAmbient", "onUpdateAmbient", "app_release"})
    public final class AmbientModeHandler {
        
        public AmbientModeHandler() {
            super();
        }
        
        public final void onAmbientEvent$app_release(@org.jetbrains.annotations.NotNull()
        com.example.exercise.AmbientEvent event) {
        }
        
        private final void onEnterAmbient() {
        }
        
        private final void onExitAmbient() {
        }
        
        private final void onUpdateAmbient() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/exercise/ExerciseFragment$Companion;", "", "()V", "CHRONO_TICK_MS", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}