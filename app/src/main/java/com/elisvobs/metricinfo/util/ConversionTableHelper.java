package com.elisvobs.metricinfo.util;

import android.content.Context;

import com.elisvobs.metricinfo.model.Tables;

import java.util.ArrayList;

public class ConversionTableHelper {
    private Context mContext;
    private String[] lengthHeaders = {"Centimetres", " ", "Inches"};
    private String[] weightHeaders = {"Kilograms", " ", "Pounds"};
    private String[] metricLengthHeaders = {"Metres", " ", "Yards"};
    private String[] volumeHeaders = {"Litres", " ", "Gallons"};
    private String[] baseLengthHeaders = {"Kilometres", " ", "Miles"};
    private String[] areaHeaders = {"Hectares", " ", "Acres"};

    public ConversionTableHelper(Context context) {
        mContext = context;
    }

    public String[] getLengthHeaders() {
        return lengthHeaders;
    }

    public String[] getWeightHeaders() {
        return weightHeaders;
    }

    public String[] getMetricLengthHeaders() {
        return metricLengthHeaders;
    }

    public String[] getVolumeHeaders() {
        return volumeHeaders;
    }

    public String[] getBaseLengthHeaders() {
        return baseLengthHeaders;
    }

    public String[] getAreaHeaders() {
        return areaHeaders;
    }

    public String[][] getLengthData() {
        Tables info = new Tables();
        ArrayList<Tables> cloba = new ArrayList<>();

        info.setFirstMetric("2.540");
        info.setCentral("1");
        info.setSecondMetric("0.394");
        cloba.add(info);

        info.setFirstMetric("5.080");
        info.setCentral("2");
        info.setSecondMetric("0.787");
        cloba.add(info);

        info.setFirstMetric("7.620");
        info.setCentral("3");
        info.setSecondMetric("1.181");
        cloba.add(info);

        info.setFirstMetric("10.160");
        info.setCentral("4");
        info.setSecondMetric("1.575");
        cloba.add(info);

        info.setFirstMetric("12.700");
        info.setCentral("5");
        info.setSecondMetric("1.969");
        cloba.add(info);

        info.setFirstMetric("15.240");
        info.setCentral("6");
        info.setSecondMetric("2.362");
        cloba.add(info);

        info.setFirstMetric("17.780");
        info.setCentral("7");
        info.setSecondMetric("2.756");
        cloba.add(info);

        info.setFirstMetric("20.320");
        info.setCentral("8");
        info.setSecondMetric("3.150");
        cloba.add(info);

        info.setFirstMetric("22.860");
        info.setCentral("9");
        info.setSecondMetric("3.543");
        cloba.add(info);

        info.setFirstMetric("25.400");
        info.setCentral("10");
        info.setSecondMetric("3.937");
        cloba.add(info);

        info.setFirstMetric("27.940");
        info.setCentral("11");
        info.setSecondMetric("4.331");
        cloba.add(info);

        info.setFirstMetric("30.480");
        info.setCentral("12");
        info.setSecondMetric("4.724");
        cloba.add(info);

        String[][] tableData = new String[cloba.size()][3];
        for (int i = 0; i < cloba.size(); i++) {

            info = cloba.get(i);
            tableData[i][0] = info.getFirstMetric();
            tableData[i][1] = info.getCentral();
            tableData[i][2] = info.getSecondMetric();
        }

        return tableData;
    }

