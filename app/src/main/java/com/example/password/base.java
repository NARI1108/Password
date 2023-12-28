package com.example.password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class base extends AppCompatActivity {
    EditText edt_mobile, edt_password;
    Button btn_save;
    TextView txt_change, txt_forgotten;
    Button btn_send;
    public static final String LoginInfo = "login_info";
    public static final String Mobile_NO = "mobile_no";
    public static final String Password  = "password";
    SharedPreferences SharedP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedP = getSharedPreferences(LoginInfo, Context.MODE_PRIVATE);
    }
    //    This method actually connects views and layers from an XML layer to this layer.
    public void findViews(){
        edt_password = findViewById(R.id.edt_password);
        edt_mobile = findViewById(R.id.edt_mobile);
        btn_save = findViewById(R.id.btn_save);
        txt_change = findViewById(R.id.txt_change);
        txt_forgotten = findViewById(R.id.txt_forgotten);
        btn_send = findViewById(R.id.btn_send);
    }
}