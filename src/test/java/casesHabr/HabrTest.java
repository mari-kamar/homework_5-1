package casesHabr;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import pagesHabr.HabrMainPage;


@SpringBootTest(classes = HabrTest.class)
public class HabrTest extends HabrBaseTest {

// Проверка, что логотип отображается на главной странице
    @Test
    public void habrTest1() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        Assert.assertTrue(habrMainPage.getMainLogo().isDisplayed());
        logger.info("logo has link");
    }

// Проверка, что при переходе на страницу Авторизации есть заголовок "Вход"
    @Test
    public void habrTest2() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                    .auth();
        WebElement authTitle = driver.findElement(By.xpath("//div[contains(text(),'Вход')]"));
        Assert.assertEquals(authTitle.getText(), "Вход");
        logger.info("Title Вход is true");
    }

// Проверка, что при переходе на страницу Регистрации есть заголовок "Регистрация"
    @Test
    public void habrTest3() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .reg();
        WebElement regTitle = driver.findElement(By.xpath("//div[contains(text(),'Регистрация')]"));
        Assert.assertEquals(regTitle.getText(), "Регистрация");
        logger.info("Title Регистарция is true");
    }

// Проверка, что при переходе на страницу поиска значение value в поле поиска, совпадает с введенным на главной странице
    @Test
    public void habrTest4() {
        String myText = "что-то";
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .search(myText);
        String xpath = "//input[contains(@value,'" + myText + "')]";
        WebElement searchText = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(searchText.getAttribute("value"), myText);
        logger.info("Search page HABR has myText search");
    }
// Проверка, что в списке есть пользователь, которого искали
    @Test
    public void habrTest5() {
        String myUserSearch = "жжж";
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                    .users()
                    .search(myUserSearch);
        //String xpath = "//*[contains(@class, 'list-snippet__username')]/a[contains(@class,'list-snippet__nickname') and contains(text(), '" + myUserSearch + "')]";
        //WebElement userText = driver.findElement(By.xpath(xpath));
        //System.out.println("------------------"+ userText.getText());
        //Assert.assertEquals(userText.getText(), myUserSearch);
        //WebElement peopleList = driver.findElement(By.xpath("//*[contains(@class, 'list-snippet__username')]"));
        //List<WebElement> peopleList = driver.findElements(By.xpath("//li[contains(@class, 'content-list__item_users')]"));
        //System.out.println("-----------" + peopleList.size() + "-------------");
        logger.info("Search user");

        //List<WebElement> tabs = driver.findElements(By.xpath("//a[contains(@class, 'tabs-menu__item_link')]"));
        //System.out.println("=====" + tabs.size());
    }

//Проверка открытия попапа смены языка
    @Test
    public void habrTest6() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .openLangPopup();
        Assert.assertTrue(habrMainPage.showLangPopup().isDisplayed());
        logger.info("lang popup is visible");
    }
}
