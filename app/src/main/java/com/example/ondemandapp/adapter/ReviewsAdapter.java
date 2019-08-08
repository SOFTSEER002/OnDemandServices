package com.example.ondemandapp.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ondemandapp.R;
import com.example.ondemandapp.modelclass.Reviewmodel;

import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder> {
Context context;
    List<Reviewmodel> reviewlist;
    public ReviewsAdapter(Context context, List<Reviewmodel> reviewlist) {
        this.context = context;
        this.reviewlist = reviewlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.custom_review,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.tv_review_name.setText(reviewlist.get(position).getName());
holder.tv_review_location.setText(reviewlist.get(position).getLocation());
holder.tv_review_date.setText(reviewlist.get(position).getDate());
holder.tv_review_quote.setText(reviewlist.get(position).getReview());
holder.tv_review_rating.setText(reviewlist.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return reviewlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_review_rating,tv_review_quote,tv_review_date,tv_review_location,tv_review_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_review_rating=itemView.findViewById(R.id.tv_review_rating);
            tv_review_name=itemView.findViewById(R.id.tv_review_name);
            tv_review_location=itemView.findViewById(R.id.tv_review_location);
            tv_review_date=itemView.findViewById(R.id.tv_review_date);
            tv_review_quote=itemView.findViewById(R.id.tv_review_quote);
        }
    }
}
