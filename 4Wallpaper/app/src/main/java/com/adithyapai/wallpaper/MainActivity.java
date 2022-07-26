package com.adithyapai.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btn;
    WallpaperManager wallpaperManager;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wallpaperManager = WallpaperManager.getInstance(this);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            try {
                wallpaperManager.setResource(R.drawable.b);
                Thread.sleep(5000);
                wallpaperManager.setResource(R.drawable.a);
                Thread.sleep(5000);
                wallpaperManager.setResource(R.drawable.c);
                Toast.makeText(this, "Done", 2).show();
                return;

            } catch (IOException | InterruptedException e) {
                Toast.makeText(this, "Done", 2).show();
                e.printStackTrace();
                return;
            }

        });
    }
}
