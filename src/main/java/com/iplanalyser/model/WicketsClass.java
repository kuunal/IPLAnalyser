package com.iplanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class WicketsClass {

    @CsvBindByName(column = "Avg")
    public Double avg;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "SR")
    public Double sr;

}
