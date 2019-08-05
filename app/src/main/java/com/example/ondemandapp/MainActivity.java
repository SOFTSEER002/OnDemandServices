package com.example.ondemandapp;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   // GridView gv_category;
    List<GridServicesModel> servicelist = new ArrayList<>();
    LinearLayout ll1,ll2,ll3,ll4,ll5,ll6,ll7,ll8,ll9,ll10,ll11,ll12,ll13,ll14,ll15,ll16,ll17,ll18,ll19,ll20,ll21;
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
        //gv_category = findViewById(R.id.gv_category);

       // ll_resources = findViewById(R.id.ll_resources);
       // ll_business = findViewById(R.id.ll_business);
       // ll_lifestyle = findViewById(R.id.ll_lifestyle);

        //ll_lifestyle.setOnClickListener(this);
       // ll_business.setOnClickListener(this);
      //  ll_resources.setOnClickListener(this);

        ll1=findViewById(R.id.ll1);
        ll2=findViewById(R.id.ll2);
        ll3=findViewById(R.id.ll3);
        ll4=findViewById(R.id.ll4);
        ll5=findViewById(R.id.ll5);
        ll6=findViewById(R.id.ll6);
        ll7=findViewById(R.id.ll7);
        ll8=findViewById(R.id.ll8);
        ll9=findViewById(R.id.ll9);
        ll10=findViewById(R.id.ll10);
        ll11=findViewById(R.id.ll11);
        ll12=findViewById(R.id.ll12);
        ll13=findViewById(R.id.ll13);
        ll14=findViewById(R.id.ll14);
        ll15=findViewById(R.id.ll15);
        ll16=findViewById(R.id.ll16);
        ll17=findViewById(R.id.ll17);
        ll18=findViewById(R.id.ll18);
        ll19=findViewById(R.id.ll19);
        ll20=findViewById(R.id.ll20);
        ll21=findViewById(R.id.ll21);

        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll4.setOnClickListener(this);
        ll5.setOnClickListener(this);
        ll6.setOnClickListener(this);
        ll7.setOnClickListener(this);
        ll8.setOnClickListener(this);
        ll9.setOnClickListener(this);
        ll10.setOnClickListener(this);
        ll11.setOnClickListener(this);
        ll12.setOnClickListener(this);
        ll13.setOnClickListener(this);
        ll14.setOnClickListener(this);
        ll15.setOnClickListener(this);
        ll16.setOnClickListener(this);
        ll17.setOnClickListener(this);
        ll18.setOnClickListener(this);
        ll19.setOnClickListener(this);
        ll20.setOnClickListener(this);
        ll21.setOnClickListener(this);



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
           /* case R.id.ll_lifestyle:
                i = new Intent(MainActivity.this, Categories.class);
                i.putExtra("CategoryType", "Lifestyle");
                startActivity(i);
                break;

            case R.id.ll_business:
                i = new Intent(MainActivity.this, Categories.class);
                i.putExtra("CategoryType", "Business");
                startActivity(i);
                break;

            case R.id.ll_resources:
                i = new Intent(MainActivity.this, Categories.class);
                i.putExtra("CategoryType", "Resources");
                startActivity(i);
                break;*/

            case R.id.ll1:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "house");
                startActivity(i);
                break;
            case R.id.ll2:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "office");
                startActivity(i);
                break;

            case R.id.ll3:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "car");
                startActivity(i);
                break;

            case R.id.ll4:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "laundry");
                startActivity(i);
                break;

            case R.id.ll5:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "ac");
                startActivity(i);
                break;
            case R.id.ll6:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "geyser");
                startActivity(i);
                break;

            case R.id.ll7:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "tv");
                startActivity(i);
                break;

            case R.id.ll8:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "washing");
                startActivity(i);
                break;

            case R.id.ll9:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "refrigerator");
                startActivity(i);
                break;

            case R.id.ll10:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "ro");
                startActivity(i);
                break;
            case R.id.ll11:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "bridal");
                startActivity(i);
                break;

            case R.id.ll12:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "men");
                startActivity(i);
                break;

            case R.id.ll13:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "women");
                startActivity(i);
                break;

            case R.id.ll14:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "electrician");
                startActivity(i);
                break;

            case R.id.ll15:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "plumber");
                startActivity(i);
                break;

            case R.id.ll16:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "carpenter");
                startActivity(i);
                break;

            case R.id.ll17:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "photography");
                startActivity(i);
                break;
            case R.id.ll18:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "transportation");
                startActivity(i);
                break;

            case R.id.ll19:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "website");
                startActivity(i);
                break;
            case R.id.ll20:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "app");
                startActivity(i);
                break;

            case R.id.ll21:
                i = new Intent(MainActivity.this, SingleDetailActivity.class);
                i.putExtra("CategoryType", "design");
                startActivity(i);
                break;





        }
    }
}
