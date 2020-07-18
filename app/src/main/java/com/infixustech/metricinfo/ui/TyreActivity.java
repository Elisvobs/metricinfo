package com.infixustech.metricinfo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.infixustech.metricinfo.R;
import com.infixustech.metricinfo.adapter.TyreAdapter;
import com.infixustech.metricinfo.model.Tyre;
import com.infixustech.metricinfo.util.DataManager;

import java.util.List;

public class TyreActivity extends AppCompatActivity {
    TyreAdapter mTyreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyre);
        setTitle(R.string.tyre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RecyclerView recyclerView = findViewById(R.id.list_tyre);
        final List<Tyre> tyres = DataManager.getInstance().getTyreList();

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