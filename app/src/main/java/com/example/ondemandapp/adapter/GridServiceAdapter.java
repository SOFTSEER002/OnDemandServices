package com.example.ondemandapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ondemandapp.R;
import com.example.ondemandapp.modelclass.GridServicesModel;

import java.util.List;

public class GridServiceAdapter extends BaseAdapter {

    Context context;
    List<GridServicesModel> servicelist;

    public GridServiceAdapter(Context context, List<GridServicesModel> servicelist) {
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
        if(view==null){
            view= LayoutInflater.from(context).inflate(R.layout.custom_grid_services,viewGroup,false);
        }

        TextView tv_service_name=view.findViewById(R.id.tv_service_name);
        ImageView iv_service_image=view.findViewById(R.id.iv_service_image);

        iv_service_image.setImageResource(servicelist.get(i).getServiceimage());
        tv_service_name.setText(servicelist.get(i).getServicename());


        return view;
    }
}
