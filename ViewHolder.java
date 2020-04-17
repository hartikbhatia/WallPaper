package com.example.hp.wall;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

       public TextView mTitle;
        public ImageView mImage;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
       mTitle = itemView.findViewById(R.id.rTitleTv);
         mImage = itemView.findViewById(R.id.rImage);


    }
}


