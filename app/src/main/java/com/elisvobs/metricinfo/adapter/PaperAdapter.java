package com.elisvobs.metricinfo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.metricinfo.R;
import com.elisvobs.metricinfo.model.Paper;
import com.elisvobs.metricinfo.viewholder.PaperViewHolder;

import java.util.List;

public class PaperAdapter extends RecyclerView.Adapter<PaperViewHolder>{
    private List<Paper> papers;

    public PaperAdapter(List<Paper> papers) {
        this.papers = papers;
    }

    @NonNull
    @Override
    public PaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paper_list, parent, false);
        return new PaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaperViewHolder holder, int position) {
        holder.size.setText(papers.get(position).size);
        holder.milli.setText(papers.get(position).milli);
        holder.inches.setText(papers.get(position).inches);
    }

    @Override
    public int getItemCount() {
        return papers.size();
    }

}