package com.example.password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handler();
    }
    public void handler(){
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              startActivity(new Intent(splashScreen.this,MainActivity.class));
              finish();
          }
      },4000);
    }
}