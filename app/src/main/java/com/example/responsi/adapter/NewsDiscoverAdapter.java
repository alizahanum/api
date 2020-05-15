package com.example.responsi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.responsi.R;
import com.example.responsi.model.ArticlesItem;

import java.util.ArrayList;

public class NewsDiscoverAdapter extends RecyclerView.Adapter<NewsDiscoverAdapter.ViewHolder> {
    private ArrayList<ArticlesItem> articlesItems = new ArrayList<>();
    private Context context;
    private static String BASE_IMAGE_URL = "https://images.wsj.net/";

    public NewsDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ArticlesItem> items){
        articlesItems.clear();
        articlesItems.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public NewsDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsDiscoverAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(BASE_IMAGE_URL+articlesItems.get(position)
                .getUrlToImage()).into(holder.ivNews);

        holder.tvTitle.setText(articlesItems.get(position).getTitle());
        holder.tvAuthor.setText(articlesItems.get(position).getAuthor());

    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivNews;
        TextView tvTitle,tvAuthor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivNews = itemView.findViewById(R.id.ivNews);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
        }
    }
}
