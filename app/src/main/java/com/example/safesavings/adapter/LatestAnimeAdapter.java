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

import java.util.List;

public class LatestAnimeAdapter extends RecyclerView.Adapter<LatestAnimeAdapter.MyViewHolder> {
    private Context context;
    private List<Latest> latestList;

    public LatestAnimeAdapter(Context context, List<Latest> latestList) {
        this.context = context;
        this.latestList = latestList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_latest, parent, false);

        LatestAnimeAdapter.MyViewHolder viewHolder = new LatestAnimeAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTitle.setText(latestList.get(position).getTitle());
        holder.tvDescription.setText(latestList.get(position).getReleaseTime());
        Glide.with(context).
                load(latestList.get(position).getImage()).
                into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return latestList.size();
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
