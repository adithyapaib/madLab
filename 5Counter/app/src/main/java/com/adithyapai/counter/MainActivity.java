package com.adithyapai.counter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Button startBtn, stopBtn, resetBtn;
    TextView textView;
    int i = 1;
    Handler customHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = findViewById(R.id.start);
        stopBtn = findViewById(R.id.stop);
        resetBtn = findViewById(R.id.reset);
        textView = findViewById(R.id.ip);
        startBtn.setOnClickListener(view ->
                customHandler.postDelayed(updateTimerThread, 1000));
        stopBtn.setOnClickListener(view ->
                customHandler.removeCallbacks(updateTimerThread));
        resetBtn.setOnClickListener(view -> i = 1);
    }

    private Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            textView.setText(String.valueOf(i));
            i++;
            customHandler.postDelayed(this, 1000);
        }
    };
}