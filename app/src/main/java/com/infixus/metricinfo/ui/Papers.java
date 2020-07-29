package com.infixus.metricinfo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.infixus.metricinfo.R;
import com.infixus.metricinfo.adapter.PaperAdapter;
import com.infixus.metricinfo.model.Paper;
import com.infixus.metricinfo.util.DataManager;

import java.util.List;

public class Papers extends AppCompatActivity {
    PaperAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);
        setTitle(R.string.paper);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final RecyclerView recyclerView = findViewById(R.id.list_paper);
        final List<com.infixus.metricinfo.model.Paper> papers = DataManager.getInstance().getPaperList();

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