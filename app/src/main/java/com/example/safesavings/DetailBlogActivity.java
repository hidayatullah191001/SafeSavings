package com.example.safesavings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.safesavings.adapter.ListBlogAdapter;
import com.example.safesavings.adapter.ListBlogContentAdapter;
import com.example.safesavings.adapter.ListEpisodeAnimeAdapter;
import com.example.safesavings.adapter.SeasonAnimeAdapter;
import com.example.safesavings.model.Content;
import com.example.safesavings.model.ListEpisode;
import com.example.safesavings.model.ResponseBlogDetail;
import com.example.safesavings.model.ResponseDetail;
import com.example.safesavings.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class DetailBlogActivity extends AppCompatActivity {
    private String id;
    RecyclerView recyclerView;
    private ListBlogContentAdapter contentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_blog);
        Intent intent = getIntent();

        id = intent.getStringExtra("id");
        recyclerView = findViewById(R.id.rvcontentblog);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getdatadetailblog();
    }

    private void getdatadetailblog() {
        ApiService.endPoint().getBlogDetail(id)
                .enqueue(new Callback<ResponseBlogDetail>() {
                    @Override
                    public void onResponse(Call<ResponseBlogDetail> call, retrofit2.Response<ResponseBlogDetail> response) {
                        if (response.isSuccessful()){
                            List<Content> mListContent = response.body().getContent();
                            contentAdapter = new ListBlogContentAdapter(DetailBlogActivity.this, mListContent);
                            recyclerView.setAdapter(contentAdapter);
                            String image=response.body().getImageCover();
                            ImageView headerbg = findViewById(R.id.imgBlog);
                            Glide.with(DetailBlogActivity.this).load(image).into(headerbg);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBlogDetail> call, Throwable t) {

                    }
                });
    }
}