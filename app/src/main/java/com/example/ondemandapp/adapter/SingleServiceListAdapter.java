package com.example.ondemandapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ondemandapp.R;
import com.example.ondemandapp.interfaces.TotalSum;
import com.example.ondemandapp.modelclass.SingleServicemodel;

import java.util.List;

public class SingleServiceListAdapter extends RecyclerView.Adapter<SingleServiceListAdapter.ViewHolder> {
    Context context;
    List<SingleServicemodel> listsingle;
    int sum = 0;
    TotalSum interface_sum;

    public SingleServiceListAdapter(Context context, List<SingleServicemodel> listsingle, TotalSum interface_sum) {
        this.context = context;
        this.listsingle = listsingle;
        this.interface_sum = interface_sum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_rv_servicelist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tv_service_name.setText(listsingle.get(position).getServicename());
        holder.tv_off_price.setText("\u20B9 " + listsingle.get(position).getServiceoffprice());
        holder.tv_original_price.setText("\u20B9 " + listsingle.get(position).getServiceoriginalprice());
        holder.tv_discount.setText(listsingle.get(position).getServicediscount() + " % off");
        holder.tv_servicee_type.setText(listsingle.get(position).getServicetype());
        holder.tv_time.setText(listsingle.get(position).getServicetime());
        holder.iv_service_photo.setImageResource(listsingle.get(position).getImage());


        holder.ll3_add_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ll3_add_service.setVisibility(View.GONE);
                holder.ll3_increment.setVisibility(View.VISIBLE);

                int single = Integer.parseInt(listsingle.get(position).getServiceoffprice()) * 1;
                sum = sum + single;
                interface_sum.totall(position, sum);
                sum = 0;
            }
        });

        holder.iv3_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listsingle.get(position).setCount(listsingle.get(position).getCount() + 1);
                holder.tv3_count.setText(String.valueOf(listsingle.get(position).getCount()));

                int single = Integer.parseInt(listsingle.get(position).getServiceoffprice()) * 1;
                sum = sum + single;
                interface_sum.totall(position, sum);

                sum = 0;

            }
        });

        holder.iv3_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listsingle.get(position).getCount() == 1) {
                    holder.ll3_add_service.setVisibility(View.VISIBLE);
                    holder.ll3_increment.setVisibility(View.GONE);

                    int single = Integer.parseInt(listsingle.get(position).getServiceoffprice()) * 1;
                    sum = sum - single;
                    interface_sum.totall(position, sum);
                } else {
                    listsingle.get(position).setCount(listsingle.get(position).getCount() - 1);
                    holder.tv3_count.setText(String.valueOf(listsingle.get(position).getCount()));

                    int single = Integer.parseInt(listsingle.get(position).getServiceoffprice()) * 1;
                    sum = sum - single;
                    interface_sum.totall(position, sum);
                }

                sum = 0;
            }
        });

        if (listsingle.get(position).getServicetype().equals("")) {
            holder.iv_dot.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return listsingle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll3_increment, ll3_add_service;
        ImageView iv_service_photo, iv3_minus, iv3_add, iv_dot;
        TextView tv_service_name, tv_off_price, tv_original_price, tv3_count, tv_discount, tv_servicee_type, tv_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_service_photo = itemView.findViewById(R.id.iv_service_photo);
            tv_service_name = itemView.findViewById(R.id.tv_service_type);
            tv_off_price = itemView.findViewById(R.id.tv_off_price);
            tv_original_price = itemView.findViewById(R.id.tv_original_price);
            tv_discount = itemView.findViewById(R.id.tv_discount);
            tv_servicee_type = itemView.findViewById(R.id.tv_servicee);
            tv_time = itemView.findViewById(R.id.tv_time);
            ll3_increment = itemView.findViewById(R.id.ll3_increment);
            ll3_add_service = itemView.findViewById(R.id.ll3_add_service);
            iv3_minus = itemView.findViewById(R.id.iv3_minus);
            iv3_add = itemView.findViewById(R.id.iv3_add);
            tv3_count = itemView.findViewById(R.id.tv3_count);
            iv_dot = itemView.findViewById(R.id.iv_dot);
        }
    }
}
