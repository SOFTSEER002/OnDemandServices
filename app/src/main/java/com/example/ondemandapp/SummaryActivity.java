package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {
ImageView iv_summary_back;
String summarytotal;
TextView tv_total_summary,tv_totall,tv_single_price,tv_final_total,tv_membership,tv_skip;
SharedPreferences sp_total;
SharedPreferences.Editor ed_total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        iv_summary_back=findViewById(R.id.iv_summary_back);
        tv_total_summary=findViewById(R.id.tv_total_summary);
        tv_final_total=findViewById(R.id.tv_final_total);
        tv_single_price=findViewById(R.id.tv_single_price);
        tv_totall=findViewById(R.id.tv_totall);
        tv_membership=findViewById(R.id.tv_membership);
        tv_skip=findViewById(R.id.tv_skip);

        summarytotal=getIntent().getStringExtra("SumSummary");

        sp_total=getSharedPreferences("BOOKINGSERVICE",MODE_PRIVATE);
        ed_total=sp_total.edit();
        ed_total.putString("sum",summarytotal);
        ed_total.commit();

        tv_total_summary.setText("\u20B9 "+summarytotal);
        tv_totall.setText("\u20B9 "+summarytotal);
        tv_final_total.setText("\u20B9 "+summarytotal);
        tv_single_price.setText("\u20B9 "+summarytotal);

        iv_summary_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tv_membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SummaryActivity.this,ViewMembershipActivity.class));
            }
        });

        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SummaryActivity.this,AddDetailsActivity.class));

            }
        });
    }
}
