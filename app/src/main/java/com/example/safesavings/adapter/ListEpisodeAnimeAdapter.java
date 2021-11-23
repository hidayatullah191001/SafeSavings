package com.example.safesavings.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safesavings.DetailEpisode;
import com.example.safesavings.R;
import com.example.safesavings.model.ListEpisode;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    public static final String EXTRA_MESSAGE1 = "com.example.safesavings.MESSAGE1";

    @Override
    public void onBindViewHolder(@NonNull ListEpisodeAnimeAdapter.MyViewHolder holder, int position) {
        String url = episodeList.get(position).getLink();
        String id = parseUrlToGetId(url);
        Log.d("MainActivity", "onBindViewHolder: " + id);
        holder.txtEpisode.setText(episodeList.get(position).getEpisode());
        holder.txtTitleEpisode.setText(episodeList.get(position).getTitle());
        holder.txtDateEpisode.setText(episodeList.get(position).getDateUploaded());
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
