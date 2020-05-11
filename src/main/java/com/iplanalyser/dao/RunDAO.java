package com.iplanalyser.dao;

import com.iplanalyser.model.RunClass;

public class RunDAO {
    public Double avg;
    public String player;
    public Double sr;
    public Integer six;
    public Integer four;
    public Integer run;
    public Integer matches;
    public Double total=0.0;
    public RunDAO(RunClass obj){
        this.avg=obj.avg;
        this.player=obj.player;
        this.sr=obj.sr;
        this.four=obj.four;
        this.six=obj.six;
        this.run=obj.run;
        this.matches=obj.matches;
    }
    public RunDAO(){}

    public void setTotal (Double total){
        this.total+=total;
    }

    public Double getValues(String field){
        if(field.equals("six"))
            return Double.valueOf(this.six*6);
        else if(field.equals("four"))
            return Double.valueOf(this.four*4);
        else if(field.equals("sr"))
            return Double.valueOf(this.sr);
        return Double.valueOf(run);
    }

}
