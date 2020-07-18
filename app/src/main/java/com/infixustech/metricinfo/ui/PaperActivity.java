package com.infixustech.metricinfo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.infixustech.metricinfo.R;
import com.infixustech.metricinfo.adapter.PaperAdapter;
import com.infixustech.metricinfo.model.Paper;
import com.infixustech.metricinfo.util.DataManager;

import java.util.List;

public class PaperActivity extends AppCompatActivity {
    PaperAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);
        setTitle(R.string.paper);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RecyclerView recyclerView = findViewById(R.id.list_paper);
        final List<Paper> papers = DataManager.getInstance().getPaperList();

        mAdapter = new PaperAdapter(papers);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
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