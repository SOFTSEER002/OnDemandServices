package com.example.ondemandapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ondemandapp.R;
import com.example.ondemandapp.ServiceClickActivity;
import com.example.ondemandapp.modelclass.Womenmodel;

import java.util.List;

public class WomenAdapter extends RecyclerView.Adapter<WomenAdapter.ViewHolder> {
    Context context;
    List<Womenmodel> womenlist;
    Intent intent;
    SharedPreferences sp_bookinglist;
    SharedPreferences.Editor ed_bookinglist;

    public WomenAdapter(Context context, List<Womenmodel> womenlist) {
        this.context = context;
        this.womenlist = womenlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_women, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_women.setText(womenlist.get(position).getType());
        holder.iv_women.setImageResource(womenlist.get(position).getTypeimage());

        holder.ll_singlelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, ServiceClickActivity.class);
                intent.putExtra("TypeServiceId", womenlist.get(position).getId());
                context.startActivity(intent);

                ed_bookinglist.putString("servicee_name",womenlist.get(position).getType());
                ed_bookinglist.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return womenlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_women;
        TextView tv_women;
        LinearLayout ll_singlelayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_women = itemView.findViewById(R.id.iv_women);
            tv_women = itemView.findViewById(R.id.tv_women);
            ll_singlelayout = itemView.findViewById(R.id.ll_singlelayout);

            sp_bookinglist = context.getSharedPreferences("BOOKINGSERVICE", Context.MODE_PRIVATE);
            ed_bookinglist = sp_bookinglist.edit();
        }
    }
}
