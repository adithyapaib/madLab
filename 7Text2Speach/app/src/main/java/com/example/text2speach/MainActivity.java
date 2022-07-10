package com.example.text2speach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech tt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText t = findViewById(R.id.text);
        Button b = findViewById(R.id.button);

         tt = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
          @Override
          public void onInit(int i) {
                if(i == TextToSpeech.SUCCESS){
                    tt.setLanguage(Locale.ENGLISH);
                }

          }
      });

       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               tt.speak(t.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
           }
       });


    }
}