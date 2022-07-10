package com.adithyapai.call;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText phone;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = findViewById(R.id.phone);
        findViewById(R.id.call).setOnClickListener(view -> {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
            else
                startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:" + phone.getText().toString())));
        });
        findViewById(R.id.save).setOnClickListener(view -> {
            startActivity(new Intent(Intent.ACTION_INSERT).setType(ContactsContract.RawContacts.CONTENT_TYPE).putExtra(ContactsContract.Intents.Insert.PHONE, phone.getText().toString()));
        });


    }
}