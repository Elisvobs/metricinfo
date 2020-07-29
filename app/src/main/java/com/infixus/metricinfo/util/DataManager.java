package com.infixus.metricinfo.util;

import com.infixus.metricinfo.R;
import com.infixus.metricinfo.model.Decimal;
import com.infixus.metricinfo.model.Info;
import com.infixus.metricinfo.model.Paper;
import com.infixus.metricinfo.model.Tables;
import com.infixus.metricinfo.model.Tyre;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String NEG = "10\u207B";
    private static final String ON = "\u00B9";
    private static final String NON = "10\u00B9";
    private static final String FI = "\u2075";
    private static final String EX = "\u2078";
    private static final String TW = "\u00B2";

    private List<Decimal> mDecimals = new ArrayList<>();
    private List<Paper> mPaperList = new ArrayList<>();
    private List<Tyre> mTyreList = new ArrayList<>();
    private List<Tables> mTablesList = new ArrayList<>();
    private List<Info> mInfoList = new ArrayList<>();

    public static DataManager getInstance() {
        DataManager ourInstance = new DataManager();

        ourInstance.initializeDecimalList();
        ourInstance.initializePaperList();
        ourInstance.initializeTyreList();
        ourInstance.initializeTableList();
        ourInstance.initializeInfoList();

        return ourInstance;
    }

    public List<Decimal> getDecimalList() {
        return mDecimals;
    }

    public List<Paper> getPaperList() {
        return mPaperList;
    }

    public List<Tyre> getTyreList() {
        return mTyreList;
    }

    public List<Tables> getTableList() {
        return mTablesList;
    }

    public List<Info> getInfoList() {
        return mInfoList;
    }

    private void initializeInfoList() {
        mInfoList.add(new Info(R.drawable.ic_symbol, R.string.names));
        mInfoList.add(new Info(R.drawable.ic_unit, R.string.units));
//        mInfoList.add(new Info(R.drawable.ic_pressure, R.string.tyre));
//        mInfoList.add(new Info(R.drawable.ic_paper, R.string.paper));
        mInfoList.add(new Info(R.drawable.ic_clothing, R.string.clothing));
        mInfoList.add(new Info(R.drawable.ic_about, R.string.about));
    }

    private void initializeTableList() {
        mTablesList.add(new Tables(R.drawable.cm));
        mTablesList.add(new Tables(R.drawable.kg));
        mTablesList.add(new Tables(R.drawable.m));
        mTablesList.add(new Tables(R.drawable.l));
        mTablesList.add(new Tables(R.drawable.km));
        mTablesList.add(new Tables(R.drawable.ha));
    }

    private void initializeTyreList() {
        mTyreList.add(new Tyre(R.string._20, R.string._1_41));
        mTyreList.add(new Tyre(R.string._22, R.string._1_55));
        mTyreList.add(new Tyre(R.string._24, R.string._1_69));
        mTyreList.add(new Tyre(R.string._26, R.string._1_83));
        mTyreList.add(new Tyre(R.string._28, R.string._1_97));
        mTyreList.add(new Tyre(R.string._30, R.string._2_11));
        mTyreList.add(new Tyre(R.string._32, R.string._2_25));
        mTyreList.add(new Tyre(R.string._34, R.string._2_39));
        mTyreList.add(new Tyre(R.string._36, R.string._2_5_3));
        mTyreList.add(new Tyre(R.string._38, R.string._2_6_7));
        mTyreList.add(new Tyre(R.string._40, R.string._2_8_2));
        mTyreList.add(new Tyre(R.string._42, R.string._2_9_6));
        mTyreList.add(new Tyre(R.string._44, R.string._3_1_0));
        mTyreList.add(new Tyre(R.string._46, R.string._3_2_4));
        mTyreList.add(new Tyre(R.string._48, R.string._3_3_8));
        mTyreList.add(new Tyre(R.string._50, R.string._3_5_2));
        mTyreList.add(new Tyre(R.string._52, R.string._3_6_6));
        mTyreList.add(new Tyre(R.string._54, R.string._3_8_0));
    }

    private void initializePaperList() {
        mPaperList.add(new Paper(R.string.oao, R.string.oaom, R.string.oaoi));
        mPaperList.add(new Paper(R.string.oa1, R.string.oa1m, R.string.oa1i));
        mPaperList.add(new Paper(R.string.oa2, R.string.oa2m, R.string.oa2i));
        mPaperList.add(new Paper(R.string.a0, R.string.aom, R.string.aoi));
        mPaperList.add(new Paper(R.string.a1, R.string.a1m, R.string.a1i));
        mPaperList.add(new Paper(R.string.a2, R.string.a2m, R.string.a2i));
        mPaperList.add(new Paper(R.string.a3, R.string.a3m, R.string.a3i));
        mPaperList.add(new Paper(R.string.a4, R.string.a4m, R.string.a4i));
        mPaperList.add(new Paper(R.string.a5, R.string.a5m, R.string.a5i));
        mPaperList.add(new Paper(R.string.a6, R.string.a6m, R.string.a6i));
        mPaperList.add(new Paper(R.string.a7, R.string.a7m, R.string.a7i));
        mPaperList.add(new Paper(R.string.a8, R.string.a8m, R.string.a8i));
        mPaperList.add(new Paper(R.string.a9, R.string.a9m, R.string.a9i));
        mPaperList.add(new Paper(R.string.a10, R.string.a10m, R.string.a10i));
        mPaperList.add(new Paper(R.string.b0, R.string.bom, R.string.boi));
        mPaperList.add(new Paper(R.string.b1, R.string.b1m, R.string.b1i));
        mPaperList.add(new Paper(R.string.b2, R.string.b2m, R.string.b2i));
        mPaperList.add(new Paper(R.string.b3, R.string.b3m, R.string.b3i));
        mPaperList.add(new Paper(R.string.b4, R.string.b4m, R.string.b4i));
        mPaperList.add(new Paper(R.string.b5, R.string.b5m, R.string.b5i));
    }

    private void initializeDecimalList() {

        mDecimals.add(new Decimal("10", R.string.deca, R.string._d1));
        mDecimals.add(new Decimal("10\u00B2", R.string.hecto, R.string._h));
        mDecimals.add(new Decimal("10\u00B3", R.string.kilo, R.string._k));
        mDecimals.add(new Decimal("10\u2076", R.string.mega, R.string._m1));
        mDecimals.add(new Decimal("10\u2079", R.string.tera, R.string._t));
        mDecimals.add(new Decimal(NON + FI, R.string.peta, R.string._p1));
        mDecimals.add(new Decimal(NON + EX, R.string.exa, R.string._e));
        mDecimals.add(new Decimal(NEG + ON, R.string.deci, R.string._d));
        mDecimals.add(new Decimal(NEG + TW, R.string.centi, R.string._c));
        mDecimals.add(new Decimal(NEG + "\u00B3", R.string.milli, R.string._m));
        mDecimals.add(new Decimal(NEG + "\u2076", R.string.micro, R.string._u));
        mDecimals.add(new Decimal(NEG + "\u2079", R.string.nano, R.string._n));
        mDecimals.add(new Decimal(NEG + ON + TW, R.string.pico, R.string._p));
        mDecimals.add(new Decimal(NEG + ON + FI, R.string.femto, R.string._f));
        mDecimals.add(new Decimal(NEG + ON + EX, R.string.atto, R.string._a));
    }

}