package com.example.safesavings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDetail {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("sinopsis")
    @Expose
    private String sinopsis;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("genre")
    @Expose
    private List<Genre> genre = null;
    @SerializedName("ratingValue")
    @Expose
    private String ratingValue;
    @SerializedName("ratingCount")
    @Expose
    private String ratingCount;
    @SerializedName("detail")
    @Expose
    private DetailAnime detail;
    @SerializedName("youtube")
    @Expose
    private Youtube youtube;
    @SerializedName("list_episode")
    @Expose
    private List<ListEpisode> listEpisode = null;
    @SerializedName("recommend")
    @Expose
    private List<Recommend> recommend = null;
    @SerializedName("latest")
    @Expose
    private List<Latest> latest = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

    public DetailAnime getDetail() {
        return detail;
    }

    public void setDetail(DetailAnime detail) {
        this.detail = detail;
    }

    public Youtube getYoutube() {
        return youtube;
    }

    public void setYoutube(Youtube youtube) {
        this.youtube = youtube;
    }

    public List<ListEpisode> getListEpisode() {
        return listEpisode;
    }

    public void setListEpisode(List<ListEpisode> listEpisode) {
        this.listEpisode = listEpisode;
    }

    public List<Recommend> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<Recommend> recommend) {
        this.recommend = recommend;
    }

    public List<Latest> getLatest() {
        return latest;
    }

    public void setLatest(List<Latest> latest) {
        this.latest = latest;
    }

}
