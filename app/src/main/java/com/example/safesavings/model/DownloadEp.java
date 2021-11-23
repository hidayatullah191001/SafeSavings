package com.example.safesavings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DownloadEp {
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}

