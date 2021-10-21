package com.example.safesavings.rest;

import retrofit2.Call;
import com.example.safesavings.model.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndPoint{

    @GET("/")
    Call<Response> getDataSeason();

    @GET("/search/{title}/")
    Call<Response> getDataSearch(@Path("title") String title);
}
