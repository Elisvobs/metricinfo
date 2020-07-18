package com.infixustech.metricinfo.util;

import android.content.Context;

import com.infixustech.metricinfo.model.TableInfo;

import java.util.ArrayList;

public class TableHelper {
    private Context mContext;
    private String[] tableHeaders = {"Metric", "Unit", "Value", "Symbol"};

    public TableHelper(Context context) {
        mContext = context;
    }

    //Return Table Headers
    public String[] getTableHeaders() {
        return tableHeaders;
    }

    //Return Table Rows
    public String[][] getTableData() {
        TableInfo info = new TableInfo();
        ArrayList<TableInfo> tableList = new ArrayList<>();

        info.setMetric("Power");
        info.setSymbol("W");
        info.setUnit("Watt");
        info.setValue("SI Unit");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("kW");
        info.setUnit("kilowatt");
        info.setValue("1 000 W");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("MW");
        info.setUnit("megawatt");
        info.setValue("1 000 000 W");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("Density");
        info.setSymbol("kg/m\u00B3");
        info.setUnit("kilogram/metre\u00B3");
        info.setValue("SI Unit");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("t/m\u00B3");
        info.setUnit("tonne/metre\u00B3");
        info.setValue("1 000 kg/m\u00B3");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("g/m\u00B3");
        info.setUnit("gram/metre\u00B3");
        info.setValue("0.001 kg/m\u00B3");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("kg/L");
        info.setUnit("kilogram/litre");
        info.setValue("1 000 kg/m\u00B3");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("Pressure");
        info.setSymbol("Pa");
        info.setUnit("Pascal");
        info.setValue("SI Unit (N/m\u00B2)");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("kPa");
        info.setUnit("kilopascal");
        info.setValue("1 000 Pa");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("MPa");
        info.setUnit("megapascal");
        info.setValue("1 000 000 Pa");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric(" ");
        info.setSymbol("mb");
        info.setUnit("millibar");
        info.setValue("100 Pa");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("Current");
        info.setSymbol("A");
        info.setUnit("ampere");
        info.setValue("Base Unit");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("mA");
        info.setUnit("milliampere");
        info.setValue("0.001 A");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("Voltage");
        info.setSymbol("V");
        info.setUnit("volt");
        info.setValue("SI Unit");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("µV");
        info.setUnit("microvolt");
        info.setValue("0.000 001 V");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("mV");
        info.setUnit("millivolt");
        info.setValue("0.001 V");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("kV");
        info.setUnit("kilovolt");
        info.setValue("1 000 V");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("MV");
        info.setUnit("megavolt");
        info.setValue("1 000 000 V");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("Resistance");
        info.setSymbol("\uAB65");
        info.setUnit("ohm");
        info.setValue("SI Unit");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("µ\uAB65");
        info.setUnit("microohm");
        info.setValue("0.000 001 \uAB65");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("M\uAB65");
        info.setUnit("megaohm");
        info.setValue("1 000 000 \uAB65");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("Frequency");
        info.setSymbol("Hz");
        info.setUnit("hertz");
        info.setValue("SI Unit");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("kHz");
        info.setUnit("kilohertz");
        info.setValue("1 000 Hz");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("MHz");
        info.setUnit("megahertz");
        info.setValue("1 000 000 Hz");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("GHz");
        info.setUnit("gigahertz");
        info.setValue("1 000 000 000 Hz");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("Temperature");
        info.setSymbol("K");
        info.setUnit("Kelvin");
        info.setValue("SI Unit");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("\u2103");
        info.setUnit("Celsius");
        info.setValue("K - 273.15");
        tableList.add(info);

        info = new TableInfo();
        info.setMetric("");
        info.setSymbol("\u2109");
        info.setUnit("Fahrenheit");
        info.setValue("(K - 273.15) * 1.8 + 32");
        tableList.add(info);

        String[][] tableData = new String[tableList.size()][4];
        for (int i = 0; i < tableList.size(); i++) {

            info = tableList.get(i);
            tableData[i][0] = info.getMetric();
            tableData[i][1] = info.getUnit();
            tableData[i][2] = info.getValue();
            tableData[i][3] = info.getSymbol();
        }

        return tableData;
    }

}