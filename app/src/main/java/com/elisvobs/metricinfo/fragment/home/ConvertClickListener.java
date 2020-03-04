//package com.elisvobs.metricinfo.fragment.home;
//
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//
//import com.elisvobs.metricinfo.R;
//
//public class ConvertClickListener implements android.widget.AdapterView.OnItemSelectedListener {
//    private Converter mConverter = new Converter();
//
//    public void adapter(int p) {
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mConverter.context,
//                p, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        adapter.notifyDataSetChanged();
//        mConverter.spinner2.setAdapter(adapter);
//        mConverter.spinner3.setAdapter(adapter);
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        parent.getItemAtPosition(position);
//
//        if (position == 0) {
//            adapter(R.array.nothing);
//        } else if (position == 1) {
//            adapter(R.array.length);
//        } else if (position == 2) {
//            adapter(R.array.mass);
//        } else if (position == 3) {
//            adapter(R.array.volume);
//        } else if (position == 4) {
//            adapter(R.array.temperature);
//        } else if (position == 5) {
//            adapter(R.array.area);
//        } else if (position == 6) {
//            adapter(R.array.velocity);
//        } else if (position == 7) {
//            adapter(R.array.energy);
//        } else if (position == 8) {
//            adapter(R.array.power);
//        } else if (position == 9) {
//            adapter(R.array.pressure);
//        } else if (position == 10) {
//            adapter(R.array.data);
//        }
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//
//}