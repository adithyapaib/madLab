package com.adithyapai.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivilegedAction;

public class LoginActivityActivity extends AppCompatActivity {
    private String u, p;
    EditText up, pw;
    Button loginBtn;
    private static int  i =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        up = findViewById(R.id.loginusername);
        pw = findViewById(R.id.loginpassword);
        loginBtn = findViewById(R.id.loginbtn);

       Bundle bundle = getIntent().getExtras();
         u = bundle.getString("username");
         p = bundle.getString("password");

        Toast.makeText(this, "Welcome " + u, Toast.LENGTH_SHORT).show();
        loginBtn.setOnClickListener(view -> {
            if(up.getText().toString().equals(u) && pw.getText().toString().equals(p)){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginsuccessActivity.class);
                startActivity(intent);


            }
            else if (i >0){
                Toast.makeText(this, "Too many attempts", Toast.LENGTH_SHORT).show();
                i++;
            }
            else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }


        });






    }
}