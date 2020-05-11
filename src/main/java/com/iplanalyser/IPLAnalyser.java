package com.iplanalyser;


import com.google.gson.Gson;
import com.iplanalyser.dao.RunDAO;
import com.iplanalyser.dao.WicketsDAO;
import com.iplanalyser.enums.Type;
import com.iplanalyser.model.RunClass;
import com.iplanalyser.model.WicketsClass;

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
            boolean generateStrikeRateFlag = checkStrikeRate(field);
            for (int count = 0; count < hmap.get(daoClass).size(); count++) {
                Double total=0.0;
                RunDAO obj = (RunDAO) hmap.get(daoClass).get(count);
                for(int countField=0; countField< field.length;countField++){
                    total+=obj.getValues(field[countField]);
                }
                if(generateStrikeRateFlag)
                    total=(total-obj.getValues("sr"))/obj.getValues("matches");
                ((RunDAO) hmap.get(daoClass).get(count)).setTotal(total);
            }
            return new Gson().fromJson(sortData.sort(hmap.get(daoClass),"total"),RunClass[].class);
        }
        return new Gson().fromJson(sortData.sort(hmap.get(daoClass),field[0]),RunClass[].class);
    }

    private boolean checkStrikeRate(String[] field) {
        for(String x : field){
            if(x.equals("sr")) {
                if (x.equals("avg"))
                   return true;
            }
        }return false;
    }


    public WicketsClass[] sortWicket(String... field)  {
            boolean generateStrikeRateFlag = checkStrikeRate(field);
            for (int count = 0; count < hmap.get(daoClass).size(); count++) {
                Double total=0.0;
                WicketsDAO obj = (WicketsDAO) hmap.get(daoClass).get(count);
                for(int countField=0; countField< field.length;countField++){
                    total+=obj.getValues(field[countField]);
                }
                if(!generateStrikeRateFlag)
                    total=(total-obj.getValues("sr"))/obj.getValues("over");
                ((WicketsDAO) hmap.get(daoClass).get(count)).setTotal(total);
            }
            return new Gson().fromJson(sortData.sort(hmap.get(daoClass),"total"),WicketsClass[].class);
    }

//    private WicketsClass[] pushZeroesToEnd(WicketsDAO[] arr, String field) {
//        int count=arr.length-1;
//        for(int fieldElements=arr.length-1;fieldElements>=0;fieldElements--){
//            if(arr[fieldElements].getValues(field)<0.1){
//                arr[count--]=arr[fieldElements];
//            }
//        }
//        while (count>0){
//            try {
//                arr[count].getClass().getField(field).set(arr[count],0.0);
//                count--;
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (NoSuchFieldException e) {
//                e.printStackTrace();
//            }
//        }
//        return new Gson().fromJson(arr.toString(),WicketsClass[].class);
//    }

}