import navigation.LoginPage;
import navigation.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTests extends BaseClassTests {

    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    private static final String EXISTING_USERNAME_LOGIN = "maniek1@man.wp.pl";
    private static final String EXISTING_USERNAME_PASSWORD = "1234567";
    private static final String NOT_EXISTING_USERNAME_LOGIN = "";
    private static final String NOT_EXISTING_USERNAME_PASSWORD = "";


    @Test
    void shouldLoginProperly() {
        mainPage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertTrue(isOnMyAccountPage());
    }

    @Test
    void shouldNotLoginProperly() {
        mainPage.clickSignInButton();
        loginPage.login(NOT_EXISTING_USERNAME_LOGIN, NOT_EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(isOnMyAccountPage());

    }

    private boolean isOnMyAccountPage() {
        return driver.getCurrentUrl().contains("controller=my-account");
    }

    @Test
    void shouldNotLoginWithoutLoginValue() {
        mainPage.clickSignInButton();
        loginPage.login(NOT_EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(isOnMyAccountPage());

    }

    @Test
    void shouldNotLoginWithoutPassword() {
        mainPage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, NOT_EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(isOnMyAccountPage());

    }
}





