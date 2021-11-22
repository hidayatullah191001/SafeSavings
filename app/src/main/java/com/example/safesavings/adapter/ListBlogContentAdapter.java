package com.example.safesavings.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.safesavings.DetailBlogActivity;
import com.example.safesavings.R;
import com.example.safesavings.model.Blog;
import com.example.safesavings.model.Content;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListBlogContentAdapter extends RecyclerView.Adapter<ListBlogContentAdapter.MyViewHolder> {

    private Context context;
    private List<Content> ContentList;

    public ListBlogContentAdapter(Context context, List<Content> ContentList) {
        this.context = context;
        this.ContentList = ContentList;
    }

    @NonNull
    @Override
    public ListBlogContentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_contentblog, parent, false);

        ListBlogContentAdapter.MyViewHolder viewHolder = new ListBlogContentAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListBlogContentAdapter.MyViewHolder holder, int position) {
        holder.isiblog.setText(ContentList.get(position).getText());

    }


    @Override
    public int getItemCount() {
        return ContentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView isiblog;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            isiblog = itemView.findViewById(R.id.isiBlog);
        }
    }
}
