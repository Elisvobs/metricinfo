package com.elisvobs.metricinfo.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.metricinfo.R;
import com.elisvobs.metricinfo.adapter.TyreAdapter;
import com.elisvobs.metricinfo.model.Tyre;
import com.elisvobs.metricinfo.util.DataManager;

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
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}