package com.iplanalyser;

import com.iplanalyser.model.RunClass;
import com.iplanalyser.model.WicketsClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class analyserTest {
    IPLAnalyser iplAnalyser;
    static final String IPL_2019_FACTSHEET_MOST_RUNS_CSV ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    static final String IPL_2019_FACTSHEET_MOST_WKTS_CSV ="./src/test/resources/IPL2019FactsheetMostWkts.csv";

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
        RunClass[] object = iplAnalyser.sortRunCSV("avg");
        Assert.assertEquals("MS Dhoni",object[0].player);
    }


    @Test
    public void testPasses_ForGettingWorstAverageBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("avg");
        Assert.assertEquals("Alzarri Joseph",object[object.length-1].player);
    }

    @Test
    public void testPasses_ForGettingTopStrikeRateBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("sr");
        Assert.assertEquals("Ishant Sharma",object[0].player);
    }


    @Test
    public void testPasses_ForGettingWorstStrikeRateBatsman(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("sr");
        Assert.assertEquals("Bhuvneshwar Kumar",object[object.length-1].player);
    }

    @Test
    public void testPasses_ForGettingPlayerWith_Maximum4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("six","four");
        Assert.assertEquals("Andre Russell",object[0].player);
    }

    @Test
    public void testPasses_ForGettingPlayerWith_Minimum4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("six","four");
        Assert.assertEquals("Shakib Al Hasan",object[object.length-1].player);
    }

    @Test
    public void testPasses_ForGettingPlayer_WithBestStrikeAnd_Maximum4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("six","four","sr");
        Assert.assertEquals("Andre Russell",object[0].player);
    }

    @Test
    public void testPasses_ForGettingPlayer_WithWorstStrike_AndMinimum4sAnd6s(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("six","four","sr");
        Assert.assertEquals("Bhuvneshwar Kumar",object[object.length-1].player);
    }


    @Test
    public void testPasses_ForGettingPlayer_WithGreatStrikeRate_AndAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("avg","sr");
        Assert.assertEquals("David Warner",object[0].player);
    }

    @Test
    public void testPasses_ForGettingPlayer_WithLeastStrikeRate_AndAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("avg","sr");
        Assert.assertEquals("Bhuvneshwar Kumar",object[object.length-1].player);
    }


    @Test
    public void testPasses_ForGettingPlayer_WithBestRun_AndAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("avg","run");
        Assert.assertEquals("David Warner",object[0].player);
    }

    @Test
    public void testPasses_ForGettingPlayer_WithLeastRun_AndAverage(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_RUNS_CSV,"run");
        RunClass[] object = iplAnalyser.sortRunCSV("avg","run");
        Assert.assertEquals("Pawan Negi",object[object.length-1].player);
    }

    @Test
    public void testPasses_ForGetting_WorstBowlingAverages(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketsClass[] wicketObjectArray = iplAnalyser.sortWicket("avg");
        Assert.assertEquals("Ben Cutting",wicketObjectArray[0].player);

    }

    @Test
    public void testPasses_ForGetting_TopBowlingAverages(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV,"wicket");
        WicketsClass[] wicketObjectArray = iplAnalyser.sortWicket("avg");
        Assert.assertEquals("Anukul Roy",wicketObjectArray[wicketObjectArray.length-1].player);

    }

    @Test
    public void testPasses_ForGetting_BestBowlingStrikeRate() {
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV, "wicket");
        WicketsClass[] wicketObjectArray = iplAnalyser.sortWicket("sr");
        Assert.assertEquals("Mandeep Singh", wicketObjectArray[wicketObjectArray.length - 1].player);
    }

    @Test
    public void testPasses_ForGetting_WorstBowlingStrikeRate() {
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV, "wicket");
        WicketsClass[] wicketObjectArray = iplAnalyser.sortWicket("sr");
        Assert.assertEquals("Liam Livingstone", wicketObjectArray[0].player);
    }


    @Test
    public void testPasses_ForGetting_BestBowlersWithBestEconomy(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV, "wicket");
        WicketsClass[] wicketObjectArray = iplAnalyser.sortWicket("economy");
        Assert.assertEquals("Krishnappa Gowtham", wicketObjectArray[wicketObjectArray.length-1].player);

    }

    @Test
    public void testPasses_ForGetting_BowlersWithWorstEconomy(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV, "wicket");
        WicketsClass[] wicketObjectArray = iplAnalyser.sortWicket("economy");
        Assert.assertEquals("Liam Livingstone", wicketObjectArray[0].player);
    }

    @Test
    public void testPasses_ForGetting_BestStrikeRatesWith4wAnd5w(){
        iplAnalyser.getData(IPL_2019_FACTSHEET_MOST_WKTS_CSV, "wicket");
        WicketsClass[] wicketObjectArray = iplAnalyser.sortWicket("sr","5w","4w");
        Assert.assertEquals("Alzarri Joseph", wicketObjectArray[0].player);
    }

}



