package com.elisvobs.metricinfo.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.metricinfo.R;
import com.elisvobs.metricinfo.adapter.PaperAdapter;
import com.elisvobs.metricinfo.model.Paper;
import com.elisvobs.metricinfo.util.DataManager;

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
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}