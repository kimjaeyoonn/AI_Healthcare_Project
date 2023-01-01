package com.example.exercise;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface MyAPI {
    @Multipart
    @POST("/tests/")
    Call<ResponseBody> bpm_send(
            @Part("user_ID") RequestBody param1,
            @Part("Datetime") RequestBody param2,
            @Part("BPM") RequestBody param3,
            @Part("Calories") RequestBody param4
    );
}
