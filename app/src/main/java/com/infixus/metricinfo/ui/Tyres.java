package com.infixus.metricinfo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.infixus.metricinfo.R;
import com.infixus.metricinfo.adapter.TyreAdapter;
import com.infixus.metricinfo.model.Tyre;
import com.infixus.metricinfo.util.DataManager;

import java.util.List;

public class Tyres extends AppCompatActivity {
    TyreAdapter mTyreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyre);
        setTitle(R.string.tyre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RecyclerView recyclerView = findViewById(R.id.list_tyre);
        final List<com.infixus.metricinfo.model.Tyre> tyres = DataManager.getInstance().getTyreList();

        mTyreAdapter = new TyreAdapter(tyres);
        recyclerView.setAdapter(mTyreAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTyreAdapter.notifyDataSetChanged();
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