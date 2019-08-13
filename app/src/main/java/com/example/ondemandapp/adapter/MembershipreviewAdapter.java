package com.example.ondemandapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ondemandapp.R;
import com.example.ondemandapp.modelclass.MembershipReviewModel;

import java.util.List;

public class MembershipreviewAdapter extends RecyclerView.Adapter<MembershipreviewAdapter.ViewHolder> {
    Context context;
    List<MembershipReviewModel> memberlist;

    public MembershipreviewAdapter(Context context, List<MembershipReviewModel> memberlist) {
        this.context = context;
        this.memberlist = memberlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.members_reviews, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_mem_name.setText(memberlist.get(position).getMembername());
        holder.tv_mem_type.setText(memberlist.get(position).getMember_salontype());
        holder.tv_mem_quote.setText(memberlist.get(position).getMember_quote());
        holder.tv_mem_reviewdon.setText(memberlist.get(position).getMember_reviewdon());
    }

    @Override
    public int getItemCount() {
        return memberlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_mem_reviewdon, tv_mem_quote, tv_mem_type, tv_mem_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_mem_reviewdon = itemView.findViewById(R.id.tv_mem_reviewdon);
            tv_mem_quote = itemView.findViewById(R.id.tv_mem_quote);
            tv_mem_type = itemView.findViewById(R.id.tv_mem_type);
            tv_mem_name = itemView.findViewById(R.id.tv_mem_name);
        }
    }
}
