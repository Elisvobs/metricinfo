package com.infixustech.metricinfo.fragment.tables;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.infixustech.metricinfo.R;
import com.infixustech.metricinfo.adapter.TablesAdapter;
import com.infixustech.metricinfo.model.Tables;
import com.infixustech.metricinfo.util.DataManager;

import java.util.List;

public class ConversionTables extends Fragment {
    private TablesViewModel homeViewModel;
    private TablesAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(TablesViewModel.class);

        View root = inflater.inflate(R.layout.fragment_tables, container, false);

        final RecyclerView recyclerView = root.findViewById(R.id.list_home);
        final List<Tables> tables = DataManager.getInstance().getTableList();

        adapter = new TablesAdapter(tables);
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

}