package com.example.safesavings.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safesavings.R;
import com.example.safesavings.adapter.LatestAnimeAdapter;
import com.example.safesavings.adapter.ListAnimeAdapter;
import com.example.safesavings.adapter.SeasonAnimeAdapter;
import com.example.safesavings.model.Latest;
import com.example.safesavings.model.ListAnime;
import com.example.safesavings.model.Response;
import com.example.safesavings.model.ResponseList;
import com.example.safesavings.model.Season;
import com.example.safesavings.rest.ApiEndPoint;
import com.example.safesavings.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class FragmentList extends Fragment {
    private ListAnimeAdapter AdapterList;
    private SearchView searchView;
    RecyclerView recyclerView;
    ApiEndPoint apiInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.rvlistanime);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        getDataFromListAnime();
        return view;

    }

    private void getDataFromListAnime() {
        ApiService.endPoint().getDataListAnime()
                .enqueue(new Callback<ResponseList>() {
                    @Override
                    public void onResponse(Call<ResponseList> call, retrofit2.Response<ResponseList> response) {
                        if (response.isSuccessful()){
                            List<ListAnime> mListAnime = response.body().getListanime();
                            AdapterList = new ListAnimeAdapter(getActivity(),mListAnime);
                            recyclerView.setAdapter(AdapterList);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseList> call, Throwable t) {

                    }
                });
    }
}

