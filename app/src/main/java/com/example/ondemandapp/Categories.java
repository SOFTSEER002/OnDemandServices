package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.ondemandapp.adapter.GridServiceAdapter;
import com.example.ondemandapp.modelclass.GridServicesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Categories extends AppCompatActivity {

    GridView gv_category;
    List<GridServicesModel> servicelist = new ArrayList<>();
    GridServiceAdapter serviceAdapter;
    TextView tv_toolbar;
    ImageView iv_cat_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        gv_category = findViewById(R.id.gv_category);
        tv_toolbar = findViewById(R.id.tv_toolbar);
        iv_cat_back = findViewById(R.id.iv_cat_back);


        String category = getIntent().getStringExtra("CategoryType");
        if (category.equals("Lifestyle")) {
            tv_toolbar.setText("LIFESTYLE");
            servicelist.add(new GridServicesModel("Online Lessons", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Arts", R.drawable.office_cleaning));
            servicelist.add(new GridServicesModel("Health", R.drawable.electrical_repair));
            servicelist.add(new GridServicesModel("Travel", R.drawable.beauty));
            servicelist.add(new GridServicesModel("Computers", R.drawable.house_cleaning));
            servicelist.add(new GridServicesModel("Gardening", R.drawable.plumber));
            servicelist.add(new GridServicesModel("Beauty", R.drawable.plumber));
            servicelist.add(new GridServicesModel("Cooking", R.drawable.plumber));
            servicelist.add(new GridServicesModel("Entertainment", R.drawable.plumber));
            servicelist.add(new GridServicesModel("Shopping", R.drawable.plumber));
        }
        if (category.equals("Business")) {
            tv_toolbar.setText("BUSINESS");
            servicelist.add(new GridServicesModel("Websites", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Business plans", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Data Entry", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Flyer distributors", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Proofreading", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Professional speaking", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Presentations", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Systems-flowcharts", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Staffing", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Virtual assistant", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Design", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Marketing", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Research assistant", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Writing", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Personal assistant", R.drawable.car_wash));

        }
        if (category.equals("Resources")) {
            tv_toolbar.setText("RESOURCES");
            servicelist.add(new GridServicesModel("Pool inspection", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Electrician", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Deliveries", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Event assistant", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Pickups", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Restocking", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Parent's assistant", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Senior's assistant", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Furniture assembly", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Children's play equipments", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Handyman", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Electrician", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Appliance repair", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Pet care", R.drawable.car_wash));
            servicelist.add(new GridServicesModel("Cleaning", R.drawable.car_wash));

        }

        serviceAdapter = new GridServiceAdapter(Categories.this, servicelist);
        gv_category.setAdapter(serviceAdapter);

        iv_cat_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
