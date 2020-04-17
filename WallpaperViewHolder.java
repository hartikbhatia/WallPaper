package com.example.hp.wall.ViewHolderPack;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.hp.wall.R;

public class WallpaperViewHolder extends RecyclerView.ViewHolder
{
   public ImageView imageView;


    public WallpaperViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView=(ImageView)itemView.findViewById(R.id.imageViewWallpaper);

    }
}
