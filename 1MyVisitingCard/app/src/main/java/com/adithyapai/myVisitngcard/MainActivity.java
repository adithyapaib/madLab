package com.adithyapai.myVisitngcard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.yellow));
            t = findViewById(R.id.textView4);
            String s  = " <p> Name :  <b>Adithya Pai B</b> <br> Position : <b> UI Developer </b> <br> Email : <b> <a href=\\\"mailto:adithyapaib@gmail.comk\\\">\n" +
                    "adithyapaib@gmail.com</a> </b> <br> Phone: +91 9108846924 </p>";
            t.setText(Html.fromHtml(s));

    }
}