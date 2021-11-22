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
import com.example.safesavings.adapter.ListBlogAdapter;
import com.example.safesavings.model.Blog;
import com.example.safesavings.model.ResponseBlog;
import com.example.safesavings.rest.ApiEndPoint;
import com.example.safesavings.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class FragmentBlog extends Fragment {
    private ListBlogAdapter AdapterList;
    private SearchView searchView;
    RecyclerView recyclerView;
    ApiEndPoint apiInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        recyclerView = view.findViewById(R.id.rvlistanime);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        getDataFromListBlog();
        return view;

    }

    private void getDataFromListBlog() {
        ApiService.endPoint().getDataListBlog()
                .enqueue(new Callback<ResponseBlog>() {
                    @Override
                    public void onResponse(Call<ResponseBlog> call, retrofit2.Response<ResponseBlog> response) {
                        if (response.isSuccessful()){
                            List<Blog> mListBlog = response.body().getBlog();
                            AdapterList = new ListBlogAdapter(getActivity(),mListBlog);
                            recyclerView.setAdapter(AdapterList);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBlog> call, Throwable t) {

                    }
                });
    }
}

