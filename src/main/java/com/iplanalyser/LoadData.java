package com.iplanalyser;


import censusanalyser.opencsvbuilder.CSVBuilderFactory;
import censusanalyser.opencsvbuilder.ICSVBuilder;
import com.iplanalyser.dao.RunDAO;
import com.iplanalyser.dao.WicketsDAO;
import com.iplanalyser.model.RunClass;
import com.iplanalyser.model.WicketsClass;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

public class LoadData {
    public static <E> ArrayList loadData(String filePath, Class className) {
        try(Reader reader = Files.newBufferedReader(Paths.get(filePath));){
            ArrayList<Object> arr = new ArrayList<>();
            ICSVBuilder builder = CSVBuilderFactory.getBuilder();
            Iterator<E> censusCSVIterator = builder.getCSVFileIterator(reader,className);
            Iterable<E> censusIterable = ()-> censusCSVIterator;
            StreamSupport.stream(censusIterable.spliterator(),false)
                    .forEach(csvObject -> {
                        if(className.equals(RunClass.class))
                            arr.add(new RunDAO((RunClass) csvObject));
                        else
                            arr.add(new WicketsDAO((WicketsClass) csvObject));
                    });
            return arr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

