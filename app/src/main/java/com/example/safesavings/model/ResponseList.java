package com.example.safesavings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseList {
    @SerializedName("title")
    @Expose

    private String title;
    @SerializedName("results")
    @Expose
    private List<ListAnime> listanime = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ListAnime> getListanime() {
        return listanime;
    }

    public void setListanime(List<ListAnime> listanime) {
        this.listanime = listanime;
    }



}

