package com.example.ondemandapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ondemandapp.R;
import com.example.ondemandapp.modelclass.ServiceClickModel;

import java.util.List;

public class ServiceClickAdapter extends BaseAdapter {

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_service_click, viewGroup, false);

        }

        ImageView iv_image=view.findViewById(R.id.iv_image);
        TextView tv_text=view.findViewById(R.id.tv_text);

        iv_image.setImageResource(servicelist.get(i).getImage());
        tv_text.setText(servicelist.get(i).getText());
        return view;
    }
}
