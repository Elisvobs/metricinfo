package com.infixus.metricinfo.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.infixus.metricinfo.R;
import com.infixus.metricinfo.ui.About;
import com.infixus.metricinfo.ui.Clothing;
import com.infixus.metricinfo.ui.Decimals;
import com.infixus.metricinfo.ui.Names;

public class InfoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView pic;
    public TextView text;
    private final Context context;

    public InfoViewHolder(View view) {
        super(view);
        pic = view.findViewById(R.id.info_image);
        text = view.findViewById(R.id.info_text);
        context = view.getContext();
        view.setClickable(true);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (getAdapterPosition()) {
            case 0:
                intent = new Intent(context, Names.class);
                break;
            case 1:
                intent = new Intent(context, Decimals.class);
                break;
            case 2:
                intent = new Intent(context, Clothing.class);
                break;
            case 3:
                intent = new Intent(context, About.class);
                break;
        }
        context.startActivity(intent);
    }

}