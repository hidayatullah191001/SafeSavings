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
import com.example.safesavings.DetailMovieActivity;
import com.example.safesavings.R;
import com.example.safesavings.model.Search;
import com.example.safesavings.model.Season;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static final String EXTRA_MESSAGE1 = "com.example.safesavings.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.safesavings.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.safesavings.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "com.example.safesavings.MESSAGE4";
    public static final String EXTRA_MESSAGE5 = "com.example.safesavings.MESSAGE5";

    @Override
    public void onBindViewHolder(@NonNull SearchAnimeAdapter.MyViewHolder holder, int position) {
        String url = searchList.get(position).getLinkId();
        String title = "Nonton " +searchList.get(position).getTitle();
        String deskripsi = searchList.get(position).getSinopsis();
        String image = searchList.get(position).getImage();
        String rating = searchList.get(position).getScore();

        holder.tvTitle.setText(title);
        holder.ratingSeason.setText(rating);
        holder.tvDescription.setText(deskripsi);

        Glide.with(context).
                load(image).
                into(holder.imgPoster);

        String id = parseUrlToGetId(url);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra(EXTRA_MESSAGE1, id);
                intent.putExtra(EXTRA_MESSAGE2, title);
                intent.putExtra(EXTRA_MESSAGE3, deskripsi);
                intent.putExtra(EXTRA_MESSAGE4, image);
                intent.putExtra(EXTRA_MESSAGE5, rating);
                context.startActivity(intent);
            }
        });
    }

    public static String parseUrlToGetId(String urll)
    {
        String url = urll;
        Pattern p = Pattern.compile("/anime/(.+)/");
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
        return searchList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvDescription, ratingSeason;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ratingSeason = itemView.findViewById(R.id.rating_season);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
