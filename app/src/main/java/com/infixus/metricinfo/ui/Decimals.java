package com.infixus.metricinfo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.infixus.metricinfo.R;
import com.infixus.metricinfo.adapter.DecimalAdapter;
import com.infixus.metricinfo.model.Decimal;
import com.infixus.metricinfo.util.DataManager;

import java.util.List;

public class Decimals extends AppCompatActivity {
    DecimalAdapter mDecimalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal);
        setTitle(R.string.units);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RecyclerView mRecyclerView = findViewById(R.id.list_unit);
        final List<Decimal> decimals = DataManager.getInstance().getDecimalList();

        mDecimalAdapter = new DecimalAdapter(decimals);
        mRecyclerView.setAdapter(mDecimalAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDecimalAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}