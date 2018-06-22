package it.fescacom.service.integration;

import it.fescacom.ServiceTestAbstract;
import it.fescacom.domain.Match;
import it.fescacom.service.dataFetch.skysports.SkySportsWorldCupResultFetcher;
import it.fescacom.service.excel.ServiceCRUDExcel;
import java.io.File;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class TestIntegration extends ServiceTestAbstract {

    @Autowired
    SkySportsWorldCupResultFetcher skySportsWorldCupResultFetcher;

    @Autowired
    ServiceCRUDExcel serviceCRUDExcel;

    @Test
    public void testDataFetchService() {

        List<Match> playedMatches = skySportsWorldCupResultFetcher.fetchMatchData();
        Assert.notEmpty(playedMatches,
                        "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
        serviceCRUDExcel.createExcel(playedMatches);
        File file = new File("MatchesResults.xlsx");
        Assert.isTrue(file.exists(), "File has beeb created correctly");
    }
}
