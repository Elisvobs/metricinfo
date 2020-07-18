package com.infixustech.metricinfo.model;

public class Decimal {
    public String unit;
    public int prefix, symbol;

    public Decimal(String unit, int prefix, int symbol) {
        this.unit = unit;
        this.prefix = prefix;
        this.symbol = symbol;
    }

}