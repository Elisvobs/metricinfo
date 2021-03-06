package com.infixus.metricinfo.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.infixus.metricinfo.R;

public class PaperViewHolder extends RecyclerView.ViewHolder {
    public TextView size, milli, inches;

    public PaperViewHolder(View view) {
        super(view);
        size = view.findViewById(R.id.size);
        milli = view.findViewById(R.id.mm);
        inches = view.findViewById(R.id.in);
    }

}