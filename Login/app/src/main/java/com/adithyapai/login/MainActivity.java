package com.adithyapai.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button signup;
    private EditText usName, password;
    private String uname, pswd;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    Pattern psPattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup = findViewById(R.id.signupbtn);
        usName = findViewById(R.id.signupusername);
        password = findViewById(R.id.signuppassword);

        signup.setOnClickListener(view -> {
            uname = usName.getText().toString();
            pswd = password.getText().toString();
            if(uname == null || uname.isEmpty() || pswd == null || pswd.isEmpty()){
                Toast.makeText(MainActivity.this, "Please Input the fields", Toast.LENGTH_SHORT).show();
            }
            else if(!psPattern.matcher(pswd).matches()){
                Toast.makeText(MainActivity.this, "Password is 8 Character  long \n Must Contain 1 Special Charecter", Toast.LENGTH_SHORT).show();

            }
            else {
                Intent intent = new Intent(MainActivity.this, LoginActivityActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username", uname);
                bundle.putString("password", pswd);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });







    }
}