package com.example.hp.wall;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.hp.wall.Helper.SaveImageHelper;
import com.example.hp.wall.Utils.Utils;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.UUID;

public class ViewWallpaperActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton fabDownload,fabWallpaper;
    ImageView i1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wallpaper);

       final Target target= new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        intialize();

        Picasso.get().load(Utils.selected_wallpaper.getImage()).into(i1);
        fabWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.get().load(Utils.selected_wallpaper.getImage()).into(target);
            }
        });
        fabDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName= UUID.randomUUID().toString()+".png";
                AlertDialog.Builder b=new AlertDialog.Builder(ViewWallpaperActivity.this);
                b.setMessage("Downloading...");
                AlertDialog alertDialog=b.create();
                alertDialog.show();


                Picasso.get().load(Utils.selected_wallpaper.getImage()).into(new SaveImageHelper(getBaseContext(),alertDialog,getApplicationContext().getContentResolver(),fileName,"Mini Image"));
            }
        });




    }

    private void intialize() {
        i1=(ImageView)findViewById(R.id.thumbImage);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsingToolbarlayout);
        fabDownload=(FloatingActionButton)findViewById(R.id.fab_download);
        fabWallpaper=(FloatingActionButton)findViewById(R.id.fab_wallpaper);
        collapsingToolbarLayout.setTitle(Utils.CATEGORY_SELECTED);



    }
}
