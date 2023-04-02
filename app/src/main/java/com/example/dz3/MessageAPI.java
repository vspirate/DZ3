package com.example.dz3;


import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageAPI {
    @GET("/coffee/hot")
    Call<String> message();

}
