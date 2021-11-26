package com.example.safesavings.rest;

import retrofit2.Call;
import com.example.safesavings.model.Response;
import com.example.safesavings.model.ResponseBlog;
import com.example.safesavings.model.ResponseBlogDetail;
import com.example.safesavings.model.ResponseDetail;
import com.example.safesavings.model.ResponseDetailEps;

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

    @GET("/blog/read/{id}")
    Call<ResponseBlogDetail> getBlogDetail(@Path("id") String id);

    @GET("/anime/eps/{id}/")
    Call<ResponseDetailEps> getDataDetailEpsAnime(@Path("id") String id);
}
