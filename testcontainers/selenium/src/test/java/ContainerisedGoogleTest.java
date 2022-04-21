import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.VncRecordingContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

@Testcontainers
public class ContainerisedGoogleTest {

    @Container
    private final static BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
            .withCapabilities(new ChromeOptions())
            .withRecordingMode(RECORD_ALL, new File("build"), VncRecordingContainer.VncRecordingFormat.MP4);

    private static WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        driver = chrome.getWebDriver();
    }

    @AfterAll
    static void afterAll() {
        driver.close();
    }

    @Test
    public void should_title_be_correct_when_open_thoughtworks_com() {
        driver.get("https://www.thoughtworks.com");
        String websiteTitle = driver.getTitle();
        assertThat(websiteTitle, is("Thoughtworks: A global technology consultancy | Thoughtworks"));
    }
}
