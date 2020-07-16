package pagesHabr;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class HabrUsersPage extends HabrBasePage {
    private By searchUserField = By.xpath("//*[@id=\"people_suggest\"]");

    public HabrUsersPage(WebDriver driver) {
        super(driver);
    }

    public HabrUsersPage search(String myUserSearch) {
        driver.findElement(searchUserField).sendKeys(myUserSearch);
        //driver.findElement(searchUserField).sendKeys(Keys.ENTER);
        logger.info("Search page HABR is open");
        return this;
    }
}
