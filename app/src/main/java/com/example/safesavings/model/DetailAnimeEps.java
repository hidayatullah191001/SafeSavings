package com.example.safesavings.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailAnimeEps {
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("sinopsis")
    @Expose
    private String sinopsis;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
