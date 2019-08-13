package com.example.ondemandapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.example.ondemandapp.adapter.MembershipImagesAdapter;
import com.example.ondemandapp.adapter.MembershipreviewAdapter;
import com.example.ondemandapp.modelclass.MembershipReviewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class ViewMembershipActivity extends AppCompatActivity {
    RecyclerView rv_member_reviews;
    List<MembershipReviewModel> memberlist=new ArrayList<>();
    MembershipreviewAdapter mra;
    ImageView iv_member_back;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.salon_service, R.drawable.salon_servicetwo};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_membership);


        mPager = findViewById(R.id.vw_images);
        iv_member_back = findViewById(R.id.iv_member_back);
        rv_member_reviews = findViewById(R.id.rv_member_reviews);

        for (int i = 0; i < IMAGES.length; i++) {
            ImagesArray.add(IMAGES[i]);
        }

        mPager.setAdapter(new MembershipImagesAdapter(ViewMembershipActivity.this, ImagesArray));
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



        memberlist.add(new MembershipReviewModel("Sneha, Delhi","Booked Salon at Home","Love DCService's membership. I saved almost 6k last year.","Reviewed on Jan 11th,2019"));
        memberlist.add(new MembershipReviewModel("Vatsala, Mumbai","Booked Spa at Home","Quite a clean offer - 15% off every time.Thanks a lot DcServices for your services.","Reviewed on Feb 21th, 2019"));
        memberlist.add(new MembershipReviewModel("Sneha, Delhi","Booked Salon at Home","Love DCService's membership. I saved almost 6k last year.","Reviewed on Jan 11th,2019"));
        memberlist.add(new MembershipReviewModel("Vatsala, Mumbai","Booked Spa at Home","Quite a clean offer - 15% off every time.Thanks a lot DcServices for your services.","Reviewed on Feb 21th, 2019"));
        rv_member_reviews.setLayoutManager(new LinearLayoutManager(ViewMembershipActivity.this, RecyclerView.VERTICAL, false));
        mra = new MembershipreviewAdapter(ViewMembershipActivity.this, memberlist);
        rv_member_reviews.setAdapter(mra);


        iv_member_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
