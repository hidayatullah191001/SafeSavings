package com.example.safesavings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDetailEps {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("eps")
    @Expose
    private String eps;
    @SerializedName("uploader")
    @Expose
    private String uploader;
    @SerializedName("detail_anime")
    @Expose
    private DetailAnimeEps detailAnimeEps;
    @SerializedName("downloadEps")
    @Expose
    private List<DownloadEp> downloadEps = null;
    @SerializedName("recommend")
    @Expose
    private List<Recommend> recommend = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public DetailAnimeEps getDetailAnime() {
        return detailAnimeEps;
    }

    public void setDetailAnimeEps(DetailAnimeEps detailAnimeEps) {
        this.detailAnimeEps = detailAnimeEps;
    }

    public List<DownloadEp> getDownloadEps() {
        return downloadEps;
    }

    public void setDownloadEps(List<DownloadEp> downloadEps) {
        this.downloadEps = downloadEps;
    }

    public List<Recommend> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<Recommend> recommend) {
        this.recommend = recommend;
    }

}

