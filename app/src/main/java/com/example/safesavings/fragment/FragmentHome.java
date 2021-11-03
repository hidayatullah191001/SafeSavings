package com.example.safesavings.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safesavings.MainActivity;
import com.example.safesavings.R;
import com.example.safesavings.adapter.LatestAnimeAdapter;
import com.example.safesavings.adapter.SeasonAnimeAdapter;
import com.example.safesavings.model.Latest;
import com.example.safesavings.model.Response;
import com.example.safesavings.model.Season;
import com.example.safesavings.rest.ApiEndPoint;
import com.example.safesavings.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class FragmentHome extends Fragment {
    private SeasonAnimeAdapter adapterSeason;
    private LatestAnimeAdapter adapterLatest;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView1 = view.findViewById(R.id.rvSeason);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView2 = view.findViewById(R.id.rvLatest);
        getDataFromSeason();
        return view;
    }
    private void getDataFromSeason() {
        ApiService.endPoint().getDataSeason()
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if (response.isSuccessful()){
                            List<Season> mSeason = response.body().getSeason();
                            adapterSeason = new SeasonAnimeAdapter(getActivity(),mSeason);
                            recyclerView1.setAdapter(adapterSeason);
                            List<Latest> mLatest = response.body().getLatest();
                            adapterLatest = new LatestAnimeAdapter(getActivity(), mLatest);
                            recyclerView2.setAdapter(adapterLatest);
                        }
                    }
                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                    }
                });
    }
}
