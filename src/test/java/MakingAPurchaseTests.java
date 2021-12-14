import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MakingAPurchaseTests {

    static WebDriver driver;

    @BeforeAll
    static void warmuUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @Test
    void shouldMakeThePurchaseByBankTransfer() {

        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")).click();
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText());
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
        driver.findElement(By.id("email")).sendKeys("maniek1@man.wp.pl");
        driver.findElement(By.id("passwd")).sendKeys("1234567");
        driver.findElement(By.id("SubmitLogin")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&step=1&multi-shipping=0"));
        driver.findElement(By.cssSelector("#center_column > form > p > button > span")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order"));
        driver.findElement(By.cssSelector("#form > p > button > span")).click();
        driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a")).click();
        driver.findElement(By.id("uniform-cgv")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&multi-shipping="));
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
        Assertions.assertEquals("Your order on My Store is complete.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText());


    }

    @Test
    void shouldMakeThePurchaseByCheck() {

        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")).click();
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText());
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
        driver.findElement(By.id("email")).sendKeys("maniek1@man.wp.pl");
        driver.findElement(By.id("passwd")).sendKeys("1234567");
        driver.findElement(By.id("SubmitLogin")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&step=1&multi-shipping=0"));
        driver.findElement(By.cssSelector("#center_column > form > p > button > span")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order"));
        driver.findElement(By.cssSelector("#form > p > button > span")).click();
        driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a")).click();
        driver.findElement(By.id("uniform-cgv")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&multi-shipping="));
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
        Assertions.assertEquals("Your order on My Store is complete.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText());


    }

    @AfterAll
    static void tearDown() {
        driver.close();
    }

}
