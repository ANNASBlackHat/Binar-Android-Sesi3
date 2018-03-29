package com.annasblackhat.sesi3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private List<News> newsList;
    private final int TYPE_HEADER = 1;
    private final int TYPE_ITEM = 2;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEADER;
        }else {
            return TYPE_ITEM;
        }
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if(viewType == TYPE_HEADER){
            view = inflater.inflate(R.layout.list_item_news_header, parent, false);
        }else{
            view = inflater.inflate(R.layout.list_item_news, parent, false);
        }
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {
        News news = newsList.get(position);
        holder.txtTitle.setText(news.getTitle());
        holder.txtDate.setText(news.getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("position : "+position);
                System.out.println("adapter position : "+holder.getAdapterPosition());

                //do not use position, but use getAdapterPosition()
                newsList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
