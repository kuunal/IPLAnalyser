package com.iplanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class WicketsClass {

    @CsvBindByName(column = "Ov")
    public Double over;

    @CsvBindByName(column = "5w")
    public Integer fiveWickets;

    @CsvBindByName(column = "4w")
    public Integer fourWickets;

    @CsvBindByName(column = "Avg")
    public Double avg;

    @CsvBindByName(column = "PLAYER")
    public String player;

    @CsvBindByName(column = "SR")
    public Double sr;

    @CsvBindByName(column = "Econ")
    public Double economy;

}
