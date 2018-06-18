package it.fescacom.service.dataFetch;

import it.fescacom.ServiceTestAbstract;
import it.fescacom.domain.Match;
import it.fescacom.service.dataFetch.skysports.SkySportsWorldCupResultFetcher;
import it.fescacom.service.excel.ServiceCRUDExcel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import java.util.List;

public class TestFetcherTest extends ServiceTestAbstract {

    @Autowired
    SkySportsWorldCupResultFetcher skySportsWorldCupResultFetcher;

    private static void printMatches(List<Match> playedMatches) {
        for (Match match :
                playedMatches) {
            System.out.println(match);
        }
    }

    @Test
    public void testDataFetchService() {

        List<Match> playedMatches = skySportsWorldCupResultFetcher.fetchMatchData();
        printMatches(playedMatches);
        Assert.notEmpty(playedMatches, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

}