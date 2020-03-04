package com.elisvobs.metricinfo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.metricinfo.R;
import com.elisvobs.metricinfo.model.Tables;
import com.elisvobs.metricinfo.viewholder.TablesViewHolder;

import java.util.List;

public class TablesAdapter extends RecyclerView.Adapter<TablesViewHolder>{
    private List<Tables> items;

    public TablesAdapter(List<Tables> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public TablesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_list, parent, false);
        return new TablesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TablesViewHolder holder, int position) {
        holder.image.setImageResource(items.get(position).item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}