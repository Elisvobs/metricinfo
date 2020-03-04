package com.elisvobs.metricinfo.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.elisvobs.metricinfo.R;
import com.elisvobs.metricinfo.util.TableHelper;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.model.TableColumnDpWidthModel;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class NamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);
        setTitle(R.string.names);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TableHelper tableHelper=new TableHelper(this);

        TableView<String[]> tableView = findViewById(R.id.table_view);
        tableView.setColumnCount(4);
        tableView.setHeaderBackgroundColor(Color.parseColor("#FFFFFF"));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,tableHelper.getTableHeaders()));
        tableView.setHeaderElevation(4);
        tableView.setDataAdapter(new SimpleTableDataAdapter(this, tableHelper.getTableData()));
        tableView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        TableColumnDpWidthModel columnModel = new TableColumnDpWidthModel(
                this, 4, 225);
//        columnModel.setColumnWidth(1, 300);
//        columnModel.setColumnWidth(2, 275);
//        columnModel.setColumnWidth(3, 250);
//        columnModel.setColumnWidth(4, 100);
//        columnModel.setColumnWidth(3, 250);
//        columnModel.setColumnWidth(4, 200);
        tableView.setColumnModel(columnModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
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