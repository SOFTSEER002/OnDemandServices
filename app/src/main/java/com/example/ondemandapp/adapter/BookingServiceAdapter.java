package com.example.ondemandapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ondemandapp.R;
import com.example.ondemandapp.interfaces.DeleteBooking;

import java.util.List;

public class BookingServiceAdapter extends RecyclerView.Adapter<BookingServiceAdapter.ViewHolder> {

    Context context;
    List<String> servicename, servicetype, date, time, day, total, bookingid;
    DeleteBooking db;

    public BookingServiceAdapter(Context context, List<String> servicename, List<String> servicetype,
                                 List<String> date, List<String> time, List<String> day, List<String> total, List<String> bookingid,
                                 DeleteBooking db) {
        this.context = context;
        this.servicename = servicename;
        this.servicetype = servicetype;
        this.date = date;
        this.time = time;
        this.day = day;
        this.total = total;
        this.bookingid = bookingid;
        this.db = db;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_booking_service, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv1.setText(servicename.get(position));
        holder.tv2.setText(servicetype.get(position));
        holder.tv3.setText("Rs. " + total.get(position));
        holder.tv4.setText(day.get(position) + ", " + date.get(position) + "th Aug - " + time.get(position));

        holder.tv_cancel_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deletebooking(position, Integer.parseInt(bookingid.get(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return servicename.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2, tv3, tv4, tv_cancel_booking;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv4);
            tv_cancel_booking = itemView.findViewById(R.id.tv_cancel_booking);
        }
    }
}
