package com.example.hp.wall;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.hp.wall.ModelPack.WallpaperItem;
import com.example.hp.wall.Utils.Utils;
import com.example.hp.wall.ViewHolderPack.WallpaperViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class ListWallpaperActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Query query;

    FirebaseRecyclerOptions<WallpaperItem> options;
    FirebaseRecyclerAdapter<WallpaperItem, WallpaperViewHolder> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_wallpaper);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_list_wallpaper);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewWall);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        query = FirebaseDatabase.getInstance().getReference("Background")
                .orderByChild("categoryId").equalTo(Utils.CATEGORY_ID);

        options = new FirebaseRecyclerOptions.Builder<WallpaperItem>()
                .setQuery(query, WallpaperItem.class).build();

        adapter = new FirebaseRecyclerAdapter<WallpaperItem, WallpaperViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull WallpaperViewHolder holder, final int position, @NonNull final WallpaperItem model) {

                Picasso.get().load(model.getImage()).into(holder.imageView);

                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.CATEGORY_ID=adapter.getRef(position).getKey();
                        Utils.CATEGORY_SELECTED=model.categoryId;
                        Utils.selected_wallpaper=model;
                        Intent i=new Intent(getApplicationContext(),ViewWallpaperActivity.class);
                        startActivity(i);
                    }
                });


            }

            @NonNull
            @Override
            public WallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

                View v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_wallpaper_item, parent, false);

                int height = parent.getMeasuredHeight() / 2;
                v.setMinimumHeight(height);


                return new WallpaperViewHolder(v);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    protected void onStart() {

        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }
    }
}