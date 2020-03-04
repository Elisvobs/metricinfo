package com.elisvobs.metricinfo.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.metricinfo.R;

public class DecimalViewHolder extends RecyclerView.ViewHolder {
    public TextView unit, prefix, symbol;

    public DecimalViewHolder(View view) {
        super(view);
        unit = view.findViewById(R.id.unit);
        prefix = view.findViewById(R.id.prefix);
        symbol = view.findViewById(R.id.symbol);
    }

}