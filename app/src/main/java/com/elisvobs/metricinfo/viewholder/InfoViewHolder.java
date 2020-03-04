package com.elisvobs.metricinfo.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.metricinfo.R;
import com.elisvobs.metricinfo.ui.AboutActivity;
import com.elisvobs.metricinfo.ui.ClothingActivity;
import com.elisvobs.metricinfo.ui.DecimalActivity;
import com.elisvobs.metricinfo.ui.NamesActivity;
import com.elisvobs.metricinfo.ui.PaperActivity;
import com.elisvobs.metricinfo.ui.TyreActivity;

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
                intent = new Intent(context, NamesActivity.class);
                break;
            case 1:
                intent = new Intent(context, DecimalActivity.class);
                break;
            case 2:
                intent = new Intent(context, TyreActivity.class);
                break;
            case 3:
                intent = new Intent(context, PaperActivity.class);
                break;
            case 4:
                intent = new Intent(context, ClothingActivity.class);
                break;
            case 5:
                intent = new Intent(context, AboutActivity.class);
        }
        context.startActivity(intent);
    }

}