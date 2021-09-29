package com.example.safesavings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("season")
    @Expose
    private List<Season> season = null;
    @SerializedName("latest")
    @Expose
    private List<Latest> latest = null;

    public List<Season> getSeason() {
        return season;
    }

    public void setSeason(List<Season> season) {
        this.season = season;
    }

    public List<Latest> getLatest() {
        return latest;
    }

    public void setLatest(List<Latest> latest) {
        this.latest = latest;
    }
}
