package com.example.ondemandapp.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ondemandapp.R;

import java.util.List;

public class RecyclerviewTimeAdapter extends RecyclerView.Adapter<RecyclerviewTimeAdapter.ViewHolder> {
SharedPreferences sp_time;
SharedPreferences.Editor ed_time;
    Context context;
    List<String> list;
    int row_index;

    public RecyclerviewTimeAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_time, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tv_timee.setText(list.get(position));

        holder.tv_timee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();
                holder.tv_timee.setBackground(ContextCompat.getDrawable(context, R.drawable.dateblue_back));
                holder.tv_timee.setTextColor(context.getResources().getColor(R.color.blue));
                ed_time.putString("time",list.get(position));
                ed_time.commit();
            }
        });

        if (row_index == position) {
            holder.tv_timee.setBackground(ContextCompat.getDrawable(context, R.drawable.dateblue_back));
            holder.tv_timee.setTextColor(context.getResources().getColor(R.color.blue));
            ed_time.putString("time",list.get(position));
            ed_time.commit();
        } else {
            holder.tv_timee.setBackground(ContextCompat.getDrawable(context, R.drawable.date_back));
            holder.tv_timee.setTextColor(context.getResources().getColor(R.color.textcolor));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_timee;
        LinearLayout ll_timee;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_timee = itemView.findViewById(R.id.tv_timee);
            ll_timee = itemView.findViewById(R.id.ll_timee);

            sp_time=context.getSharedPreferences("BOOKINGSERVICE",Context.MODE_PRIVATE);
            ed_time=sp_time.edit();
        }
    }


}

