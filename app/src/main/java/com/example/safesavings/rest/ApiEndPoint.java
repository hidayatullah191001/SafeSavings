package com.example.safesavings.rest;

import retrofit2.Call;
import com.example.safesavings.model.Response;
import com.example.safesavings.model.ResponseDetail;
import com.example.safesavings.model.ResponseBlog;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndPoint{

    @GET("/page/{page}")
    Call<Response> getDataSeason(@Path("page") int page);

    @GET("/search/{title}/")
    Call<Response> getDataSearch(@Path("title") String title);

    @GET("/blog/")
    Call<ResponseBlog> getDataListBlog();

    @GET("/anime/{id}/")
    Call<ResponseDetail> getDataDetailAnime(@Path("id") String id);
}
