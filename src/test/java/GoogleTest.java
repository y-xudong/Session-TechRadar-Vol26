import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        Path chromeDriverPath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "chromedriver");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath.toString());
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

    @Test
    void should_first_result_is_selenium_when_search_selenium() {
        driver.get("https://google.com");
        WebElement searchInput = driver.findElement(By.tagName("input"));
        searchInput.sendKeys("selenium");
        searchInput.sendKeys(Keys.ENTER);
        WebElement firstResult = driver.findElement(By.tagName("h3"));
        assertThat(firstResult.getText(), is("Selenium"));
    }
}
