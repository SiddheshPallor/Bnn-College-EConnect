package com.example.bnncollegee_connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

public class FullImageViewActivity extends AppCompatActivity {

    private PhotoView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);
        getSupportActionBar().hide();

        imageView = findViewById(R.id.imageView);


        String noticeImg = getIntent().getStringExtra("noticeImg");

        Glide.with(this).load(noticeImg).into(imageView);


    }
}