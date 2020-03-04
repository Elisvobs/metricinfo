package com.elisvobs.metricinfo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.metricinfo.R;
import com.elisvobs.metricinfo.model.Tyre;
import com.elisvobs.metricinfo.viewholder.TyreViewHolder;

import java.util.List;

public class TyreAdapter extends RecyclerView.Adapter<TyreViewHolder>{
    private List<Tyre> tyres;

    public TyreAdapter(List<Tyre> tyres) {
        this.tyres = tyres;
    }

    @NonNull
    @Override
    public TyreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tyre_list, parent, false);
        return new TyreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TyreViewHolder holder, int position) {
        holder.psi.setText(tyres.get(position).psi);
        holder.kgm.setText(tyres.get(position).kgm);
    }

    @Override
    public int getItemCount() {
        return tyres.size();
    }

}