import navigation.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutTest extends BaseClassTests {
    MainPage mainPage = new MainPage(driver);

    @Test
    void shouldLogOutCorrectly() {

        mainPage.clickSignInButton();
        driver.findElement(By.id("email")).sendKeys("maniek1@man.wp.pl");
        driver.findElement(By.id("passwd")).sendKeys("1234567");
        driver.findElement(By.id("SubmitLogin")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
        driver.findElement(By.className("logout")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=authentication&back=my-account"));
    }

}
