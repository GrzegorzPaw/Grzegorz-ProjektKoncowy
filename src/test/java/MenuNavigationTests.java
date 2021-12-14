import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MenuNavigationTests {
    static WebDriver driver;

    @BeforeAll
    static void warmuUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void shouldFindLoginAndSearchBoxOnTheHomePageAndTheLoginPage() {

        driver.navigate().to("http://automationpractice.com/");
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).isDisplayed());
        driver.findElement(By.name("submit_search")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=&submit_search="));
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).isDisplayed());
        driver.findElement(By.name("submit_search")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=&submit_search="));

    }


    @Test
    void shouldGoToTheContactPage() {

        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.id("contact-link")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=contact"));
    }

    @Test
    void shouldFindTheNewsletterTextField() {

        driver.navigate().to("http://automationpractice.com/");
        List<WebElement> newsletter = driver.findElements(By.id("newsletter-input"));
        Assertions.assertEquals(1, newsletter.size());
    }

    @Test
    void shouldGoFromTheLoginPageToTheHomePage() {

        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=authentication&back=my-account"));
        driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a/i")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("index.php"));
    }

    @Test
    void shouldFindTheFollowingFieldsOnTheLoginPageWomenDressesTshirtsReturnToHomeEmailAddressCreateAnAccoundEmailAddressPasswordForgotYourPasswordSignIn() {

        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.id("email_create")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.id("email")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.id("passwd")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/p[1]/a")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).isDisplayed());
    }

    @AfterAll
    static void tearDown() {
        driver.close();
    }
}



