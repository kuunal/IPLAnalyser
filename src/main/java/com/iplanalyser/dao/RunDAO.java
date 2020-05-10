package com.iplanalyser.dao;

import com.iplanalyser.model.RunClass;

public class RunDAO {
    public Double avg;
    public String player;
    public Double sr;
    public Double total=0.0;
    public RunDAO(RunClass obj){
        this.avg=obj.avg;
        this.player=obj.player;
        this.sr=obj.sr;
    }

    public RunDAO(Double total){
        this.total+=total;
    }

}
