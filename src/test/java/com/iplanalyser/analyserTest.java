package com.iplanalyser;

import com.iplanalyser.model.RunClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class analyserTest {
    IPLAnalyser iplAnalyser;
    static final String IPL_2019_FACTSHEET_MOST_RUNS_CSV ="./src/test/resources/IPL2019FactsheetMostRuns.csv";


    @Before
    public void init(){
        iplAnalyser = new IPLAnalyser();
    }

    @Test
    public void testPasses_WhenReturnsCorrectCount(){
        List list = iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        Assert.assertEquals(100,list.size());
    }

    @Test
    public void testPasses_ForGettingTopAverageBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortData("avg");
        Assert.assertEquals("Tim Southee",object[0].player);
    }


}