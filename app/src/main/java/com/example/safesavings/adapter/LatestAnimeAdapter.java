package com.example.safesavings.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.safesavings.DetailEpisode;
import com.example.safesavings.R;
import com.example.safesavings.model.Latest;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static final String EXTRA_MESSAGE1 = "com.example.safesavings.MESSAGE1";

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String url = latestList.get(position).getLink();
        String id = parseUrlToGetId(url);

        holder.tvTitle.setText(latestList.get(position).getTitle());
        holder.tvDescription.setText(latestList.get(position).getReleaseTime());
        Glide.with(context).
                load(latestList.get(position).getImage()).
                into(holder.imgPoster);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailEpisode.class);
                intent.putExtra(EXTRA_MESSAGE1, id);
                context.startActivity(intent);
            }
        });
    }

    public static String parseUrlToGetId(String urll)
    {
        String url = urll;
        Pattern p = Pattern.compile("/194.163.183.129/(.+)/");
        Matcher m = p.matcher(url);
        if (m.find()){
            String result = m.group(1);
            return result;
        }else{
            return url;
        }
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
