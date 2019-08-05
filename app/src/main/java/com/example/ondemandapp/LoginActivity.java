package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView tv_forgot, tv_registerr;
    ImageView iv_login_back;
Dialog d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_forgot = findViewById(R.id.tv_forgot);
        tv_registerr = findViewById(R.id.tv_registerr);
        iv_login_back = findViewById(R.id.iv_login_back);
        d=new Dialog(LoginActivity.this);
        d.setContentView(R.layout.dialog_forgot_password);


        tv_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
d.show();
            }
        });
        tv_registerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                finish();
            }
        });

        iv_login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
