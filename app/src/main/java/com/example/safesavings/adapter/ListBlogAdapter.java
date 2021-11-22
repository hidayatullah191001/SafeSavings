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

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListBlogAdapter extends RecyclerView.Adapter<ListBlogAdapter.MyViewHolder> {

    private Context context;
    private List<Blog> BlogList;

    public ListBlogAdapter(Context context, List<Blog> BlogList) {
        this.context = context;
        this.BlogList = BlogList;
    }

    @NonNull
    @Override
    public ListBlogAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_blog, parent, false);

        ListBlogAdapter.MyViewHolder viewHolder = new ListBlogAdapter.MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListBlogAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(BlogList.get(position).getTitle());
        holder.tvSub.setText(BlogList.get(position).getSub());
        holder.date.setText(BlogList.get(position).getDate());
        Glide.with(context).
                load(BlogList.get(position).getImage()).
                into(holder.blogImages);
        String url=BlogList.get(position).getLinkId();
        String id=parseUrlToGetId(url);
        Log.d("MainActivity","onBindViewHolder: "+ id);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailBlogActivity.class);
                intent.putExtra("id",id );
                context.startActivity(intent);
            }
        });
    }
    public static String parseUrlToGetId(String urll)
    {
        String url = urll;
        Pattern p = Pattern.compile("/blog/(.+)/");
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
        return BlogList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView blogImages;
        TextView tvTitle, tvSub,date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            blogImages = itemView.findViewById(R.id.sportsImage);
            tvTitle = itemView.findViewById(R.id.tittle);
            tvSub = itemView.findViewById(R.id.sub);
            date = itemView.findViewById(R.id.date);
        }
    }
}
