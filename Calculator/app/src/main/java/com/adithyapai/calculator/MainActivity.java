package com.adithyapai.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText n1, n2;
    TextView res ;
    Button add ,sub ,mul ,div ,clr;
    double num1 , num2, result;


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


        add.setOnClickListener(view -> {
       try {
           num1 = Double.parseDouble(String.valueOf(n1.getText()));
           num2 = Double.parseDouble(String.valueOf(n2.getText()));
           result  = num1 - num2;
           res.setText(new String(String.valueOf(result)));
       }
       catch (Exception e){
           res.setText("Error");
           Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
       }


        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   num1 = Double.parseDouble(String.valueOf(n1.getText()));
                   num2 = Double.parseDouble(String.valueOf(n2.getText()));

                   result = num1 - num2;
                   res.setText(new String(String.valueOf(result)));
               } catch (Exception e){
                    res.setText("Error");
                   Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   num1 = Double.parseDouble(String.valueOf(n1.getText()));
                   num2 = Double.parseDouble(String.valueOf(n2.getText()));

                   result  = num1 * num2;
                   res.setText(new String(String.valueOf(result)));
               }catch (Exception e){
                   res.setText(new String(String.valueOf(e)));
                   Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
               }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             try{
                 num1 = Double.parseDouble(String.valueOf(n1.getText()));
                 num2 = Double.parseDouble(String.valueOf(n2.getText()));

                 result  = num1 / num2;
                 res.setText(new String(String.valueOf(result)));
             }catch(Exception e){
                 res.setText(new String(String.valueOf(e)));
                 Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
             }
            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1.setText("");
                n2.setText("");
                res.setText("0");
            }
        });








    }
}