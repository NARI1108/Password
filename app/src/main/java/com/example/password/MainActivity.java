package com.example.password;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

}