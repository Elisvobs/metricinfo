package com.elisvobs.metricinfo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.metricinfo.R;
import com.elisvobs.metricinfo.model.Decimal;
import com.elisvobs.metricinfo.viewholder.DecimalViewHolder;

import java.util.List;

public class DecimalAdapter extends RecyclerView.Adapter<DecimalViewHolder>{

    private List<Decimal> decimals;

    public DecimalAdapter(List<Decimal> decimals) {
        this.decimals = decimals;
    }

    @NonNull
    @Override
    public DecimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_list, parent, false);
        return new DecimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DecimalViewHolder holder, int position) {
        holder.unit.setText(decimals.get(position).unit);
        holder.prefix.setText(decimals.get(position).prefix);
        holder.symbol.setText(decimals.get(position).symbol);
    }

    @Override
    public int getItemCount() {
        return decimals.size();
    }

}