package it.fescacom;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-service.xml")
public class ServiceTestAbstract {
    static {
        System.setProperty("webdriver.gecko.driver", "D:\\00-Work\\04-Tools\\BrowserDrivers\\geckodriver.exe");
    }
}
