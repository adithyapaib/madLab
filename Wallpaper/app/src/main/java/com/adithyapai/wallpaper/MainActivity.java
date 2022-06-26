package com.adithyapai.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btn = findViewById(R.id.button);
    private WallpaperManager wallpaperManager = null;
    Bitmap wlp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wallpaperManager = WallpaperManager.getInstance(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                wlp1 = BitmapFactory.decodeResource(getResources(), R.drawable.oneplus_7t);
                // DisplayMetrics metrics = new DisplayMetrics();
                //getWindowManager().getDefaultDisplay().getMetrics(metrics);
               // int height = metrics.heightPixels;
               // int width = metrics.widthPixels;
               // Bitmap scaledWlp1 = Bitmap.createScaledBitmap(wlp1,width,height,false);
                try {
                    wallpaperManager.setBitmap(wlp1);
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });
    }
}