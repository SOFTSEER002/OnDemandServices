package com.example.ondemandapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ondemandapp.R;

public class SingleServicePhotosAdapter extends RecyclerView.Adapter<SingleServicePhotosAdapter.ViewHolder> {
    Context context;
    int[] imageservice;

    public SingleServicePhotosAdapter(Context context, int[] imageservice) {
        this.context = context;
        this.imageservice = imageservice;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_single_service_photos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iv_show_photo.setImageResource(imageservice[position]);
    }

    @Override
    public int getItemCount() {
        return imageservice.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_show_photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_show_photo = itemView.findViewById(R.id.iv_show_photo);
        }
    }
}
