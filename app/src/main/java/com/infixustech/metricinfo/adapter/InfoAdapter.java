package com.infixustech.metricinfo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infixustech.metricinfo.R;
import com.infixustech.metricinfo.model.Info;
import com.infixustech.metricinfo.viewholder.InfoViewHolder;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoViewHolder> {
    private List<Info> infoList;

    public InfoAdapter(List<Info> infoList) {
        this.infoList = infoList;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_list, parent,false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        holder.pic.setImageResource(infoList.get(position).image);
        holder.text.setText(infoList.get(position).infoName);
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

}