package com.example.dz3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.sampleapis.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        MessageAPI messageAPI=retrofit.create(MessageAPI.class);

        Call<String> message=messageAPI.message();
        try {
            Log.i("Check", ""+message.execute().body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        message.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.w("Volodymyr","DATA: "+response.body());
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.w("Volodymyr","Failure"+t);
            }
        });
    }


}