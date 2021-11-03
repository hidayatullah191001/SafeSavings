package com.example.safesavings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailAnime {
    @SerializedName("Japanese")
    @Expose
    private String japanese;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Duration")
    @Expose
    private String duration;
    @SerializedName("Season")
    @Expose
    private String season;
    @SerializedName("Producers")
    @Expose
    private String producers;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Source")
    @Expose
    private String source;
    @SerializedName("TotalEpisode")
    @Expose
    private String totalEpisode;
    @SerializedName("Studio")
    @Expose
    private String studio;
    @SerializedName("Rilis:")
    @Expose
    private String rilis;

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTotalEpisode() {
        return totalEpisode;
    }

    public void setTotalEpisode(String totalEpisode) {
        this.totalEpisode = totalEpisode;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }
}
