package com.example.password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText edt_mobile, edt_password;
    Button btn_save;
    SharedPreferences SharedP;
    public static final String LoginInfo = "login_info";
    public static final String Mobile_NO = "mobile_no";
    public static final String Password  = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        saved();
    }
//    This method actually connects views and layers from an XML layer to this layer.
    public void findViews(){
        edt_password = findViewById(R.id.edt_password);
        edt_mobile = findViewById(R.id.edt_mobile);
        btn_save = findViewById(R.id.btn_save);
     }
//     This method is for saving user information.
     public void saved(){
        SharedP = getSharedPreferences(LoginInfo, Context.MODE_PRIVATE);
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
            sms.sendTextMessage(MOBILE,null,"your password is:"+PASSWORD,null,null);
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