package com.example.safesavings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;

import com.example.safesavings.adapter.LatestAnimeAdapter;
import com.example.safesavings.adapter.SeasonAnimeAdapter;
import com.example.safesavings.model.Latest;
import com.example.safesavings.model.Response;
import com.example.safesavings.model.Season;
import com.example.safesavings.rest.ApiService;
import com.example.safesavings.rest.ApiEndPoint;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity {

    private SeasonAnimeAdapter adapterSeason;
    private LatestAnimeAdapter adapterLatest;
    private SearchView searchView;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    ApiEndPoint apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView1 = findViewById(R.id.rvSeason);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recyclerView2 = findViewById(R.id.rvLatest);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        getDataFromSeason();
    }

    private void getDataFromSeason() {
        ApiService.endPoint().getDataSeason()
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if (response.isSuccessful()){
                            List<Season> mSeason = response.body().getSeason();
                            adapterSeason = new SeasonAnimeAdapter(MainActivity.this, mSeason);
                            recyclerView1.setAdapter(adapterSeason);
                            List<Latest> mLatest = response.body().getLatest();
                            adapterLatest = new LatestAnimeAdapter(MainActivity.this, mLatest);
                            recyclerView2.setAdapter(adapterLatest);
                        }
                    }
                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}