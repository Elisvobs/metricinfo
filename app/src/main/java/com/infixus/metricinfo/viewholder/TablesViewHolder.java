package com.infixus.metricinfo.viewholder;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.infixus.metricinfo.R;

public class TablesViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;

    public TablesViewHolder(View view) {
        super(view);
        image = view.findViewById(R.id.item_image);
    }

}