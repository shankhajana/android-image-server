package com.shankhajana.imageCapture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FullScreenActivity extends AppCompatActivity {
    ImageView fullScreenImage;
    String url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        url = getIntent().getStringExtra("image_url");
        Log.e("URl",""+url);
        fullScreenImage = findViewById(R.id.fullImage);
        Glide.with(this).load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(fullScreenImage);
    }
}