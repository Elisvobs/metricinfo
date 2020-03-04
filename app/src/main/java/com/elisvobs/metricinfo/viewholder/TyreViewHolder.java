package com.elisvobs.metricinfo.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.metricinfo.R;

public class TyreViewHolder extends RecyclerView.ViewHolder {
    public TextView psi, kgm;

    public TyreViewHolder(View view) {
        super(view);
        psi = view.findViewById(R.id.psi);
        kgm = view.findViewById(R.id.kgm);
    }

}