    public String[][] getWeightData() {
        Tables info = new Tables();
        ArrayList<Tables> cloba = new ArrayList<>();

        info.setFirstMetric("0.113");
        info.setCentral("¼");
        info.setSecondMetric("0.553");
        cloba.add(info);

        info.setFirstMetric("0.227");
        info.setCentral("½");
        info.setSecondMetric("1.102");
        cloba.add(info);

        info.setFirstMetric("0.454");
        info.setCentral("1");
        info.setSecondMetric("2.205");
        cloba.add(info);

        info.setFirstMetric("0.907");
        info.setCentral("2");
        info.setSecondMetric("4.409");
        cloba.add(info);

        info.setFirstMetric("1.361");
        info.setCentral("3");
        info.setSecondMetric("6.614");
        cloba.add(info);

        info.setFirstMetric("1.814");
        info.setCentral("4");
        info.setSecondMetric("8.819");
        cloba.add(info);

        info.setFirstMetric("2.268");
        info.setCentral("5");
        info.setSecondMetric("11.023");
        cloba.add(info);

        info.setFirstMetric("2.722");
        info.setCentral("6");
        info.setSecondMetric("13.228");
        cloba.add(info);

        info.setFirstMetric("3.175");
        info.setCentral("7");
        info.setSecondMetric("15.432");
        cloba.add(info);

        info.setFirstMetric("3.629");
        info.setCentral("8");
        info.setSecondMetric("17.637");
        cloba.add(info);

        info.setFirstMetric("4.082");
        info.setCentral("9");
        info.setSecondMetric("19.842");
        cloba.add(info);

        info.setFirstMetric("4.536");
        info.setCentral("10");
        info.setSecondMetric("22.046");
        cloba.add(info);

        String[][] tableData = new String[cloba.size()][3];
        for (int i = 0; i < cloba.size(); i++) {

            info = cloba.get(i);
            tableData[i][0] = info.getFirstMetric();
            tableData[i][1] = info.getCentral();
            tableData[i][2] = info.getSecondMetric();
        }

        return tableData;
    }

    public String[][] getMetricLengthData() {
        Tables info = new Tables();
        ArrayList<Tables> cloba = new ArrayList<>();

        info.setFirstMetric("0.914");
        info.setCentral("1");
        info.setSecondMetric("1.094");
        cloba.add(info);

        info.setFirstMetric("1.829");
        info.setCentral("2");
        info.setSecondMetric("2.187");
        cloba.add(info);

        info.setFirstMetric("2.743");
        info.setCentral("3");
        info.setSecondMetric("3.281");
        cloba.add(info);

        info.setFirstMetric("3.658");
        info.setCentral("4");
        info.setSecondMetric("4.374");
        cloba.add(info);

        info.setFirstMetric("4.572");
        info.setCentral("5");
        info.setSecondMetric("5.468");
        cloba.add(info);

        info.setFirstMetric("5.486");
        info.setCentral("6");
        info.setSecondMetric("6.562");
        cloba.add(info);

        info.setFirstMetric("6.401");
        info.setCentral("7");
        info.setSecondMetric("7.655");
        cloba.add(info);

        info.setFirstMetric("7.315");
        info.setCentral("8");
        info.setSecondMetric("8.749");
        cloba.add(info);

        info.setFirstMetric("8.230");
        info.setCentral("9");
        info.setSecondMetric("9.843");
        cloba.add(info);

        info.setFirstMetric("9.144");
        info.setCentral("10");
        info.setSecondMetric("10.963");
        cloba.add(info);

        String[][] tableData = new String[cloba.size()][3];
        for (int i = 0; i < cloba.size(); i++) {

            info = cloba.get(i);
            tableData[i][0] = info.getFirstMetric();
            tableData[i][1] = info.getCentral();
            tableData[i][2] = info.getSecondMetric();
        }

        return tableData;
    }

    public String[][] getVolumeData() {
        Tables info = new Tables();
        ArrayList<Tables> cloba = new ArrayList<>();

        info.setFirstMetric("4.546");
        info.setCentral("1");
        info.setSecondMetric("0.220");
        cloba.add(info);

        info.setFirstMetric("9.092");
        info.setCentral("2");
        info.setSecondMetric("0.440");
        cloba.add(info);

        info.setFirstMetric("13.638");
        info.setCentral("3");
        info.setSecondMetric("0.660");
        cloba.add(info);

        info.setFirstMetric("18.184");
        info.setCentral("4");
        info.setSecondMetric("0.880");
        cloba.add(info);

        info.setFirstMetric("22.730");
        info.setCentral("5");
        info.setSecondMetric("1.100");
        cloba.add(info);

        info.setFirstMetric("27.276");
        info.setCentral("6");
        info.setSecondMetric("1.320");
        cloba.add(info);

        info.setFirstMetric("31.822");
        info.setCentral("7");
        info.setSecondMetric("1.540");
        cloba.add(info);

        info.setFirstMetric("36.368");
        info.setCentral("8");
        info.setSecondMetric("1.760");
        cloba.add(info);

        info.setFirstMetric("40.914");
        info.setCentral("9");
        info.setSecondMetric("1.980");
        cloba.add(info);

        info.setFirstMetric("45.460");
        info.setCentral("10");
        info.setSecondMetric("2.200");
        cloba.add(info);

        String[][] tableData = new String[cloba.size()][3];
        for (int i = 0; i < cloba.size(); i++) {

            info = cloba.get(i);
            tableData[i][0] = info.getFirstMetric();
            tableData[i][1] = info.getCentral();
            tableData[i][2] = info.getSecondMetric();
        }

        return tableData;
    }

