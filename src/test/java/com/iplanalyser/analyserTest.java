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
        Assert.assertEquals("MS Dhoni",object[0].player);
    }


    @Test
    public void testPasses_ForGettingWorstAverageBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortData("avg");
        Assert.assertEquals("Alzarri Joseph",object[object.length-1].player);
    }

    @Test
    public void testPasses_ForGettingTopStrikeRateBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortData("sr");
        Assert.assertEquals("Ishant Sharma",object[0].player);
    }


    @Test
    public void testPasses_ForGettingWorstStrikeRateBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortData("sr");
        Assert.assertEquals("Bhuvneshwar Kumar",object[object.length-1].player);
    }

    @Test
    public void testPasses_ForGettingPlayerWith_Maximum4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortData("six","four");
        Assert.assertEquals("Andre Russell",object[0].player);
    }

    @Test
    public void testPasses_ForGettingPlayerWith_Minimum4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortData("six","four");
        Assert.assertEquals("Shakib Al Hasan",object[object.length-1].player);
    }

    @Test
    public void testPasses_ForGettingPlayer_WithBestStrikeAnd_Maximum4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortData("six","four","sr");
        Assert.assertEquals("Ishant Sharma",object[0].player);
    }

    @Test
    public void testPasses_ForGettingPlayer_WithWorstStrike_AndMinimum4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortData("six","four","sr");
        Assert.assertEquals("Bhuvneshwar Kumar",object[object.length-1].player);
    }


    @Test
    public void testPasses_ForGettingPlayer_WithGreatStrikeRate_AndAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortData("avg","sr");
        Assert.assertEquals("Ishant Sharma",object[0].player);
    }

    @Test
    public void testPasses_ForGettingPlayer_WithLeastStrikeRate_AndAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortData("avg","sr");
        Assert.assertEquals("Bhuvneshwar Kumar",object[object.length-1].player);
    }



}