package com.annasblackhat.sesi3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView txtTitle, txtDate;

    public NewsViewHolder(View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.imageView);
        txtTitle = itemView.findViewById(R.id.txt_title);
        txtDate = itemView.findViewById(R.id.txt_date);
    }
}
