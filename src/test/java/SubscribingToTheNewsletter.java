import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SubscribingToTheNewsletter {

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
    void shouldSubscribeToTheNewsletterCorrectly() {
        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(1000) + "@gamil.com";
        driver.get("http://automationpractice.com/");
        driver.findElement(By.id("newsletter-input")).click();
        driver.findElement(By.id("newsletter-input")).sendKeys(uniqueEmail);
        driver.findElement(By.name("submitNewsletter")).click();
        Assertions.assertEquals("Newsletter : You have successfully subscribed to this newsletter.", driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText());

    }

    @Test
    void shouldNotSubscribeToTheNewsletterByProvidingAnEmailAddressAlreadyRegistered() {

        driver.get("http://automationpractice.com/");
        driver.findElement(By.id("newsletter-input")).click();
        driver.findElement(By.id("newsletter-input")).sendKeys("maniek1@wp.pl");
        driver.findElement(By.name("submitNewsletter")).click();
        Assertions.assertEquals("Newsletter : This email address is already registered.", driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText());

    }

    @Test
    void shouldNotSubscribeToTheNewsletterWithoutProvidingAnEmailAddress() {

        driver.get("http://automationpractice.com/");
        driver.findElement(By.name("submitNewsletter")).click();
        Assertions.assertEquals("Newsletter : Invalid email address.", driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText());
    }

    @AfterAll
    static void tearDown() {
        driver.close();
    }
}
