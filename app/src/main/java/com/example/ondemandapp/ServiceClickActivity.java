package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ondemandapp.adapter.GridServiceAdapter;
import com.example.ondemandapp.adapter.PhotosRecyclerviewAdapter;
import com.example.ondemandapp.adapter.ReviewsAdapter;
import com.example.ondemandapp.adapter.ServiceClickAdapter;
import com.example.ondemandapp.modelclass.Reviewmodel;
import com.example.ondemandapp.modelclass.ServiceClickModel;

import java.util.ArrayList;
import java.util.List;

public class ServiceClickActivity extends AppCompatActivity {
    GridView gv_services;
    ImageView iv_banner,iv_clickservice_back;
    RecyclerView rv_photos, rv_reviews;
    PhotosRecyclerviewAdapter pa;
    ReviewsAdapter ra;
    TextView tv3_toolbar;
    ServiceClickAdapter gridServiceAdapter;
    LinearLayout ll_grid;
    List<ServiceClickModel> servicelist = new ArrayList<>();
    List<Reviewmodel> reviewlist = new ArrayList<>();
    int[] images = {R.drawable.salon_one, R.drawable.salon_two, R.drawable.salon_three, R.drawable.salon_one};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_click);
        gv_services = findViewById(R.id.gv_services);
        ll_grid = findViewById(R.id.ll_grid);
        rv_photos = findViewById(R.id.rv_photos);
        rv_reviews = findViewById(R.id.rv_reviews);
        tv3_toolbar = findViewById(R.id.tv3_toolbar);
        iv_banner = findViewById(R.id.iv_banner);
        iv_clickservice_back = findViewById(R.id.iv_clickservice_back);

        String serviceid = getIntent().getStringExtra("TypeServiceId");

        if (serviceid.equals("1")) {
            tv3_toolbar.setText("Salon at home for Women");
            servicelist.add(new ServiceClickModel("Wax", R.drawable.waxing, "1"));
            servicelist.add(new ServiceClickModel("Facial", R.drawable.facial, "2"));
            servicelist.add(new ServiceClickModel("Pedicure", R.drawable.pedicure, "3"));
            servicelist.add(new ServiceClickModel("Manicure", R.drawable.manicure, "4"));
            servicelist.add(new ServiceClickModel("Threading", R.drawable.threading, "5"));
            servicelist.add(new ServiceClickModel("Hair", R.drawable.hair, "6"));

            gridServiceAdapter = new ServiceClickAdapter(ServiceClickActivity.this, servicelist);
            gv_services.setAdapter(gridServiceAdapter);
        }

        if (serviceid.equals("3")) {
            iv_banner.setImageResource(R.drawable.men_banner);
            tv3_toolbar.setText("Men's Haircut \u0026 Grooming");
            servicelist.add(new ServiceClickModel("Haircut \u0026 Shave", R.drawable.shave, "7"));
            servicelist.add(new ServiceClickModel("Hands \u0026 Feet", R.drawable.hands_men, "8"));
            servicelist.add(new ServiceClickModel("Must try Packages", R.drawable.men_must_try, "9"));
            servicelist.add(new ServiceClickModel("Cleanup/ Facial", R.drawable.cleanup, "10"));
            servicelist.add(new ServiceClickModel("Kids Special", R.drawable.kids_haircut, "11"));
            servicelist.add(new ServiceClickModel("Add-ons", R.drawable.add_ons, "12"));

            gridServiceAdapter = new ServiceClickAdapter(ServiceClickActivity.this, servicelist);
            gv_services.setAdapter(gridServiceAdapter);
        }
        if (serviceid.equals("11")) {
            tv3_toolbar.setText("Electricians");
            servicelist.add(new ServiceClickModel("Fan", R.drawable.fan, "13"));
            servicelist.add(new ServiceClickModel("Switches \u0026 Sockets",R.drawable.switchhh, "14"));
            servicelist.add(new ServiceClickModel("Lights", R.drawable.lights, "15"));
            servicelist.add(new ServiceClickModel("MCB \u0026 Fuse", R.drawable.mcb, "16"));
            servicelist.add(new ServiceClickModel("Smart device Installation", R.drawable.smart_device, "17"));
            servicelist.add(new ServiceClickModel("Geyser", R.drawable.geyser_repair, "18"));

            gridServiceAdapter = new ServiceClickAdapter(ServiceClickActivity.this, servicelist);
            gv_services.setAdapter(gridServiceAdapter);

        }
        if (serviceid.equals("12")) {
            tv3_toolbar.setText("Plumbers");
            servicelist.add(new ServiceClickModel("Toilet", R.drawable.men_haircut, "19"));
            servicelist.add(new ServiceClickModel("Sink \u0026 Sockets", R.drawable.men_haircut, "20"));
            servicelist.add(new ServiceClickModel("Tap \u0026 Mixers", R.drawable.men_haircut, "21"));
            servicelist.add(new ServiceClickModel("Blockage", R.drawable.men_haircut, "22"));
            servicelist.add(new ServiceClickModel("Shower", R.drawable.men_haircut, "23"));
            servicelist.add(new ServiceClickModel("Water Tank", R.drawable.men_haircut, "24"));

            gridServiceAdapter = new ServiceClickAdapter(ServiceClickActivity.this, servicelist);
            gv_services.setAdapter(gridServiceAdapter);
        }
        if (serviceid.equals("13")) {
            tv3_toolbar.setText("Carpenters");

            servicelist.add(new ServiceClickModel("Drill \u0026 hang", R.drawable.men_haircut, "25"));
            servicelist.add(new ServiceClickModel("Lock", R.drawable.men_haircut, "26"));
            servicelist.add(new ServiceClickModel("Door", R.drawable.men_haircut, "27"));
            servicelist.add(new ServiceClickModel("Drawer", R.drawable.men_haircut, "28"));
            servicelist.add(new ServiceClickModel("Fittings", R.drawable.men_haircut, "29"));
            servicelist.add(new ServiceClickModel("New Furniture", R.drawable.men_haircut, "30"));

            gridServiceAdapter = new ServiceClickAdapter(ServiceClickActivity.this, servicelist);
            gv_services.setAdapter(gridServiceAdapter);
        }

        if (serviceid.equals("2")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Makeup \u0026 Hairstyling");
        }

        if (serviceid.equals("4")) {
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Maid Cleaning Services");
        }

        if (serviceid.equals("5")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Bathroom Deep Cleaning");

        }

        if (serviceid.equals("6")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Kitchen Deep Cleaning");

        }
        if (serviceid.equals("7")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Sofa Cleaning");

        }
        if (serviceid.equals("8")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Home Deep Cleaning");

        }
        if (serviceid.equals("9")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Car Cleaning");
        } if (serviceid.equals("10")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Carpet Cleaning");

        }
        if (serviceid.equals("14")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("RO or Water Purifier Repair");
        }
        if (serviceid.equals("15")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Refrigerator Repair");

        } if (serviceid.equals("16")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Washing Machine Repair");

        } if (serviceid.equals("17")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Microwave Repair");

        } if (serviceid.equals("18")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Television Repair \u0026 Installation");

        } if (serviceid.equals("19")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Geyser / Water Heater Repair");

        }
        if (serviceid.equals("20")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("AC Service \u0026 Repair");

        } if (serviceid.equals("21")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Chimney Cleaning \u0026 Repair");

        } if (serviceid.equals("22")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Laptop Repair");



        } if (serviceid.equals("23")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("IPad, Mac Repair");


        }
        if (serviceid.equals("24")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Mobile Screen Repair");
        } if (serviceid.equals("25")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Computer Repair");

        } if (serviceid.equals("26")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Mixer \u0026 Grinder Repair");

        } if (serviceid.equals("27")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Massage for Men");

        }
        if (serviceid.equals("28")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Massage for Women");

        }
        if (serviceid.equals("29")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Fitness Trainer at Home");
        }
        if (serviceid.equals("30")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Yoga Trainer at Home");
        }
        if (serviceid.equals("31")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("House Painters");
        }
        if (serviceid.equals("32")){
            ll_grid.setVisibility(View.GONE);
            iv_banner.setVisibility(View.GONE);
            tv3_toolbar.setText("Pest Control");
        }


        rv_photos.setLayoutManager(new LinearLayoutManager(ServiceClickActivity.this, RecyclerView.HORIZONTAL, false));
        pa = new PhotosRecyclerviewAdapter(ServiceClickActivity.this, images);
        rv_photos.setAdapter(pa);



        reviewlist.add(new Reviewmodel("Nikita","4.5","New Delhi","6th Aug,2019","Excellent job.Very proffesional.Removed all my tan"));
        reviewlist.add(new Reviewmodel("Chetna mishra","5.0","New Delhi","5th Aug,2019","My mother was very happy with her service quality and the attention she paid to make my mother comfortable."));
        reviewlist.add(new Reviewmodel("Sneha","4.8","Pune","4th Aug,2019","amazing job by her.She masters what she did"));
        reviewlist.add(new Reviewmodel("Nisha","5.0","gurgaon","5th Aug,2019","She was great at her work and gentle too.Felt good after her service"));

        rv_reviews.setLayoutManager(new LinearLayoutManager(ServiceClickActivity.this,RecyclerView.VERTICAL,false));
        ra=new ReviewsAdapter(ServiceClickActivity.this,reviewlist);
        rv_reviews.setAdapter(ra);

        iv_clickservice_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
