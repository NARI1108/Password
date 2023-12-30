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
        setOnClick();
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
//    This method is for applying clicking on activity options.
    public void setOnClick(){
//        This pseudo code is used when the user has forgotten his password.
        txt_forgotten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PASSWORD = SharedP.getString("Password",getString(R.string.MESSAGE));
                String MOBILE = SharedP.getString("Mobile_No",getString(R.string.MESSAGE));
//                This pseudocode is for sending messages to the user if he has registered his information.
                try {
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(MOBILE,null,PasswordMessage+PASSWORD,null,null);
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.sms), Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.message), Toast.LENGTH_SHORT).show();
                }
            }
        });
//        This code is for changing the password.
        txt_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PASSWORD = SharedP.getString("Password",getString(R.string.MESSAGE));
                String Password_Entry = edt_password.getText().toString();
                if (Password_Entry.equals(PASSWORD)){
                    startActivity(new Intent(MainActivity.this,login.class));
                }else{
                    Toast.makeText(MainActivity.this, "AtFirst Enter your Previous Password", Toast.LENGTH_LONG).show();
                }
            }
        });
//        This pseudo-code is for going from this main activity to the next activity (home).
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String PASSWORD = SharedP.getString("Password",getString(R.string.MESSAGE));
             String Password_Entry = edt_password.getText().toString();
             if (Password_Entry.equals(PASSWORD)){
                 startActivity(new Intent(MainActivity.this,Home.class));
             }else {
                 Toast.makeText(MainActivity.this, "your password is wrong!", Toast.LENGTH_LONG).show();
             }
            }
        });
    }
}