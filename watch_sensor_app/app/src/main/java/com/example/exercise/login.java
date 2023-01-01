package com.example.exercise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends Activity {


    private EditText phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        phone = findViewById(R.id.phone);


    }
    protected void saveState(String phone){ // 데이터를 저장한다.

        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("phone", phone);
        editor.commit();
    }

    public void loginClick(View v){
        String input_phone = phone.getText().toString();
        saveState(input_phone);

        Log.d("Login", input_phone);

        Context context = getApplicationContext();
        Intent intent = new Intent(this, MainActivity.class);
        context.startForegroundService(intent);
        startActivity(intent);


    }

}