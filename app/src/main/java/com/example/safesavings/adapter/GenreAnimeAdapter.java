package com.example.safesavings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.safesavings.R;
import com.example.safesavings.model.DetailAnime;
import com.example.safesavings.model.Genre;
import com.example.safesavings.model.ResponseDetail;

import java.util.List;

public class GenreAnimeAdapter extends RecyclerView.Adapter<GenreAnimeAdapter.MyViewHolder> {

    private Context context;
    private List<Genre> genreList;

    public GenreAnimeAdapter(Context context, List<Genre> genreList) {
        this.context = context;
        this.genreList = genreList;
    }

    @NonNull
    @Override
    public GenreAnimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_genre, parent, false);
        GenreAnimeAdapter.MyViewHolder viewHolder = new GenreAnimeAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GenreAnimeAdapter.MyViewHolder holder, int position) {

        holder.txtjudul.setText(genreList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtjudul;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtjudul = itemView.findViewById(R.id.txtgenre);
        }
    }
}
