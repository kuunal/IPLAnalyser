package com.iplanalyser;


import censusanalyser.opencsvbuilder.CSVBuilderFactory;
import censusanalyser.opencsvbuilder.ICSVBuilder;
import com.iplanalyser.dao.RunDAO;
import com.iplanalyser.model.RunClass;

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
                    .forEach(csvCensus -> arr.add(new RunDAO((RunClass) csvCensus)));
            return arr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

