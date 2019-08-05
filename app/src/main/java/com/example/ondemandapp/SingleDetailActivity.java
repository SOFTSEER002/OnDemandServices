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
        if(categoryy.equals("house")){
            tv_type_service.setText("House Cleaning");
        }

        if(categoryy.equals("office")){
            tv_type_service.setText("Office Cleaning");
        }
        if(categoryy.equals("car")){
            tv_type_service.setText("Car wash");
        }
        if(categoryy.equals("laundry")){
            tv_type_service.setText("Laundry and Dry cleaning");
        }
        if(categoryy.equals("ac")){
            tv_type_service.setText("AC Service");
        }
        if(categoryy.equals("geyser")){
            tv_type_service.setText("Geyser Service");
        }
        if(categoryy.equals("tv")){
            tv_type_service.setText("LED TV Repair");
        }
        if(categoryy.equals("washing")){
            tv_type_service.setText("Washing machine Repair");
        }
        if(categoryy.equals("refrigerator")){
            tv_type_service.setText("Refrigerator Repair");
        }
        if(categoryy.equals("ro")){
            tv_type_service.setText("RO Service");
        }
        if(categoryy.equals("bridal")){
            tv_type_service.setText("Bridal Makeup");
        }
        if(categoryy.equals("men")){
            tv_type_service.setText("Men Salon");
        }
        if(categoryy.equals("women")){
            tv_type_service.setText("House Cleaning");
        }
        if(categoryy.equals("electrician")){
            tv_type_service.setText("House Cleaning");
        }
        if(categoryy.equals("plumber")){
            tv_type_service.setText("Women Salon");
        }
        if(categoryy.equals("carpenter")){
            tv_type_service.setText("Carpenter");
        }
        if(categoryy.equals("photography")){
            tv_type_service.setText("Photography");
        }
        if(categoryy.equals("transportation")){
            tv_type_service.setText("House Cleaning");
        }
        if(categoryy.equals("website")){
            tv_type_service.setText("Website Development");
        }
        if(categoryy.equals("app")){
            tv_type_service.setText("App Development");
        }
        if(categoryy.equals("design")){
            tv_type_service.setText("Website Design");
        }


        iv_book_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
