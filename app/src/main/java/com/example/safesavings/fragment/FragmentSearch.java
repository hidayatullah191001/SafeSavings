package com.example.safesavings.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safesavings.R;
import com.example.safesavings.adapter.SearchAnimeAdapter;
import com.example.safesavings.model.Search;
import com.example.safesavings.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSearch extends Fragment {
    private SearchAnimeAdapter adapterSearch;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = view.findViewById(R.id.rvSearch);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newtext) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newtext) {
                if(newtext.length() > 1 ){
                    ApiService.endPoint().getDataSearch(newtext)
                            .enqueue(new Callback<com.example.safesavings.model.Response>() {
                                @Override
                                public void onResponse(Call<com.example.safesavings.model.Response> call, retrofit2.Response<com.example.safesavings.model.Response> response) {
                                    if (response.isSuccessful()){
                                        List<Search> mSearch = response.body().getResults();
                                        adapterSearch = new SearchAnimeAdapter(getActivity(),mSearch);
                                        recyclerView.setAdapter(adapterSearch);
                                    }
                                }
                                @Override
                                public void onFailure(Call<com.example.safesavings.model.Response> call, Throwable t) {

                                }
                            });
                }
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}

