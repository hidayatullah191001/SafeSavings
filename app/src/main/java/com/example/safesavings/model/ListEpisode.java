package com.example.safesavings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListEpisode {
    @SerializedName("episode")
    @Expose
    private String episode;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("date_uploaded")
    @Expose
    private String dateUploaded;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("id")
    @Expose
    private String id;

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(String dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
