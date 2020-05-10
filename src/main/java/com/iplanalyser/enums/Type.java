package com.iplanalyser.enums;


import com.iplanalyser.dao.RunDAO;
import com.iplanalyser.dao.WicketsDAO;
import com.iplanalyser.model.RunClass;
import com.iplanalyser.model.WicketsClass;

public enum Type {
    RUN(RunClass.class, RunDAO.class),
    WICKET(WicketsClass.class, WicketsDAO.class);

    private Class klass;
    private Class daoClass;

    Type(Class klass,Class DAOClass){
        this.klass=klass;
        this.daoClass =DAOClass;
    }

    public Class getKlass(){
        return this.klass;
    }

    public Class getDaoClass(){return this.daoClass;}

}