    public String[][] getBaseLengthData() {
        Tables info = new Tables();
        ArrayList<Tables> cloba = new ArrayList<>();

        info.setFirstMetric("1.609");
        info.setCentral("1");
        info.setSecondMetric("0.621");
        cloba.add(info);

        info.setFirstMetric("3.219");
        info.setCentral("2");
        info.setSecondMetric("1.243");
        cloba.add(info);

        info.setFirstMetric("4.828");
        info.setCentral("3");
        info.setSecondMetric("1.864");
        cloba.add(info);

        info.setFirstMetric("6.437");
        info.setCentral("4");
        info.setSecondMetric("2.485");
        cloba.add(info);

        info.setFirstMetric("8.047");
        info.setCentral("5");
        info.setSecondMetric("3.107");
        cloba.add(info);

        info.setFirstMetric("9.656");
        info.setCentral("6");
        info.setSecondMetric("3.728");
        cloba.add(info);

        info.setFirstMetric("11.265");
        info.setCentral("7");
        info.setSecondMetric("4.350");
        cloba.add(info);

        info.setFirstMetric("12.875");
        info.setCentral("8");
        info.setSecondMetric("4.971");
        cloba.add(info);

        info.setFirstMetric("14.484");
        info.setCentral("9");
        info.setSecondMetric("5.292");
        cloba.add(info);

        info.setFirstMetric("16.093");
        info.setCentral("10");
        info.setSecondMetric("6.214");
        cloba.add(info);

        String[][] tableData = new String[cloba.size()][3];
        for (int i = 0; i < cloba.size(); i++) {

            info = cloba.get(i);
            tableData[i][0] = info.getFirstMetric();
            tableData[i][1] = info.getCentral();
            tableData[i][2] = info.getSecondMetric();
        }

        return tableData;
    }

    public String[][] getAreaData() {
        Tables info = new Tables();
        ArrayList<Tables> cloba = new ArrayList<>();

        info.setFirstMetric("0.405");
        info.setCentral("1");
        info.setSecondMetric("2.471");
        cloba.add(info);

        info.setFirstMetric("0.809");
        info.setCentral("2");
        info.setSecondMetric("4.942");
        cloba.add(info);

        info.setFirstMetric("1.214");
        info.setCentral("3");
        info.setSecondMetric("7.413");
        cloba.add(info);

        info.setFirstMetric("1.619");
        info.setCentral("4");
        info.setSecondMetric("9.884");
        cloba.add(info);

        info.setFirstMetric("2.023");
        info.setCentral("5");
        info.setSecondMetric("12.355");
        cloba.add(info);

        info.setFirstMetric("2.428");
        info.setCentral("6");
        info.setSecondMetric("14.826");
        cloba.add(info);

        info.setFirstMetric("2.833");
        info.setCentral("7");
        info.setSecondMetric("17.297");
        cloba.add(info);

        info.setFirstMetric("3.237");
        info.setCentral("8");
        info.setSecondMetric("19.769");
        cloba.add(info);

        info.setFirstMetric("3.642");
        info.setCentral("9");
        info.setSecondMetric("22.240");
        cloba.add(info);

        info.setFirstMetric("4.047");
        info.setCentral("10");
        info.setSecondMetric("24.711");
        cloba.add(info);

        String[][] tableData = new String[cloba.size()][3];
        for (int i = 0; i < cloba.size(); i++) {

            info = cloba.get(i);
            tableData[i][0] = info.getFirstMetric();
            tableData[i][1] = info.getCentral();
            tableData[i][2] = info.getSecondMetric();
        }

        return tableData;
    }

}