package com.example.sampledagger2recyclerview.network;

import com.example.sampledagger2recyclerview.pojo.UserData;

import dagger.Provides;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IApis {

    @GET("/api/users?page=2")
    Call<UserData> getUserData();
}
