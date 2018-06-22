package it.fescacom;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-service.xml")
public class ServiceTestAbstract {

    static {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\scanufe\\Downloads\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\scanufe\\Downloads\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "C:\\Users\\scanufe\\Downloads\\IEDriverServer.exe");


    }
}
