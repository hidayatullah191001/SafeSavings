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
import com.example.safesavings.model.Latest;
import com.example.safesavings.model.Season;

import java.util.List;

public class SeasonAnimeAdapter extends RecyclerView.Adapter<SeasonAnimeAdapter.MyViewHolder> {

    private Context context;
    private List<Season> seasonList;

    public SeasonAnimeAdapter(Context context, List<Season> seasonList) {
        this.context = context;
        this.seasonList = seasonList;
    }

    @NonNull
    @Override
    public SeasonAnimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_season, parent, false);

        SeasonAnimeAdapter.MyViewHolder viewHolder = new SeasonAnimeAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeasonAnimeAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(seasonList.get(position).getTitle());
        holder.tvDescription.setText(seasonList.get(position).getSinopsis());
        Glide.with(context).
                load(seasonList.get(position).getImage()).
                into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return seasonList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
