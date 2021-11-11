package com.example.safesavings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safesavings.R;
import com.example.safesavings.model.ListEpisode;

import java.util.List;


public class ListEpisodeAnimeAdapter extends RecyclerView.Adapter<ListEpisodeAnimeAdapter.MyViewHolder> {

    private Context context;
    private List<ListEpisode> episodeList;

    public ListEpisodeAnimeAdapter(Context context, List<ListEpisode> episodeList) {
        this.context = context;
        this.episodeList = episodeList;
    }

    @NonNull
    @Override
    public ListEpisodeAnimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_list_episode, parent, false);

        ListEpisodeAnimeAdapter.MyViewHolder viewHolder = new ListEpisodeAnimeAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListEpisodeAnimeAdapter.MyViewHolder holder, int position) {
        holder.txtEpisode.setText(episodeList.get(position).getEpisode());
        holder.txtTitleEpisode.setText(episodeList.get(position).getTitle());
        holder.txtDateEpisode.setText(episodeList.get(position).getDateUploaded());
    }

    @Override
    public int getItemCount() {
        return episodeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtEpisode, txtTitleEpisode, txtDateEpisode;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEpisode = itemView.findViewById(R.id.episode);
            txtTitleEpisode = itemView.findViewById(R.id.title_episode);
            txtDateEpisode = itemView.findViewById(R.id.txtDate_uploaded);
        }
    }
}
