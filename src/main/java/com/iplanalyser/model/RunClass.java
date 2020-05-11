package com.iplanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class RunClass {
    @CsvBindByName(column = "Avg")
    public Double avg;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "SR")
    public Double sr;

    @CsvBindByName(column = "6s")
    public Integer six;

    @CsvBindByName(column = "4s")
    public Integer four;

    @CsvBindByName(column = "Runs")
    public Integer run;

    @CsvBindByName(column = "Mat")
    public Integer matches;
}
