package com.example.safesavings.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.safesavings.R;
import com.example.safesavings.adapter.LatestAnimeAdapter;
import com.example.safesavings.adapter.PaginationAdapter;
import com.example.safesavings.adapter.SeasonAnimeAdapter;
import com.example.safesavings.favorite.FavoriteDatabase;
import com.example.safesavings.favorite.FavoriteList;
import com.example.safesavings.model.Latest;
import com.example.safesavings.model.Response;
import com.example.safesavings.model.Season;
import com.example.safesavings.rest.ApiService;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class FragmentHome extends Fragment {
    private static final String TAG = "MainActivity";
    private SeasonAnimeAdapter adapterSeason;
    private LatestAnimeAdapter adapterLatest;
    private PaginationAdapter mAdapter;

    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerViewPage;

    private final LinkedList<Integer> mWordList = new LinkedList<>();
    public static int pageIntent;
    public static FavoriteDatabase db;
    private List<FavoriteList> mlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView1 = view.findViewById(R.id.rvSeason);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView2 = view.findViewById(R.id.rvLatest);

        /*Deklarasi Pagination */
        recyclerViewPage = view.findViewById(R.id.rvPagination);

        db = Room.databaseBuilder(getActivity(),
                FavoriteDatabase.class, "favoriteDB").allowMainThreadQueries().build();

        pagination();
        getDataFromSeason(pageIntent);
        return view;
    }

    private void getDataFromSeason(int data) {
        ApiService.endPoint().getDataSeason(data)
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

    private void pagination(){
        for (int i = 1; i <= 20; i++) {
            mWordList.addLast(i);
        }
        mAdapter = new PaginationAdapter(getActivity(), mWordList);
        recyclerViewPage.setAdapter(mAdapter);
        pageIntent = getActivity().getIntent().getIntExtra("IntentPage", 1);
        Toast.makeText(getActivity(), "Halaman : " + pageIntent, Toast.LENGTH_SHORT).show();
    }
}
