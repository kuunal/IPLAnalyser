package com.iplanalyser;


import com.google.gson.Gson;
import com.iplanalyser.dao.RunDAO;
import com.iplanalyser.enums.Type;
import com.iplanalyser.model.RunClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IPLAnalyser {
    Class className;
    HashMap<Class,List> hmap = new HashMap<>();

    public List getData(String filePath,String type){
        className = Type.valueOf(type.toUpperCase()).getKlass();
        hmap.put(className,LoadData.loadData(filePath,className));
        return this.hmap.get(className);
    }

    public RunClass[] sortData(String ...field){
        if(field.length>1)
        for(String x : field){
            try {
                new RunDAO((Double) hmap.get(className).getClass().getDeclaredField(x).get(className));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
                return new Gson().fromJson(sortData.sort(hmap.get(className),"total"),RunClass[].class);
            }
        }
        return new Gson().fromJson(sortData.sort(hmap.get(className),field[0]),RunClass[].class);
    }
}