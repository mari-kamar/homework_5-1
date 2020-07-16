package pagesHabr;

import casesHabr.HabrBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class HabrBasePage {
    WebDriver driver;
    public static Logger logger = LogManager.getLogger(HabrBaseTest.class);

    HabrBasePage(WebDriver driver) {
        this.driver = driver;
    }
}
