package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ondemandapp.adapter.SingleServiceListAdapter;
import com.example.ondemandapp.adapter.SingleServicePhotosAdapter;
import com.example.ondemandapp.interfaces.TotalSum;
import com.example.ondemandapp.modelclass.SingleServicemodel;

import java.util.ArrayList;
import java.util.List;

public class SingleServiceListActivity extends AppCompatActivity implements TotalSum {
    RecyclerView rv_packages, rv_showphotos1, rv_showphotos2, rv_servicess_list;
    LinearLayout ll_add_service, ll_increment, ll2_add_service, ll2_increment, ll_summary;
    SingleServicePhotosAdapter spa;
    int[] imageservice = {R.drawable.salon_one, R.drawable.salon_two, R.drawable.salon_three};
    int[] imageservice2 = {R.drawable.salon_three, R.drawable.salon_one, R.drawable.salon_two};
    int sum = 0;
    List<SingleServicemodel> listsingle = new ArrayList<>();
    SingleServiceListAdapter ssl;
    TextView tv_count, tv2_count, tv5_toolbar, tv_total_amount, tv2_price, tv1_price;
    ImageView iv_add, iv_minus, iv2_add, iv2_minus, iv_servicelist_back;
    String serviceclickId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_service_list);

        // rv_packages=findViewById(R.id.rv_packages);
        tv_count = findViewById(R.id.tv_count);
        tv2_count = findViewById(R.id.tv2_count);
        iv_add = findViewById(R.id.iv_add);
        iv2_add = findViewById(R.id.iv2_add);
        iv_minus = findViewById(R.id.iv_minus);
        iv2_minus = findViewById(R.id.iv2_minus);
        ll_add_service = findViewById(R.id.ll_add_service);
        ll2_add_service = findViewById(R.id.ll2_add_service);
        ll_increment = findViewById(R.id.ll_increment);
        ll2_increment = findViewById(R.id.ll2_increment);
        rv_showphotos1 = findViewById(R.id.rv_showphotos);
        rv_showphotos2 = findViewById(R.id.rv_showwphotos);
        rv_servicess_list = findViewById(R.id.rv_servicess_list);
        iv_servicelist_back = findViewById(R.id.iv_servicelist_back);
        tv5_toolbar = findViewById(R.id.tv5_toolbar);
        ll_summary = findViewById(R.id.ll_summary);
        tv_total_amount = findViewById(R.id.tv_total_amount);
        tv2_price = findViewById(R.id.tv2_price);
        tv1_price = findViewById(R.id.tv1_price);


        serviceclickId = getIntent().getStringExtra("ClickServiceId");


        rv_showphotos1.setLayoutManager(new LinearLayoutManager(SingleServiceListActivity.this, RecyclerView.HORIZONTAL, false));
        spa = new SingleServicePhotosAdapter(SingleServiceListActivity.this, imageservice);
        rv_showphotos1.setAdapter(spa);

        rv_showphotos2.setLayoutManager(new LinearLayoutManager(SingleServiceListActivity.this, RecyclerView.HORIZONTAL, false));
        spa = new SingleServicePhotosAdapter(SingleServiceListActivity.this, imageservice2);
        rv_showphotos2.setAdapter(spa);

        if (serviceclickId.equals("1")) {
            tv5_toolbar.setText("Waxing");
            listsingle.add(new SingleServicemodel(R.drawable.waxing, "1", "Half Arms Waxing", "199", "225", "12", "Honey wax by Sleek", "15 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.waxing, "2", "Half Legs Waxing", "199", "275", "28", "Honey Wax by Sleek", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.waxing, "3", "Underarms Waxing", "49", "100", "51", "Honey Wax by Sleek", "110 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.waxing, "4", "Full Legs Waxing", "299", "505", "41", "", "40 min", 1));
        }

        if (serviceclickId.equals("2")) {
            tv5_toolbar.setText("Facial");
            listsingle.add(new SingleServicemodel(R.drawable.facial, "5", "Sara Fruit Cleanup", "599", "1,150", "48", "Sara", "30 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.facial, "6", "Power Brightening Facial", "1,699", "2,999", "44", "O3+", "70 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.facial, "7", "Tan Clear Facial", "999", "1,999", "51", "Cheryl's by Loreal", "60 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.facial, "8", "Shine \u0026 Glow Facial", "1,499", "2,499", "41", "Agelock by O3+", "60 min", 1));
        }

        if (serviceclickId.equals("3")) {
            tv5_toolbar.setText("Pedicure");
            listsingle.add(new SingleServicemodel(R.drawable.pedicure, "9", "Cut,File \u0026 Polish - Feet", "199", "220", "10", "Lyn/ Colorbar Nail Paints", "15 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.pedicure, "10", "Classic Pedicure", "549", "650", "16", "Sara by O3+", "40 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.pedicure, "11", "Detan Pedicure", "799", "1,099", "28", "Sara by O3+", "60 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.pedicure, "12", "Bubblegum Spa Pedicure", "749", "999", "26", "Pedilogix by O3+", "50 min", 1));
        }

        if (serviceclickId.equals("4")) {
            tv5_toolbar.setText("Manicure");
            listsingle.add(new SingleServicemodel(R.drawable.manicure, "13", "Cut,File \u0026 Polish", "199", "220", "10", "Lyn/ Colorbar Nail Paints", "15 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.manicure, "14", "Classic Manicure", "449", "550", "19", "Sara by O3+", "30 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.manicure, "15", "Bubblegum Spa Manicure", "599", "899", "34", "Pedilogix by O3+", "40 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.manicure, "16", "Detan Manicure", "599", "950", "37", "Sara by O3+", "50 min", 1));
        }

        if (serviceclickId.equals("5")) {
            tv5_toolbar.setText("Threading");
            listsingle.add(new SingleServicemodel(R.drawable.threading, "17", "Eyebrows", "29", "65", "56", "", "15 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.threading, "18", "Upper Lip", "19", "40", "28", "", "10 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.threading, "19", "Chin", "29", "40", "28", "", "10 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.threading, "20", "Forehead", "39", "45", "14", "", "10 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.threading, "21", "Full Face", "149", "185", "20", "", "30 min", 1));
        }

        if (serviceclickId.equals("6")) {
            tv5_toolbar.setText("Hair");
            listsingle.add(new SingleServicemodel(R.drawable.hair, "22", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "23", "Root Touchup", "799", "1299", "39", "Loreal INOA", "30 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "24", "Henna Application", "349", "400", "13", "", "20 min", 1));
        }

        if (serviceclickId.equals("7")) {
            tv5_toolbar.setText("Haircut \u0026 Shave");
            listsingle.add(new SingleServicemodel(R.drawable.hair, "25", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "26", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }

        if (serviceclickId.equals("8")) {
            tv5_toolbar.setText("Hands \u0026 Feet");
            listsingle.add(new SingleServicemodel(R.drawable.hair, "25", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "26", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }

        if (serviceclickId.equals("9")) {
            tv5_toolbar.setText("Must try Packages");
            listsingle.add(new SingleServicemodel(R.drawable.hair, "27", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "28", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }

        if (serviceclickId.equals("10")) {
            tv5_toolbar.setText("Cleanup/ Facial");
            listsingle.add(new SingleServicemodel(R.drawable.hair, "29", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "30", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }

        if (serviceclickId.equals("11")) {
            tv5_toolbar.setText("Kids Special");
            listsingle.add(new SingleServicemodel(R.drawable.hair, "31", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "32", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }

        if (serviceclickId.equals("12")) {
            tv5_toolbar.setText("Add-ons");
            listsingle.add(new SingleServicemodel(R.drawable.hair, "33", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "34", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }

        if (serviceclickId.equals("13")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "35", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "36", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("14")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "37", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "38", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("15")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "39", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "40", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("16")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "41", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "42", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }

        if (serviceclickId.equals("17")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "43", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "44", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }

        if (serviceclickId.equals("18")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "45", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "46", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("19")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "47", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "48", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("20")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "49", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "50", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("21")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "51", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "52", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("22")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "53", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "54", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("23")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "55", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "56", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("24")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "57", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "58", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("25")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "59", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "60", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("26")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "61", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "62", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("27")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "63", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "64", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("28")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "65", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "66", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("29")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "67", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "68", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }
        if (serviceclickId.equals("30")) {
            listsingle.add(new SingleServicemodel(R.drawable.hair, "69", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));
            listsingle.add(new SingleServicemodel(R.drawable.hair, "70", "Head Massage", "299", "326", "9", "Head Massage", "20 min", 1));

        }

        rv_servicess_list.setLayoutManager(new LinearLayoutManager(SingleServiceListActivity.this, RecyclerView.VERTICAL, false));
        ssl = new SingleServiceListAdapter(SingleServiceListActivity.this, listsingle, SingleServiceListActivity.this);
        rv_servicess_list.setAdapter(ssl);

        ll_add_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_add_service.setVisibility(View.GONE);
                ll_increment.setVisibility(View.VISIBLE);
                ll_summary.setVisibility(View.VISIBLE);
                sum = Integer.parseInt(tv1_price.getText().toString());
                tv_total_amount.setText("\u20B9 " + String.valueOf(sum));
                // Toast.makeText(SingleServiceListActivity.this, "hjh", Toast.LENGTH_SHORT).show();
            }
        });

        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = Integer.parseInt(tv_count.getText().toString()) + 1;
                tv_count.setText(String.valueOf(total));
                int multiply = Integer.parseInt(tv1_price.getText().toString()) * 1;
                sum = sum + multiply;
                tv_total_amount.setText("\u20B9 " + String.valueOf(sum));
            }
        });

        iv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(tv_count.getText().toString()) == 1) {
                    ll_add_service.setVisibility(View.VISIBLE);
                    ll_increment.setVisibility(View.GONE);

                    //minus if no quantity
                    int multiply = Integer.parseInt(tv1_price.getText().toString()) * 1;
                    sum = sum - multiply;
                    tv_total_amount.setText("\u20B9 " + String.valueOf(sum));
                } else {
                    int total = Integer.parseInt(tv_count.getText().toString()) - 1;
                    tv_count.setText(String.valueOf(total));

                    int multiply = Integer.parseInt(tv1_price.getText().toString()) * 1;
                    sum = sum - multiply;
                    tv_total_amount.setText("\u20B9 " + String.valueOf(sum));
                }
            }
        });

        ll2_add_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll2_add_service.setVisibility(View.GONE);
                ll2_increment.setVisibility(View.VISIBLE);
                ll_summary.setVisibility(View.VISIBLE);
                sum = sum + Integer.parseInt(tv2_price.getText().toString());
                tv_total_amount.setText("\u20B9 " + String.valueOf(sum));
            }
        });

        iv2_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = Integer.parseInt(tv2_count.getText().toString()) + 1;
                tv2_count.setText(String.valueOf(total));
                int multiply = Integer.parseInt(tv2_price.getText().toString()) * 1;
                sum = sum + multiply;
                tv_total_amount.setText("\u20B9 " + String.valueOf(sum));

            }
        });

        iv2_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(tv2_count.getText().toString()) == 1) {
                    ll2_add_service.setVisibility(View.VISIBLE);
                    ll2_increment.setVisibility(View.GONE);

                    //minus if no quantity
                    int multiply = Integer.parseInt(tv2_price.getText().toString()) * 1;
                    sum = sum - multiply;
                    tv_total_amount.setText("\u20B9 " + String.valueOf(sum));
                } else {
                    int total = Integer.parseInt(tv2_count.getText().toString()) - 1;
                    tv2_count.setText(String.valueOf(total));

                    int multiply = Integer.parseInt(tv2_price.getText().toString()) * 1;
                    sum = sum - multiply;
                    tv_total_amount.setText("\u20B9 " + String.valueOf(sum));
                }
            }
        });

        ll_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sum==0) {
                    Toast.makeText(SingleServiceListActivity.this, "Add service", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(SingleServiceListActivity.this, SummaryActivity.class);
                    i.putExtra("SumSummary", String.valueOf(sum));
                    startActivity(i);
                }
            }
        });

        iv_servicelist_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void totall(int position, int rvsum) {
        sum = sum + rvsum;
        tv_total_amount.setText("\u20B9 " + String.valueOf(sum));
    }
}
