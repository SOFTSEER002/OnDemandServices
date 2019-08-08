package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
ImageView iv_settings_back;
TextView login,tv_privacy,tv_contactus,tv_aboutus,tv_terms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeting);
        iv_settings_back=findViewById(R.id.iv_settings_back);
        login=findViewById(R.id.login);
        tv_privacy=findViewById(R.id.tv_privacy);
        tv_contactus=findViewById(R.id.tv_contactus);
        tv_aboutus=findViewById(R.id.tv_aboutus);
        tv_terms=findViewById(R.id.tv_terms);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this,LoginActivity.class));
            }
        });

        iv_settings_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}
