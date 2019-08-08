package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleDetailActivity extends AppCompatActivity {
ImageView iv_book_back;
TextView tv_type_service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_detail);
        iv_book_back=findViewById(R.id.iv_book_back);
        tv_type_service=findViewById(R.id.tv_type_service);

        String categoryy=getIntent().getStringExtra("CategoryType");
        if(categoryy.equals("women")){
            tv_type_service.setText("Salon at Home for Women");
        }

        if(categoryy.equals("men")){
            tv_type_service.setText("Salon at Home for Men");
        }
        if(categoryy.equals("cleaning")){
            tv_type_service.setText("Cleaning");
        }
        if(categoryy.equals("electrician")){
            tv_type_service.setText("Laundry and Dry cleaning");
        }
        if(categoryy.equals("massage")){
            tv_type_service.setText("AC Service");
        }
        if(categoryy.equals("yoga")){
            tv_type_service.setText("Geyser Service");
        }
        if(categoryy.equals("painting")){
            tv_type_service.setText("LED TV Repair");
        }
        if(categoryy.equals("pest")){
            tv_type_service.setText("Washing machine Repair");
        }


        iv_book_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
