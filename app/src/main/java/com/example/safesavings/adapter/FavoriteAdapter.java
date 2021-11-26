package com.example.safesavings.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    private List<FavoriteList> favoriteLists;
    Context context;
    public FavoriteDatabase db;

    public FavoriteAdapter(List<FavoriteList> favoriteLists, Context context) {
        this.favoriteLists = favoriteLists;
        this.context = context;

        db = Room.databaseBuilder(context.getApplicationContext(),
                FavoriteDatabase.class, "favoriteDB").allowMainThreadQueries().build();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_favorite, viewGroup, false);
        return new ViewHolder(view);
    }

    public static final String EXTRA_MESSAGE1 = "com.example.safesavings.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.safesavings.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.safesavings.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "com.example.safesavings.MESSAGE4";
    public static final String EXTRA_MESSAGE5 = "com.example.safesavings.MESSAGE5";


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FavoriteList fl = favoriteLists.get(i);
        int posisi = i;

        String idanime = fl.getIdanime();
        String title = fl.getJudul();
        String deskripsi = fl.getDeskripsi();
        String image = fl.getImage();
        String rating = fl.getRating();

        viewHolder.title.setText(title);
        viewHolder.deksripsi.setText(deskripsi);
        viewHolder.rating.setText(rating);
        Glide.with(context).
                load(image).
                into(viewHolder.image);

        if (fl.getStatus_fav() != 1){
            viewHolder.fav_btn.setImageResource(R.drawable.ic_favorite);
        }else{
            viewHolder.fav_btn.setImageResource(R.drawable.ic_favorite_border_24);
        }

        viewHolder.fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDeteleFavorite(posisi);
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra(EXTRA_MESSAGE1, idanime);
                intent.putExtra(EXTRA_MESSAGE2, title);
                intent.putExtra(EXTRA_MESSAGE3, deskripsi);
                intent.putExtra(EXTRA_MESSAGE4, image);
                intent.putExtra(EXTRA_MESSAGE5, rating);
                context.startActivity(intent);
            }
        });
    }

    private void onDeteleFavorite(int position){
        db.favoriteDao().deleteFavorite(favoriteLists.get(position));
        favoriteLists.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeRemoved(position, favoriteLists.size());
        Toast.makeText(context, "Berhasil dihapus", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return favoriteLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image, fav_btn;
        TextView title, deksripsi, rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgMovie);
            title = itemView.findViewById(R.id.tvTitle);
            deksripsi = itemView.findViewById(R.id.tvDescription);
            rating = itemView.findViewById(R.id.rating_season);
            fav_btn = itemView.findViewById(R.id.fav_btn);
        }
    }
}
