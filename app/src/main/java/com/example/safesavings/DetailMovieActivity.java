package com.example.safesavings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.safesavings.adapter.DetailAnimeAdapter;
import com.example.safesavings.adapter.LatestAnimeAdapter;
import com.example.safesavings.adapter.SeasonAnimeAdapter;
import com.example.safesavings.model.DetailAnime;
import com.example.safesavings.model.Latest;
import com.example.safesavings.model.Response;
import com.example.safesavings.model.ResponseDetail;
import com.example.safesavings.model.Season;
import com.example.safesavings.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class DetailMovieActivity extends AppCompatActivity {
    private DetailAnimeAdapter detailAnimeAdapter;

    public String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Intent intent = getIntent();
        id = intent.getStringExtra(SeasonAnimeAdapter.EXTRA_MESSAGE1);
        String title = intent.getStringExtra(SeasonAnimeAdapter.EXTRA_MESSAGE2);
        String deskripsi = intent.getStringExtra(SeasonAnimeAdapter.EXTRA_MESSAGE3);
        String image = intent.getStringExtra(SeasonAnimeAdapter.EXTRA_MESSAGE4);
        String rating = intent.getStringExtra(SeasonAnimeAdapter.EXTRA_MESSAGE5);

        TextView title1 = findViewById(R.id.txtJudulAnime);
        title1.setText(title);

        TextView deskripsi1 = findViewById(R.id.txtDetailDeskripsi);
        deskripsi1.setText(deskripsi);

        ImageView image1 = findViewById(R.id.imgDetailAnime);
        Glide.with(this).load(image).into(image1);

        ImageView headerbg = findViewById(R.id.header);
        Glide.with(this).load(image).into(headerbg);

        TextView rating1 = findViewById(R.id.txtViewAnime);
        rating1.setText(rating);
    }
}