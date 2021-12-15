import navigation.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddingToCartTests extends BaseClassTests {
    MainPage mainPage = new MainPage(driver);

    @Test
    void shouldAddProductsToTheCart() {

        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")).click();
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText());

    }

    @AfterEach
    void clearCookies() {
        driver.manage().deleteAllCookies();
    }


    @Test
    void shouldNotContainTheQuantityWithoutAddingTheProduct() {

        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
        Assertions.assertEquals("Your shopping cart is empty.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText());

    }

    @Test
    void shouldAddAndRemoveAProductFromTheCart() {

        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")).click();
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText());
        driver.findElement(By.className("icon-trash")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order"));
    }

}



