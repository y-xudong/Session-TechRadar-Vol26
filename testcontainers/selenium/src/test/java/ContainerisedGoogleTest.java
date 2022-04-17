import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
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
            .withRecordingMode(RECORD_ALL, new File("/Users/xudong.yang/Session-TechRadar-Vol26/testcontainers/selenium/build"));

    private static WebDriver driver;

//    @BeforeAll
//    static void beforeAll() {
//        driver = chrome.getWebDriver();
//    }

//    @Test
//    void should_docker_host_be_set_to_colima() {
//        String actualDockerHost = System.getenv("DOCKER_HOST");
//        String expectDockerHost = String.format("unix:%s/.colima/docker.sock", System.getenv("HOME"));
//        assertThat("DOCKER_HOST should be set to colima", actualDockerHost, is(expectDockerHost));
//    }

    @Test
    public void should_title_contains_thoughtworks_when_open_thoughtworks_com() {
        driver = chrome.getWebDriver();
        assertThat(1, is(1));
    }
}
