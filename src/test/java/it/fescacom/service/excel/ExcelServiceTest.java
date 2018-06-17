package it.fescacom.service.excel;

import it.fescacom.ServiceTestAbstract;
import it.fescacom.domain.Match;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ExcelServiceTest extends ServiceTestAbstract {

    @Autowired
    ServiceCRUDExcel serviceCRUDExcel;
    private List<Match> playedMatches = new ArrayList<Match>();

    @Before
    public void setUp() {
        Match match = new Match("Francia", "Brasil", "2", "3");
        playedMatches.add(match);
        match = new Match("Serbia", "Danimarca", "2", "3");
        playedMatches.add(match);
        match = new Match("Costarica", "Giappone", "2", "3");
        playedMatches.add(match);
    }

    @Test
    public void testCreateExcel() {
        serviceCRUDExcel.createExcel(playedMatches);
        File file = new File("MatchesResults.xlsx");
        Assert.isTrue(file.exists(), "File has beeb created correctly");
        file.deleteOnExit();
    }
}