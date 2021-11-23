package com.example.safesavings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link {
    @SerializedName("zippyshare")
    @Expose
    private String zippyshare;
    @SerializedName("gdrive")
    @Expose
    private String gdrive;
    @SerializedName("reupload")
    @Expose
    private String reupload;

    public String getZippyshare() {
        return zippyshare;
    }

    public void setZippyshare(String zippyshare) {
        this.zippyshare = zippyshare;
    }

    public String getGdrive() {
        return gdrive;
    }

    public void setGdrive(String gdrive) {
        this.gdrive = gdrive;
    }

    public String getReupload() {
        return reupload;
    }

    public void setReupload(String reupload) {
        this.reupload = reupload;
    }

}

