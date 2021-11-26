package com.example.safesavings.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.example.safesavings.DetailMovieActivity;
import com.example.safesavings.R;
import com.example.safesavings.favorite.FavoriteDatabase;
import com.example.safesavings.favorite.FavoriteList;
import com.example.safesavings.fragment.FragmentFavorite;
import com.example.safesavings.fragment.FragmentHome;
import com.example.safesavings.model.Season;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeasonAnimeAdapter extends RecyclerView.Adapter<SeasonAnimeAdapter.MyViewHolder> {

    private Context context;
    private List<Season> seasonList;
    private List<FavoriteList> favoriteLists;
    private FavoriteDatabase db;
    private String TAG = "MainActivity";

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

    public static final String EXTRA_MESSAGE1 = "com.example.safesavings.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.safesavings.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.safesavings.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "com.example.safesavings.MESSAGE4";
    public static final String EXTRA_MESSAGE5 = "com.example.safesavings.MESSAGE5";

    @Override
    public void onBindViewHolder(@NonNull SeasonAnimeAdapter.MyViewHolder holder, int position) {
        FavoriteList favoriteList = new FavoriteList();
        int posisi = position;

        String url = seasonList.get(position).getLinkId();
        String title = "Nonton"+seasonList.get(position).getTitle();
        String deskripsi = seasonList.get(position).getSinopsis();
        String image = seasonList.get(position).getImage();
        String rating = seasonList.get(position).getRating();

        holder.tvTitle.setText(title);
        holder.ratingSeason.setText(rating);
        holder.tvDescription.setText(deskripsi);

        Glide.with(context).
                load(image).
                into(holder.imgPoster);

        String id = parseUrlToGetId(url);
        Log.d(TAG, "onBindViewHolder: " + id);
        db = Room.databaseBuilder(context.getApplicationContext(),
                FavoriteDatabase.class, "favoriteDB").build();

        if (FragmentHome.db.favoriteDao().isFavorite(id) == 1){
            holder.fav_btn.setImageResource(R.drawable.ic_favorite);
        }else{
            holder.fav_btn.setImageResource(R.drawable.ic_favorite_border_24);
            holder.fav_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int status_fav = 0;
                    favoriteList.setIdanime(id);
                    favoriteList.setJudul(title);
                    favoriteList.setDeskripsi(deskripsi);
                    favoriteList.setRating(rating);
                    favoriteList.setImage(image);
                    favoriteList.setStatus_fav(status_fav);

                    if (FragmentHome.db.favoriteDao().isFavorite(id) != 1){
                        holder.fav_btn.setImageResource(R.drawable.ic_favorite);
                        insertData(favoriteList);
                    }else{
                        holder.fav_btn.setImageResource(R.drawable.ic_favorite_border_24);
                    }
                }
            });
        }

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

    private void insertData(final FavoriteList favoriteList){

        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.favoriteDao().addData(favoriteList);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(context, "Berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    @Override
    public int getItemCount() {
        return seasonList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster, fav_btn;
        TextView tvTitle, tvDescription, ratingSeason;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ratingSeason = itemView.findViewById(R.id.rating_season);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            fav_btn = itemView.findViewById(R.id.fav_btn);
        }
    }
}
