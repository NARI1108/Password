package com.example.password;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends base {
    boolean firstTime=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        saved();

    }
//    This method is the first time the app is run when the user's information is registered in the app.
    public void saved(){
        SharedPreferences.Editor runEdit = SharedP.edit();
        firstTime = SharedP.getBoolean("First",true);
//        This method specifies that the main activity should be executed once.
        if(firstTime){
            startActivity(new Intent(MainActivity.this,login.class));
            runEdit.putBoolean("first",false);
            runEdit.apply();
        }
        if (SharedP.contains(Password)){
            runEdit.putBoolean("first",false);
            runEdit.apply();
        }
    }

}