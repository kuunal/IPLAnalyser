package com.iplanalyser.dao;

import com.iplanalyser.model.RunClass;

public class RunDAO {
    public Double avg;
    public String player;
    public Double sr;
    public Integer six;
    public Integer four;
    public Double total=0.0;
    public RunDAO(RunClass obj){
        this.avg=obj.avg;
        this.player=obj.player;
        this.sr=obj.sr;
        this.four=obj.four;
        this.six=obj.six;
    }
    public RunDAO(){}

    public void setTotal (Double total){
        this.total+=total;
    }

    public Double getValues(String field){
        if(field.equals("six"))
            return Double.valueOf(this.six);
//        else if(field.equals(four))
            return Double.valueOf(this.four);

    }

}
