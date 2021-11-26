package com.example.safesavings.favorite;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName="tfav")
public class FavoriteList implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "idanime")
    @NonNull
    private String idanime;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "judul")
    private String judul;

    @ColumnInfo(name = "deskripsi")
    private String deskripsi;

    @ColumnInfo(name = "rating")
    private String rating;

    private int status_fav;

    public String getIdanime() { return idanime; }

    public void setIdanime(String idanime) {

        this.idanime = idanime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getStatus_fav() {
        return status_fav;
    }

    public void setStatus_fav(int status_fav) {
        this.status_fav = status_fav;
    }
}
