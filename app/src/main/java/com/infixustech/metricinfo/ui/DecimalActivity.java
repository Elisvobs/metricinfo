package com.infixustech.metricinfo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.infixustech.metricinfo.R;
import com.infixustech.metricinfo.adapter.DecimalAdapter;
import com.infixustech.metricinfo.model.Decimal;
import com.infixustech.metricinfo.util.DataManager;

import java.util.List;

public class DecimalActivity extends AppCompatActivity {
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