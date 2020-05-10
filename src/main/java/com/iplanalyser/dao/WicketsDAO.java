package com.iplanalyser.dao;

import com.iplanalyser.model.WicketsClass;

public class WicketsDAO {

    public String player;
    public Double avg;
    public Double sr;
    public Double total=0.0;

    public WicketsDAO(WicketsClass object){
        this.avg=object.avg;
        this.player=object.player;
        this.sr=object.sr;
    }

    public Double getValues(String field) {
        if(field.toLowerCase().equals(avg))
            return this.avg;
        return null;
    }

    public void setTotal (Double total){
        this.total+=total;
    }
}
