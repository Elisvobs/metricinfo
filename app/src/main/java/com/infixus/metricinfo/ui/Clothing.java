package com.infixus.metricinfo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.infixus.metricinfo.R;

public class Clothing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
        setTitle(R.string.clothing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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