package com.example.ondemandapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import com.example.ondemandapp.adapter.GridServiceAdapter;
import com.example.ondemandapp.modelclass.GridServicesModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // GridView gv_category;
    TextView tv_txtt1, tv_txtt2,tv_loc1,tv_loc2;
    List<GridServicesModel> servicelist = new ArrayList<>();
    LinearLayout ll_women, ll_men, ll_cleaning, ll_electrician, ll_appliances, ll_massage, ll_yoga, ll_painting, ll_pest, ll_location;
    //GridServiceAdapter serviceAdapter;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.cleaning_one, R.drawable.beauty_three, R.drawable.development_four, R.drawable.repair_two};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    //   LinearLayout ll_resources, ll_business, ll_lifestyle;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mPager = findViewById(R.id.pager);
        tv_txtt1 = findViewById(R.id.tv_txtt1);
        tv_txtt2 = findViewById(R.id.tv_txtt2);
        ll_location = findViewById(R.id.ll_location);
        tv_loc1 = findViewById(R.id.tv_loc1);
        tv_loc2 = findViewById(R.id.tv_loc2);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/font.ttf");
        //tv_txtt1.setTypeface(custom_font);
        //tv_txtt2.setTypeface(custom_font);
        //gv_category = findViewById(R.id.gv_category);

        // ll_resources = findViewById(R.id.ll_resources);
        // ll_business = findViewById(R.id.ll_business);
        // ll_lifestyle = findViewById(R.id.ll_lifestyle);

        //ll_lifestyle.setOnClickListener(this);
        // ll_business.setOnClickListener(this);
        //  ll_resources.setOnClickListener(this);

        ll_women = findViewById(R.id.ll_women);
        ll_men = findViewById(R.id.ll_men);
        ll_cleaning = findViewById(R.id.ll_cleaning);
        ll_electrician = findViewById(R.id.ll_electrician);
        ll_appliances = findViewById(R.id.ll_appliances);
        ll_massage = findViewById(R.id.ll_massage);
        ll_yoga = findViewById(R.id.ll_yoga);
        ll_painting = findViewById(R.id.ll_painting);
        ll_pest = findViewById(R.id.ll_pest);

        ll_women.setOnClickListener(this);
        ll_men.setOnClickListener(this);
        ll_cleaning.setOnClickListener(this);
        ll_electrician.setOnClickListener(this);
        ll_appliances.setOnClickListener(this);
        ll_massage.setOnClickListener(this);
        ll_yoga.setOnClickListener(this);
        ll_painting.setOnClickListener(this);
        ll_pest.setOnClickListener(this);


        for (int i = 0; i < IMAGES.length; i++) {
            ImagesArray.add(IMAGES[i]);
        }

        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this, ImagesArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        NUM_PAGES = IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);
        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int pos) {
            }
        });


        servicelist.add(new GridServicesModel("House Cleaning", R.drawable.house_cleaning));
        servicelist.add(new GridServicesModel("Office Cleaning", R.drawable.office_cleaning));
        servicelist.add(new GridServicesModel("Car Wash", R.drawable.car_wash));
        servicelist.add(new GridServicesModel("Laundry &amp; Dry Cleaning", R.drawable.laundry));

        servicelist.add(new GridServicesModel("AC Service", R.drawable.air_conditioning));
        servicelist.add(new GridServicesModel("Geyser Service", R.drawable.geyser));
        servicelist.add(new GridServicesModel("LED TV Repair", R.drawable.tv));
        servicelist.add(new GridServicesModel("Washing machine Repair", R.drawable.washing_machine));
        servicelist.add(new GridServicesModel("Refrigerator Repair", R.drawable.fridge));
        servicelist.add(new GridServicesModel("RO Service", R.drawable.air_purifier));

        servicelist.add(new GridServicesModel("Bridal Makeup", R.drawable.bridal_makeup));
        servicelist.add(new GridServicesModel("Men Salon", R.drawable.men_salon));
        servicelist.add(new GridServicesModel("Women Salon", R.drawable.beauty));

        servicelist.add(new GridServicesModel("Electrician", R.drawable.electrical_repair));
        servicelist.add(new GridServicesModel("Plumber", R.drawable.plumber));
        servicelist.add(new GridServicesModel("Carpenter", R.drawable.carpenter));

        servicelist.add(new GridServicesModel("Photography", R.drawable.photography));
        servicelist.add(new GridServicesModel("Transportation", R.drawable.transportation));

        servicelist.add(new GridServicesModel("Website Development", R.drawable.website));
        servicelist.add(new GridServicesModel("App Development", R.drawable.app_development));
        servicelist.add(new GridServicesModel("Web Designer", R.drawable.website_design));




        Intent i = getIntent();
        String valuelocation=i.getStringExtra("LocationSave");
        if(valuelocation!=null){
            tv_loc1.setText(valuelocation);
            tv_loc2.setText(valuelocation+", India");
        }
        ll_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LocationActivity.class));
            }
        });

        //   serviceAdapter = new GridServiceAdapter(MainActivity.this, servicelist);
        //  gv_category.setAdapter(serviceAdapter);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(MainActivity.this, BookingsActivity.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(MainActivity.this, SettingActivity.class));

                    return true;


            }
            return false;
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_women:
                i = new Intent(MainActivity.this, TabListActivity.class);
                i.putExtra("CategoryType", "women");
                startActivity(i);
                break;
            case R.id.ll_men:
                i = new Intent(MainActivity.this, TabListActivity.class);
                i.putExtra("CategoryType", "men");
                startActivity(i);
                break;

            case R.id.ll_cleaning:
                i = new Intent(MainActivity.this, TabListActivity.class);
                i.putExtra("CategoryType", "cleaning");
                startActivity(i);
                break;

            case R.id.ll_appliances:
                i = new Intent(MainActivity.this, TabListActivity.class);
                i.putExtra("CategoryType", "appliances");
                startActivity(i);
                break;

            case R.id.ll_electrician:
                i = new Intent(MainActivity.this, TabListActivity.class);
                i.putExtra("CategoryType", "electrician");
                startActivity(i);
                break;

            case R.id.ll_massage:
                i = new Intent(MainActivity.this, TabListActivity.class);
                i.putExtra("CategoryType", "massage");
                startActivity(i);
                break;
            case R.id.ll_yoga:
                i = new Intent(MainActivity.this, TabListActivity.class);
                i.putExtra("CategoryType", "yoga");
                startActivity(i);
                break;

            case R.id.ll_painting:
                i = new Intent(MainActivity.this, TabListActivity.class);
                i.putExtra("CategoryType", "painting");
                startActivity(i);
                break;

            case R.id.ll_pest:
                i = new Intent(MainActivity.this, TabListActivity.class);
                i.putExtra("CategoryType", "pest");
                startActivity(i);
                break;


        }
    }
}
