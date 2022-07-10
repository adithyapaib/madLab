package com.adithyapai.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    EditText n1, n2;
    TextView res ;
    Button add ,sub ,mul ,div ,clr;
    double num1 , num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.result);
        n1 = findViewById(R.id.numb1);
        n2 = findViewById(R.id.numb2);
        add = findViewById(R.id.plus);
        sub = findViewById(R.id.minus);
        mul = findViewById(R.id.multiply);
        div = findViewById(R.id.divide);
        clr = findViewById(R.id.clear);
        add.setOnClickListener(view -> res.setText(new String(String.valueOf( getNums(1)))));
        sub.setOnClickListener(view -> res.setText(new String(String.valueOf(getNums(2)))));
        mul.setOnClickListener(view -> res.setText(new String(String.valueOf(getNums(3)))));
        div.setOnClickListener(view -> res.setText(new String(String.valueOf(getNums(4)))));
        clr.setOnClickListener(view -> {n1.setText("0");n2.setText("0");res.setText("0");});}
    double getNums(int n){
        try{
            num1 = Double.parseDouble(String.valueOf(n1.getText()));
            num2 = Double.parseDouble(String.valueOf(n2.getText()));
            return n == 1 ? num1 + num2 : n == 2 ? num1 - num2 : n == 3 ? num1 * num2 : num1 / num2;
        }catch (Exception e){
            res.setText("Error");
        }
        return 0;
    }
}