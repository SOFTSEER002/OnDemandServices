package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BookingsActivity extends AppCompatActivity {
    ImageView iv_bookings_back;
    TextView tv_loginn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);
        iv_bookings_back = findViewById(R.id.iv_bookings_back);
        tv_loginn = findViewById(R.id.tv_loginn);

        iv_bookings_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tv_loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookingsActivity.this, LoginActivity.class));
            }
        });
    }
}
