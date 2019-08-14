package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ondemandapp.adapter.RecyclerviewTimeAdapter;

import java.util.ArrayList;
import java.util.List;

public class DateTimeActivity extends AppCompatActivity {
ImageView iv_save_back;
RecyclerView rv_time;
RecyclerviewTimeAdapter rta;
List<String> list=new ArrayList<>();
LinearLayout ll1_date,ll2_date,ll_proceedpay;
TextView tv1_date,tv2_date,tv1_day,tv2_day;
    SharedPreferences sp_time;
    SharedPreferences.Editor ed_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        iv_save_back=findViewById(R.id.iv_save_back);
        rv_time=findViewById(R.id.rv_time);
        ll1_date=findViewById(R.id.ll1_date);
        ll2_date=findViewById(R.id.ll2_date);
        tv1_date=findViewById(R.id.tv1_date);
        tv2_date=findViewById(R.id.tv2_date);
        tv1_day=findViewById(R.id.tv1_day);
        tv2_day=findViewById(R.id.tv2_day);
        ll_proceedpay=findViewById(R.id.ll_proceedpay);

        iv_save_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        sp_time=getSharedPreferences("BOOKINGSERVICE", MODE_PRIVATE);
        ed_time=sp_time.edit();


        list.add("8:00 am");
        list.add("9:30 am");
        list.add("10:00 am");
        list.add("11:30 am");
        list.add("12:30 pm");
        list.add("1:15 pm");
        list.add("2:45 pm");
        list.add("3:30 pm");

        @SuppressLint("WrongConstant") GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        rv_time.setLayoutManager(manager);
      rta=new RecyclerviewTimeAdapter(DateTimeActivity.this,list);
      rv_time.setAdapter(rta);


        ll1_date.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dateblue_back));
        tv1_date.setTextColor(getResources().getColor(R.color.blue));
        tv1_day.setTextColor(getResources().getColor(R.color.blue));

        ed_time.putString("day",tv1_day.getText().toString());
        ed_time.putString("date",tv1_date.getText().toString());
        ed_time.commit();

        ll2_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll2_date.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dateblue_back));
                tv2_date.setTextColor(getResources().getColor(R.color.blue));
                tv2_day.setTextColor(getResources().getColor(R.color.blue));

                ll1_date.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.date_back));
                tv1_date.setTextColor(getResources().getColor(R.color.black));
                tv1_day.setTextColor(getResources().getColor(R.color.textcolor));

                ed_time.putString("day",tv2_day.getText().toString());
                ed_time.putString("date",tv2_date.getText().toString());
                ed_time.commit();
            }
        });

        ll1_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll1_date.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dateblue_back));
                tv1_date.setTextColor(getResources().getColor(R.color.blue));
                tv1_day.setTextColor(getResources().getColor(R.color.blue));

                ll2_date.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.date_back));
                tv2_date.setTextColor(getResources().getColor(R.color.black));
                tv2_day.setTextColor(getResources().getColor(R.color.textcolor));

                ed_time.putString("day",tv1_day.getText().toString());
                ed_time.putString("date",tv1_date.getText().toString());
                ed_time.commit();
            }
        });

        ll_proceedpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DateTimeActivity.this,PaymentActivity.class));
            }
        });

        iv_save_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
