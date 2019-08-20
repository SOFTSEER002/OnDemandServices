package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity {
    ListView lv_location;
    ImageView iv_location_back;
    EditText et_locationsearch;
    ArrayAdapter locationadapter;
    String[] locations = {"Delhi","Mumbai","Gurgaon","Haryana","Mohali","Chandigarh","Pune",
            "Bangalore","Hyderabad","Jammu","Himachal Pradesh","Noida","Bihar","Uttar Pradesh"};
    List<String> stringList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);


        lv_location=findViewById(R.id.lv_location);
        iv_location_back=findViewById(R.id.iv_location_back);

        et_locationsearch = findViewById(R.id.et_locationsearch);


        locationadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, locations);
        lv_location.setAdapter(locationadapter);

        et_locationsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                locationadapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        lv_location.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(LocationActivity.this,MainActivity.class);
                intent.putExtra("LocationSave",String.valueOf(adapterView.getItemAtPosition(i)));
                startActivity(intent);
                //  Toast.makeText(LocationActivity.this, ""+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }
        });

        iv_location_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
