package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.ondemandapp.adapter.RecyclerviewTimeAdapter;

import java.util.ArrayList;
import java.util.List;

public class SaveAddressActivity extends AppCompatActivity {
ImageView iv_save_back;
GridView rv_time;
RecyclerviewTimeAdapter rta;
List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_address);
        iv_save_back=findViewById(R.id.iv_save_back);
        rv_time=findViewById(R.id.rv_time);

        iv_save_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        list.add("8 am");
        list.add("9 am");
        list.add("10 am");
        list.add("11 am");
        list.add("12 pm");
        list.add("1 pm");

      rta=new RecyclerviewTimeAdapter(SaveAddressActivity.this,list);
      rv_time.setAdapter(rta);
    }
}
