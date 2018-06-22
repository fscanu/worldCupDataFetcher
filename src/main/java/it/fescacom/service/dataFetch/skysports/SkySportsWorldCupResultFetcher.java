package it.fescacom.service.dataFetch.skysports;

import it.fescacom.domain.Match;
import it.fescacom.service.dataFetch.ServiceMatches;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static it.fescacom.service.dataFetch.skysports.SkySportsServiceConstants.*;

@Service
public class SkySportsWorldCupResultFetcher extends ServiceMatches {
    static Logger logger = Logger.getLogger(SkySportsWorldCupResultFetcher.class);

    @Autowired
    private final WebDriver driver;

    public SkySportsWorldCupResultFetcher(WebDriver driver) {
        this.driver = driver;
    }

    public List<Match> fetchMatchData() {
        logger.info("STARTING: fetchMatchData");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(SKYSPORT_RESULT_URL);
        List<WebElement> fixres__item = driver.findElements(By.className("fixres__item"));
        logger.info("  ENDING: fetchMatchData");
        return getMatches(fixres__item);
    }

    private List<Match> getMatches(List<WebElement> fixres__item) {
        List<Match> playedMatches = new ArrayList<Match>();
        for (WebElement element : fixres__item) {
            String elementText = element.getText();

            Match match = getMatch(elementText);
            playedMatches.add(match);

        }
        return playedMatches;
    }

    private Match getMatch(String elementText) {
        String[] strings = elementText.split("\\n");
        String opponentA = strings[0];
        String opponentB = strings[2].replace(FINAL_TIME_STRING, EMPTY_STRING);
        String goalScoredA = strings[1].substring(0, 1);
        String goalScoredB = strings[1].substring(2, 3);
        return new Match(opponentA, opponentB, goalScoredA, goalScoredB);
    }
}
