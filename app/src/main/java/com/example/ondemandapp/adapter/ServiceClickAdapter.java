package com.example.ondemandapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ondemandapp.R;
import com.example.ondemandapp.SingleServiceListActivity;
import com.example.ondemandapp.modelclass.ServiceClickModel;

import java.util.List;

public class ServiceClickAdapter extends BaseAdapter {
Intent intent;
    Context context;
    List<ServiceClickModel> servicelist;
    public ServiceClickAdapter(Context context, List<ServiceClickModel> servicelist) {
        this.context = context;
        this.servicelist = servicelist;
    }

    @Override
    public int getCount() {
        return servicelist.size();
    }

    @Override
    public Object getItem(int i) {
        return servicelist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_service_click, viewGroup, false);

        }

        ImageView iv_image=view.findViewById(R.id.iv_image);
        TextView tv_text=view.findViewById(R.id.tv_text);
        LinearLayout ll_single_service=view.findViewById(R.id.ll_single_service);

        iv_image.setImageResource(servicelist.get(i).getImage());
        tv_text.setText(servicelist.get(i).getText());

        ll_single_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(context, SingleServiceListActivity.class);
                intent.putExtra("ClickServiceId",servicelist.get(i).getId());
                context.startActivity(intent);
            }
        });
        return view;
    }
}
