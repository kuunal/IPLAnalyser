package com.iplanalyser;


import com.google.gson.Gson;
import com.iplanalyser.dao.RunDAO;
import com.iplanalyser.dao.WicketsDAO;
import com.iplanalyser.enums.Type;
import com.iplanalyser.model.RunClass;
import com.iplanalyser.model.WicketsClass;
import com.sun.jdi.DoubleValue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IPLAnalyser {
    Class className,daoClass;
    HashMap<Class,List> hmap = new HashMap<>();

    public List getData(String filePath,String type){
        className = Type.valueOf(type.toUpperCase()).getKlass();
        daoClass=Type.valueOf(type.toUpperCase()).getDaoClass();
        hmap.put(daoClass,LoadData.loadData(filePath,className));
        return this.hmap.get(daoClass);
    }

    public RunClass[] sortRunCSV(String ...field)  {
        if(field.length>1) {
            for (int count = 0; count < hmap.get(daoClass).size(); count++) {
                Double total=0.0;
                for(int countField=0; countField< field.length;countField++){
                    RunDAO obj = (RunDAO) hmap.get(daoClass).get(count);
                    total+=obj.getValues(field[countField]);
                }
                ((RunDAO) hmap.get(daoClass).get(count)).setTotal(total);
            }
            return new Gson().fromJson(sortData.sort(hmap.get(daoClass),"total"),RunClass[].class);
        }
        return new Gson().fromJson(sortData.sort(hmap.get(daoClass),field[0]),RunClass[].class);
    }

    public WicketsClass[] sortWicket(String... field)  {
        if(field.length>1) {
            for (int count = 0; count < hmap.get(daoClass).size(); count++) {
                Double total=0.0;
                for(int countField=0; countField< field.length;countField++){
                    WicketsDAO obj = (WicketsDAO) hmap.get(daoClass).get(count);
                    total+=obj.getValues(field[countField]);
                }
                ((WicketsDAO) hmap.get(daoClass).get(count)).setTotal(total);
            }
            return new Gson().fromJson(sortData.sort(hmap.get(daoClass),"total"),WicketsClass[].class);
        }
        return new Gson().fromJson(sortData.sort(hmap.get(daoClass),field[0]),WicketsClass[].class);
    }

}