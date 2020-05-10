package com.iplanalyser;

import censusanalyser.opencsvbuilder.CSVBuilderFactory;
import censusanalyser.opencsvbuilder.ISortBuilder;
import com.iplanalyser.dao.RunDAO;

import java.util.Comparator;
import java.util.List;

public class sortData {
    public static String sort(List list, String field) {
        Comparator comparator = Comparator.comparing(mostRunObject -> {
            try {
                return (Comparable) mostRunObject.getClass().getDeclaredField(field).get(mostRunObject);
            } catch (NoSuchFieldException | IllegalAccessException e) {
            }
            return null;
        });
        return sortedData(comparator, list);
    }

    static String sortedData(Comparator comparator, List CSVList) {
        ISortBuilder iSortBuilder = CSVBuilderFactory.getSortBuilder();
        return iSortBuilder.sortData(comparator,CSVList);
    }
}
