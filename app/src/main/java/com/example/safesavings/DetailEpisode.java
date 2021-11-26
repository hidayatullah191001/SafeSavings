package com.example.safesavings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.safesavings.adapter.DownloadEpisodeAnimeAdapter;
import com.example.safesavings.adapter.GenreAnimeAdapter;
import com.example.safesavings.adapter.LinkEpisodeAnimeAdapter;
import com.example.safesavings.adapter.SeasonAnimeAdapter;
import com.example.safesavings.model.Datum;
import com.example.safesavings.model.DetailAnimeEps;
import com.example.safesavings.model.DownloadEp;
import com.example.safesavings.model.Genre;
import com.example.safesavings.model.ListEpisode;
import com.example.safesavings.model.ResponseDetail;
import com.example.safesavings.model.ResponseDetailEps;
import com.example.safesavings.model.Youtube;
import com.example.safesavings.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class DetailEpisode extends AppCompatActivity {

    private String id;
    RecyclerView recyclerView;
    private DownloadEpisodeAnimeAdapter DownEpsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_episode);
        Intent intent = getIntent();

        id = intent.getStringExtra(SeasonAnimeAdapter.EXTRA_MESSAGE1);

        recyclerView = findViewById(R.id.rvdownloadep);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getDataEpsAnime();
    }

    private void getDataEpsAnime() {
        ApiService.endPoint().getDataDetailEpsAnime(id)
                .enqueue(new Callback<ResponseDetailEps>() {
                    @Override
                    public void onResponse(Call<ResponseDetailEps> call, retrofit2.Response<ResponseDetailEps> response) {
                        if (response.isSuccessful()) {
                            DetailAnimeEps detailAnimeEps = response.body().getDetailAnime();

                            String image = detailAnimeEps.getImage();
                            ImageView headerbg = findViewById(R.id.imgDetailAnimeEps);
                            Glide.with(DetailEpisode.this).load(image).into(headerbg);

                            String Judul = response.body().getTitle();
                            TextView textjudul = findViewById(R.id.JudulAnime);
                            textjudul.setText(Judul);

                            if (getSupportActionBar() != null) {
                                getSupportActionBar().setTitle(Judul);
                            }

                            String txtDetailEps = response.body().getEps();
                            TextView textdetaileps = findViewById(R.id.txtDetailEps);
                            textdetaileps.setText("Episode " + txtDetailEps);

                            String txtDetailDeskripsi = detailAnimeEps.getSinopsis();
                            TextView textdetaildeskripsi = findViewById(R.id.txtDetailDeskripsi);
                            textdetaildeskripsi.setText(txtDetailDeskripsi);

                            List<DownloadEp> mDownload = response.body().getDownloadEps();
                            DownEpsAdapter = new DownloadEpisodeAnimeAdapter(DetailEpisode.this, mDownload);
                            recyclerView.setAdapter(DownEpsAdapter);

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseDetailEps> call, Throwable t) {

                    }
                });
    }
}
