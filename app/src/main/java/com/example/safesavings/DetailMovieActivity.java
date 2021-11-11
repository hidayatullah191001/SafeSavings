package com.example.safesavings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.safesavings.adapter.DetailAnimeAdapter;
import com.example.safesavings.adapter.LatestAnimeAdapter;
import com.example.safesavings.adapter.ListEpisodeAnimeAdapter;
import com.example.safesavings.adapter.SeasonAnimeAdapter;
import com.example.safesavings.model.DetailAnime;
import com.example.safesavings.model.Latest;
import com.example.safesavings.model.ListEpisode;
import com.example.safesavings.model.Response;
import com.example.safesavings.model.ResponseDetail;
import com.example.safesavings.model.Season;
import com.example.safesavings.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class DetailMovieActivity extends AppCompatActivity {
    private ListEpisodeAnimeAdapter listEpisodeAnimeAdapter;
    public String id;
    public String valRatingCount;
    private String TAG = "DetailMovieActivity";


    RecyclerView recyclerView;

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
        title1.setText("Nonton"+title);

        TextView deskripsi1 = findViewById(R.id.txtDetailDeskripsi);
        deskripsi1.setText(deskripsi);

        ImageView headerbg = findViewById(R.id.imgDetailAnime);
        Glide.with(this).load(image).into(headerbg);

        TextView rating1 = findViewById(R.id.txtViewAnime);
        rating1.setText(rating);



        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle(title);
        }

        recyclerView = findViewById(R.id.rvListEpisode);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getListEpisodeAnimeData();
    }

    private void getListEpisodeAnimeData() {
        ApiService.endPoint().getDataDetailAnime(id)
                .enqueue(new Callback<ResponseDetail>() {
                    @Override
                    public void onResponse(Call<ResponseDetail> call, retrofit2.Response<ResponseDetail> response) {
                        if (response.isSuccessful()){
                            List<ListEpisode> mListEpisode = response.body().getListEpisode();
                            listEpisodeAnimeAdapter = new ListEpisodeAnimeAdapter(DetailMovieActivity.this, mListEpisode);
                            recyclerView.setAdapter(listEpisodeAnimeAdapter);
                            valRatingCount = response.body().getRatingCount();
                            TextView txtRatingCount = findViewById(R.id.txtratingcount);
                            txtRatingCount.setText(valRatingCount);

                            DetailAnime mDetail = response.body().getDetail();
                            String valtotalepisode = mDetail.getTotalEpisode();
                            Log.d(TAG, "onResponse: " + valtotalepisode);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseDetail> call, Throwable t) {

                    }
                });
    }
}