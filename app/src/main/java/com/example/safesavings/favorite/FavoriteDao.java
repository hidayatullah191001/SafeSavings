package com.example.safesavings.favorite;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addData(FavoriteList favoriteList);

    @Query("SELECT * FROM tfav ORDER BY id DESC")
    List<FavoriteList> selectAllFavorite();

    @Delete
    int deleteFavorite(FavoriteList favoriteList);

    @Query("SELECT EXISTS (SELECT 1 FROM tfav WHERE idanime = :idnime)")
    public int isFavorite(String idnime);

    @Query("SELECT idanime FROM tfav WHERE idanime =:idanime")
    String cekidanime (String idanime);
}