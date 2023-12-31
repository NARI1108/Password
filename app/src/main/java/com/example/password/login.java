package com.example.password;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class login extends base {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        saved();
    }
//     This method is for saving user information.
     public void saved(){
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              It takes the text or password and stores it inside the variable (stores information in a layer).
                String phone = edt_mobile.getText().toString();
                String password = edt_password.getText().toString();
                SharedPreferences.Editor mobile_edit = SharedP.edit();
                mobile_edit.putString(Mobile_NO,phone);
                mobile_edit.putString(Password,password);
                mobile_edit.apply();
                Toast.makeText(login.this, getResources().getString(R.string.saving), Toast.LENGTH_SHORT).show();
                sms();
                finish();
            }
        });
        recovery();
        }
//  This method sends password and user number to the user via SMS.
    public void sms(){
        String PASSWORD = SharedP.getString("Password",getString(R.string.MESSAGE));
        String MOBILE = SharedP.getString("Mobile_No",getString(R.string.MESSAGE));
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(MOBILE,null,PasswordMessage+PASSWORD,null,null);
        }catch(Exception e){
            Toast.makeText(login.this, getResources().getString(R.string.message), Toast.LENGTH_SHORT).show();
        }
    }
//    This method is for recovering user number and password.
    public void recovery(){
        if (SharedP.contains(Mobile_NO)){
            edt_mobile.setText(SharedP.getString(Mobile_NO,getString(R.string.Alarm_mobile)));
        }if (SharedP.contains(Password))
            edt_password.setText(SharedP.getString(Password,getString(R.string.Alarm_password)));
    }
}