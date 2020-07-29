package com.infixus.metricinfo.model;

public class Tables {
    public int item;
    private String firstMetric, central, secondMetric;

    public Tables(int item) {
        this.item = item;
    }

    public Tables() {
    }

    public String getFirstMetric() {
        return firstMetric;
    }

    public void setFirstMetric(String firstMetric) {
        this.firstMetric = firstMetric;
    }

    public String getCentral() {
        return central;
    }

    public void setCentral(String central) {
        this.central = central;
    }

    public String getSecondMetric() {
        return secondMetric;
    }

    public void setSecondMetric(String secondMetric) {
        this.secondMetric = secondMetric;
    }
}