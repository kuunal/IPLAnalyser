package com.iplanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class RunClass {
    @CsvBindByName(column = "Avg")
    public Double avg;

    @CsvBindByName(column = "PLAYER")
    public String player;
}
