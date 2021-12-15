import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class SearchingForItemsTests extends BaseClassTests{


    @Test
    void shouldSearchForTheItemCorrectly() {

        driver.findElement(By.id("search_query_top")).sendKeys("T-SHIRTS");
        driver.findElement(By.name("submit_search")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=T-SHIRTS&submit_search="));
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Dressy");
        driver.findElement(By.name("submit_search")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=Dressy&submit_search="));
    }

    @Test
    void shouldNotLookForAnItemThatIsNotInTheStore() {

        driver.findElement(By.id("search_query_top")).sendKeys("women's pants");
        driver.findElement(By.name("submit_search")).click();
        Assertions.assertEquals("No results were found for your search \"women's pants\"", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText());
    }

}


