import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

@Testcontainers
public class ContainerisedGoogleTest {

    @Container
    private static final BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(RECORD_ALL, new File("build"));

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = chrome.getWebDriver();
    }

//    @AfterAll
//    static void afterAll() {
//        driver.close();
//    }

//    @Test
//    void should_first_result_is_selenium_when_search_selenium() {
//        RemoteWebDriver driver = chrome.getWebDriver();
//        driver.get("https://google.com");
//        assertThat(1, is(1));
////        WebElement searchInput = driver.findElement(By.tagName("input"));
////        searchInput.sendKeys("selenium");
////        searchInput.sendKeys(Keys.ENTER);
////        WebElement firstResult = driver.findElement(By.tagName("h3"));
////        assertThat(firstResult.getText(), is("Selenium"));
////        driver.close();
//    }

    @Test
    @DisplayName("The testproject.io web site should have the correct title")
    void testProjectWebSiteShouldHaveCorrectTitle() {
        driver.get("https://www.testproject.io");
        assertThat(driver.getTitle(), is("TestProject - Community Powered Test Automation"));
    }
}
