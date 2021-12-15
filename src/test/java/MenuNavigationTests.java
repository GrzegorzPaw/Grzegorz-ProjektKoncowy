import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuNavigationTests extends BaseClassTests {


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

        driver.findElement(By.id("contact-link")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=contact"));
    }

    @Test
    void shouldFindTheNewsletterTextField() {

        List<WebElement> newsletter = driver.findElements(By.id("newsletter-input"));
        Assertions.assertEquals(1, newsletter.size());
    }

    @Test
    void shouldGoFromTheLoginPageToTheHomePage() {

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=authentication&back=my-account"));
        driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a/i")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("index.php"));
    }

    @Test
    void shouldFindTheFollowingFieldsOnTheLoginPageWomenDressesTshirtsReturnToHomeEmailAddressCreateAnAccoundEmailAddressPasswordForgotYourPasswordSignIn() {

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

}



