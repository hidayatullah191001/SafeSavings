package com.example.safesavings.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safesavings.DetailEpisode;
import com.example.safesavings.R;
import com.example.safesavings.model.Datum;
import com.example.safesavings.model.DownloadEp;
import com.example.safesavings.model.ListEpisode;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DownloadEpisodeAnimeAdapter extends RecyclerView.Adapter<DownloadEpisodeAnimeAdapter.MyViewHolder> {

    private Context context;
    private List<DownloadEp> downloadEps;
    private LinkEpisodeAnimeAdapter linkEpisodeAnimeAdapter;

    public DownloadEpisodeAnimeAdapter(Context context, List<DownloadEp> downloadEps) {
        this.context = context;
        this.downloadEps = downloadEps;
    }

    @NonNull
    @Override
    public DownloadEpisodeAnimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_download, parent, false);
        DownloadEpisodeAnimeAdapter.MyViewHolder viewHolder = new DownloadEpisodeAnimeAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DownloadEpisodeAnimeAdapter.MyViewHolder holder, int position) {
        holder.txtFormat.setText(downloadEps.get(position).getFormat());
        List<Datum> mdatum = downloadEps.get(position).getData();
        linkEpisodeAnimeAdapter = new LinkEpisodeAnimeAdapter(context,mdatum);
        holder.recyclerView.setAdapter(linkEpisodeAnimeAdapter);
    }

    @Override
    public int getItemCount() {
        return downloadEps.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtFormat;
        RecyclerView recyclerView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFormat = itemView.findViewById(R.id.format);
            recyclerView = itemView.findViewById(R.id.rvlinkdownload);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
    }
}
