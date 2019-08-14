package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceRequestActivity extends AppCompatActivity {
    SharedPreferences sp_time;
    SharedPreferences.Editor ed_time;
    TextView tv_arrivaltime;
    String day,date,time;
    ImageView iv_place_back;
    TextView tv_bookings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_request);
        tv_arrivaltime=findViewById(R.id.tv_arrivaltime);
        iv_place_back=findViewById(R.id.iv_place_back);
        tv_bookings=findViewById(R.id.tv_bookings);


        sp_time=getSharedPreferences("BOOKINGSERVICE", MODE_PRIVATE);
        ed_time=sp_time.edit();

        day=sp_time.getString("day","");
        date=sp_time.getString("date","");
        time=sp_time.getString("time","");

        tv_arrivaltime.setText(day+", "+date+"th Aug - "+time);

        iv_place_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tv_bookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlaceRequestActivity.this,BookingsActivity.class));
            }
        });
    }
}


