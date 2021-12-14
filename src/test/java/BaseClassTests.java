import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClassTests {

    public static WebDriver driver;

    @BeforeAll
    public static void warmuUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @BeforeEach
    void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }
}
