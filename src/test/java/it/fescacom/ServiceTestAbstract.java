package it.fescacom;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-service.xml")
public class ServiceTestAbstract {

    @Value("browser.driver.location")
    private String browserDriverLocation;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\scanufe\\Downloads\\geckodriver.exe");
    }
}
