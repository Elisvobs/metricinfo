package com.elisvobs.metricinfo.util;

import android.content.Context;

import com.elisvobs.metricinfo.model.TableInfo;

import java.util.ArrayList;

public class TableHelper {
    private Context mContext;
    private String[] tableHeaders = {"Quantity", "Name of Unit", "Value", "Symbol"};

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

        info.setQuantity("Power");
        info.setUnitName("Watt");
        info.setValue("SI Unit");
        info.setSymbol("W");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("kilowatt");
        info.setValue("1 000 W");
        info.setSymbol("kW");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("megawatt");
        info.setValue("1 000 000 W");
        info.setSymbol("MW");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("Density");
        info.setUnitName("kilogram per cubic metre");
        info.setValue("SI Unit");
        info.setSymbol("kg/m\u00B2");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("tonne per cubic metre");
        info.setValue("1 000 kg/m\u00B2");
        info.setSymbol("t/m\u00B2");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("gram per cubic metre");
        info.setValue("0.001 kg/m\u00B2");
        info.setSymbol("g/m\u00B2");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("Fluid Density");
        info.setUnitName("kilogram per litre");
        info.setValue("1 000 kg/m\u00B2");
        info.setSymbol("kg/l");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("Pressure");
        info.setUnitName("pascal");
        info.setValue("SI Unit (N/m\u00B2)");
        info.setSymbol("Pa");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("kilopascal");
        info.setValue("1 000 Pa");
        info.setSymbol("kPa");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("megapascal");
        info.setValue("1 000 000 Pa");
        info.setSymbol("MPa");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity(" ");
        info.setUnitName("millibar");
        info.setValue("100 Pa");
        info.setSymbol("mb");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("Electric Current");
        info.setUnitName("ampere");
        info.setValue("Base Unit");
        info.setSymbol("A");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("milliampere");
        info.setValue("0.001 A");
        info.setSymbol("mA");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("Potential Difference");
        info.setUnitName("volt");
        info.setValue("SI Unit");
        info.setSymbol("V");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("microvolt");
        info.setValue("0.000 001 V");
        info.setSymbol("µV");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("millivolt");
        info.setValue("0.001 V");
        info.setSymbol("mV");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("kilovolt");
        info.setValue("1 000 V");
        info.setSymbol("kV");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("megavolt");
        info.setValue("1 000 000 V");
        info.setSymbol("MV");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("Electrical Resistance");
        info.setUnitName("ohm");
        info.setValue("SI Unit");
        info.setSymbol("\uAB65");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("microohm");
        info.setValue("0.000 001 \uAB65");
        info.setSymbol("µ\uAB65");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("megaohm");
        info.setValue("1 000 000 \uAB65");
        info.setSymbol("M\uAB65");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("Frequency");
        info.setUnitName("hertz");
        info.setValue("SI Unit");
        info.setSymbol("Hz");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("kilohertz");
        info.setValue("1 000 Hz");
        info.setSymbol("kHz");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("megahertz");
        info.setValue("1 000 000 Hz");
        info.setSymbol("MHz");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("gigahertz");
        info.setValue("1 000 000 000 Hz");
        info.setSymbol("GHz");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("Temperature");
        info.setUnitName("Kelvin");
        info.setValue("SI Unit");
        info.setSymbol("K");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("Degree Celsius");
        info.setValue("K - 273.15");
        info.setSymbol("\u2103");
        tableList.add(info);

        info = new TableInfo();
        info.setQuantity("");
        info.setUnitName("Degree Fahrenheit");
        info.setValue("(K - 273.15) * 1.8 + 32");
        info.setSymbol("\u2109");
        tableList.add(info);

        String[][] tableData = new String[tableList.size()][4];
        for (int i = 0; i < tableList.size(); i++) {

            info = tableList.get(i);
            tableData[i][0] = info.getQuantity();
            tableData[i][1] = info.getUnitName();
            tableData[i][2] = info.getValue();
            tableData[i][3] = info.getSymbol();
        }

        return tableData;
    }

}