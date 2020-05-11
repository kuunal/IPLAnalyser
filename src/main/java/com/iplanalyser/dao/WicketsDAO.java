package com.iplanalyser.dao;

import com.iplanalyser.model.WicketsClass;

public class WicketsDAO {

    public String player;
    public Double avg;
    public Double sr;
    public Double economy;
    public Integer fiveWickets;
    public Integer fourWickets;
    public Double over;
    public Double total;

    public WicketsDAO(WicketsClass object){
        this.avg=object.avg;
        this.over=object.over;
        this.player=object.player;
        this.sr=object.sr;
        this.economy =object.economy;
        this.fiveWickets=object.fiveWickets;
        this.fourWickets=object.fourWickets;
    }

    public Double getValues(String field) {
        if(field.toLowerCase().equals("avg"))
            return this.avg;
        if(field.toLowerCase().equals("sr"))
            return this.sr;
        if(field.toLowerCase().equals("economy"))
            return this.economy;
        if(field.toLowerCase().trim().equals("fivewickets")||field.toLowerCase().trim().equals("5w"))
            return Double.valueOf(this.fiveWickets*5);
        if(field.toLowerCase().trim().equals("fourwickets")||field.toLowerCase().trim().equals("4w"))
            return Double.valueOf(this.fourWickets*4);
        if(field.equals("over"))
            return this.over*6;
        return null;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public void setSr(Double sr) {
        this.sr = sr;
    }

    public void setEconomy(Double economy) {
        this.economy = economy;
    }

    public void setFiveWickets(Integer fiveWickets) {
        this.fiveWickets = fiveWickets;
    }

    public void setFourWickets(Integer fourWickets) {
        this.fourWickets = fourWickets;
    }

    public void setOver(Double over) {
        this.over = over;
    }

    public void setTotal (Double total){
        if(total==(Double) 0.0)
            this.total=1000.0;
        this.total=total;
    }
}
