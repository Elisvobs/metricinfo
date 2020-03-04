package com.elisvobs.metricinfo.fragment.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.elisvobs.metricinfo.R;
import com.elisvobs.metricinfo.adapter.InfoAdapter;
import com.elisvobs.metricinfo.model.Info;
import com.elisvobs.metricinfo.util.DataManager;

import java.util.List;

public class ExtraInfo extends Fragment {
    private InfoViewModel mInfoViewModel;
    private InfoAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mInfoViewModel = new ViewModelProvider(this).get(InfoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        final RecyclerView recyclerView = root.findViewById(R.id.list_info);
        final List<Info> infoList = DataManager.getInstance().getInfoList();

        adapter = new InfoAdapter(infoList);
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

}