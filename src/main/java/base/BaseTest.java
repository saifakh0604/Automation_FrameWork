package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browserName")
    @BeforeClass
    public void setUp(String browserName) {
        System.out.println("Launching browser: " + browserName);

        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().deleteAllCookies();
    }

    @Parameters("url")
    @BeforeMethod
    public void openApplication(String url) {
        System.out.println("Navigating to: " + url);
        driver.get(url);
    }

    @AfterMethod
    public void cleanUp() {
        System.out.println("Cleaning up after test...");
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Closing browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}
