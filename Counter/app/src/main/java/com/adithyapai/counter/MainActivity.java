package com.adithyapai.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button start , stop , reset;
    TextView t;
    int i=1;
    Handler customHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);
        t = findViewById(R.id.ip);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.post(updateTimerThread);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customHandler.removeCallbacks(updateTimerThread);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = 0;
            }
        });

    }
    Thread updateTimerThread = new Thread(){
        @Override
        public void run(){
            t.setText("" + i);
            customHandler.postDelayed(this , 1000);
            i++;
            super.run();
        }
    };

}