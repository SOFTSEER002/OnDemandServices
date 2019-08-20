package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ondemandapp.fragments.ApplianceRepairFragment;
import com.example.ondemandapp.fragments.CleaningFragment;
import com.example.ondemandapp.fragments.ElectricianFragment;
import com.example.ondemandapp.fragments.MassageFragment;
import com.example.ondemandapp.fragments.MenSalon;
import com.example.ondemandapp.fragments.PaintingFragment;
import com.example.ondemandapp.fragments.PestFragment;
import com.example.ondemandapp.fragments.WomenFragment;
import com.example.ondemandapp.fragments.YogaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabListActivity extends AppCompatActivity implements WomenFragment.OnFragmentInteractionListener,MenSalon.OnFragmentInteractionListener
,CleaningFragment.OnFragmentInteractionListener,ElectricianFragment.OnFragmentInteractionListener,ApplianceRepairFragment.OnFragmentInteractionListener,
MassageFragment.OnFragmentInteractionListener,YogaFragment.OnFragmentInteractionListener,PaintingFragment.OnFragmentInteractionListener,
PestFragment.OnFragmentInteractionListener{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ImageView iv_services_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_list);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        iv_services_back = findViewById(R.id.iv_services_back);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabTextColors(getResources().getColor(R.color.white),getResources().getColor(R.color.darkorange));

        String categoryy=getIntent().getStringExtra("CategoryType");
        if(categoryy.equals("women")){
            TabLayout.Tab tab = tabLayout.getTabAt(0);
            tab.select();
        }

        if(categoryy.equals("men")){
            TabLayout.Tab tab = tabLayout.getTabAt(1);
            tab.select();
        }

        if(categoryy.equals("cleaning")){
            TabLayout.Tab tab = tabLayout.getTabAt(2);
            tab.select();
        }
        if(categoryy.equals("electrician")){
            TabLayout.Tab tab = tabLayout.getTabAt(3);
            tab.select();
        }
        if(categoryy.equals("massage")){
            TabLayout.Tab tab = tabLayout.getTabAt(5);
            tab.select();
        }
        if(categoryy.equals("yoga")){
            TabLayout.Tab tab = tabLayout.getTabAt(6);
            tab.select();
        }
        if(categoryy.equals("painting")){
            TabLayout.Tab tab = tabLayout.getTabAt(7);
            tab.select();
        }
        if(categoryy.equals("pest")){
            TabLayout.Tab tab = tabLayout.getTabAt(8);
            tab.select();
        }
        if(categoryy.equals("appliances")){
            TabLayout.Tab tab = tabLayout.getTabAt(4);
            tab.select();
        }

        iv_services_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new WomenFragment(), "Salon at Home for Women");
        adapter.addFragment(new MenSalon(), "Salon at Home for Men");
        adapter.addFragment(new CleaningFragment(), "Cleaning");
        adapter.addFragment(new ElectricianFragment(), "Electrician,Plumber,Carpenter");
        adapter.addFragment(new ApplianceRepairFragment(), "Appliances \u0026 Electronics Repair");
        adapter.addFragment(new MassageFragment(), "Massage at Home");
        adapter.addFragment(new YogaFragment(), "Fitness \u0026 Yoga");
        adapter.addFragment(new PaintingFragment(), "Painting");
        adapter.addFragment(new PestFragment(), "Pest Control");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
