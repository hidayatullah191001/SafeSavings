package com.example.safesavings.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safesavings.DetailEpisode;
import com.example.safesavings.R;
import com.example.safesavings.model.Datum;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class LinkEpisodeAnimeAdapter extends RecyclerView.Adapter<LinkEpisodeAnimeAdapter.MyViewHolder> {

    private Context context;
    private List<Datum> datumList;

    public LinkEpisodeAnimeAdapter(Context context, List<Datum> datumList) {
        this.context = context;
        this.datumList = datumList;
    }

    @NonNull
    @Override
    public LinkEpisodeAnimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_eps, parent, false);
        LinkEpisodeAnimeAdapter.MyViewHolder viewHolder = new LinkEpisodeAnimeAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LinkEpisodeAnimeAdapter.MyViewHolder holder, int position) {
        String urlzippy = "<a href="+'"'+datumList.get(position).getLink().getZippyshare()+'"'+">Zippyshare</a>";
        String urlgdrive = "<a href="+'"'+datumList.get(position).getLink().getGdrive()+'"'+">GDrive</a>";
        String urlreupload = "<a href="+'"'+datumList.get(position).getLink().getReupload()+'"'+">ReUpload</a>";

        holder.quality.setText(datumList.get(position).getQuality());

        holder.zippy.setText(Html.fromHtml(urlzippy));
        holder.zippy.setMovementMethod(LinkMovementMethod.getInstance());

        holder.gdrive.setText(Html.fromHtml(urlgdrive));
        holder.gdrive.setMovementMethod(LinkMovementMethod.getInstance());

        holder.reupload.setText(Html.fromHtml(urlreupload));
        holder.reupload.setMovementMethod(LinkMovementMethod.getInstance());

    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView quality,zippy,gdrive,reupload;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            quality = itemView.findViewById(R.id.quality);
            zippy = itemView.findViewById(R.id.zippyshare);
            gdrive = itemView.findViewById(R.id.gdrive);
            reupload = itemView.findViewById(R.id.reupload);
        }
    }
}
