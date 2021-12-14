import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTests {

    static WebDriver driver;

    @BeforeAll
    static void warmuUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @BeforeEach
    void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @Test
    void shouldLoginProperly() {
        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.id("email")).sendKeys("maniek1@man.wp.pl");
        driver.findElement(By.id("passwd")).sendKeys("1234567");
        driver.findElement(By.id("SubmitLogin")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
        System.out.println("Poprawne logowanie.");

    }

    @Test
    void shouldNotLoginProperly() {
        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.id("email")).sendKeys("maniek1@man.wp.pl");
        driver.findElement(By.id("passwd")).sendKeys("wrongPass");
        driver.findElement(By.id("SubmitLogin")).click();
        Assertions.assertEquals("Authentication failed.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText());
        System.out.println("Niepoprawne logowanie. Bledne haslo.");
    }

    @Test
    void shouldNotLoginWithoutLoginValue() {
        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.id("passwd")).sendKeys("wrongPass");
        driver.findElement(By.id("SubmitLogin")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=authentication"));
        System.out.println("Niepoprawne logowanie. Brak adresu email.");
    }

    @Test
    void shouldNotLoginWithoutPassword() {
        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.id("email")).sendKeys("maniek1@man.wp.pl");
        driver.findElement(By.id("SubmitLogin")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=authentication"));
        System.out.println("Niepoprawne logowanie. Brak hasla.");

    }

    @AfterAll
    static void tearDown() {
        driver.close();
    }
}


