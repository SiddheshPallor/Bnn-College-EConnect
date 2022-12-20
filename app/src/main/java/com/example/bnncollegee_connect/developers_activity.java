package com.example.bnncollegee_connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class developers_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Developers");

    }
}