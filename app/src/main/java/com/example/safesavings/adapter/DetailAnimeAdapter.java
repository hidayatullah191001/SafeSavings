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
import com.example.safesavings.model.ResponseDetail;
import com.example.safesavings.model.Season;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailAnimeAdapter extends RecyclerView.Adapter<DetailAnimeAdapter.MyViewHolder> {

    private Context context;
    private List<DetailAnime> DetailAnimeList;
    private List<ResponseDetail> responseDetailList;

    public DetailAnimeAdapter(Context context, List<DetailAnime> detailAnimeList) {
        this.context = context;
        this.DetailAnimeList = detailAnimeList;
    }

    @NonNull
    @Override
    public DetailAnimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_season, parent, false);
        DetailAnimeAdapter.MyViewHolder viewHolder = new DetailAnimeAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAnimeAdapter.MyViewHolder holder, int position) {

        holder.txtjudul.setText(responseDetailList.get(position).getTitle());
        holder.txtdeskripsi.setText(responseDetailList.get(position).getSinopsis());
        Glide.with(context).
                load(responseDetailList.get(position).getImage()).
                into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return DetailAnimeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView txtjudul, txtdeskripsi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgDetailAnime);
            txtjudul = itemView.findViewById(R.id.txtJudulAnime);
            txtdeskripsi= itemView.findViewById(R.id.txtDetailDeskripsi);
        }
    }
}
