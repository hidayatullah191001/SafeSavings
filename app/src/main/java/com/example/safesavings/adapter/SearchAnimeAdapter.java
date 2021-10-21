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
import com.example.safesavings.model.Search;
import com.example.safesavings.model.Season;

import java.util.List;

public class SearchAnimeAdapter extends RecyclerView.Adapter<SearchAnimeAdapter.MyViewHolder> {

    private Context context;
    private List<Search> searchList;

    public SearchAnimeAdapter(Context context, List<Search> searchList) {
        this.context = context;
        this.searchList = searchList;
    }

    @NonNull
    @Override
    public SearchAnimeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_search, parent, false);

        SearchAnimeAdapter.MyViewHolder viewHolder = new SearchAnimeAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAnimeAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(searchList.get(position).getTitle());
        holder.tvDescription.setText(searchList.get(position).getSinopsis());
        Glide.with(context).
                load(searchList.get(position).getImage()).
                into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return searchList.size();
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
