package com.example.safesavings.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.safesavings.MainActivity;
import com.example.safesavings.R;
import com.example.safesavings.adapter.FavoriteAdapter;
import com.example.safesavings.adapter.SeasonAnimeAdapter;
import com.example.safesavings.favorite.FavoriteDatabase;
import com.example.safesavings.favorite.FavoriteList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentFavorite extends Fragment {
    RecyclerView rvFavorite;
    private FavoriteAdapter favoriteAdapter;
    public static FavoriteDatabase db;
    public static List<FavoriteList> mlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);


        db = Room.databaseBuilder(getActivity(),
                FavoriteDatabase.class, "favoriteDB").allowMainThreadQueries().build();

        rvFavorite = view.findViewById(R.id.rvfavorite);
        rvFavorite.setHasFixedSize(true);
        rvFavorite.setLayoutManager(new LinearLayoutManager(view.getContext()));

        mlist = db.favoriteDao().selectAllFavorite();

        favoriteAdapter = new FavoriteAdapter(mlist,getActivity());
        rvFavorite.setAdapter(favoriteAdapter);

        return view;
    }

}