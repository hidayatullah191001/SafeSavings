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
import com.example.safesavings.model.ListAnime;

import java.util.List;

public class ListAnimeAdapter extends RecyclerView.Adapter<ListAnimeAdapter.MyViewHolder> {

    private Context context;
    private List<ListAnime> animeList;

    public ListAnimeAdapter(Context context, List<ListAnime> animeList) {
        this.context = context;
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public ListAnimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_list_anime, parent, false);

        ListAnimeAdapter.MyViewHolder viewHolder = new ListAnimeAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAnimeAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(animeList.get(position).getTitle());
        holder.tvDescription.setText(animeList.get(position).getSinopsis());
        holder.score.setText(animeList.get(position).getScore());
        holder.view.setText(animeList.get(position).getView());
        Glide.with(context).
                load(animeList.get(position).getImage()).
                into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvDescription,score,view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            score = itemView.findViewById(R.id.score);
            view = itemView.findViewById(R.id.view);
        }
    }
}
