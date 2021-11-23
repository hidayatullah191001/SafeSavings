package com.example.safesavings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    @SerializedName("quality")
    @Expose
    private String quality;
    @SerializedName("link")
    @Expose
    private Link link;

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

}

