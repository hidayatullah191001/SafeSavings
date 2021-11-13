package com.example.safesavings.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safesavings.DetailMovieActivity;
import com.example.safesavings.MainActivity;
import com.example.safesavings.R;
import com.example.safesavings.fragment.FragmentHome;

import java.util.LinkedList;

public class PaginationAdapter extends RecyclerView.Adapter<PaginationAdapter.MyViewHolder> {

    private Context context;
    private final LinkedList<Integer> mWordList;
    public static int mCurrent;

    public PaginationAdapter(Context context, LinkedList<Integer> wordList) {;
        this.mWordList = wordList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View mItemView = inflater.inflate(R.layout.item_page, parent, false);
        return new MyViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        mCurrent = mWordList.get(position);
        int data = Integer.valueOf(mCurrent);
        holder.wordItemView.setText(String.valueOf(mCurrent));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("IntentPage", data);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public final TextView wordItemView;
        final PaginationAdapter mAdapter;

        public MyViewHolder(View itemView, PaginationAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.pageCount);
            this.mAdapter = adapter;
        }
    }
}
