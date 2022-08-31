package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.UserHomePageObject;
import pageObjects.UserRegisterPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected UserHomePageObject homePage;
    protected UserRegisterPageObject registerPage;


    @Parameters({"browser", "url"})
    @BeforeTest
    public void beforeTest(String browserName, String url) {
        driver = openBrowser(browserName, url);
        homePage = PageGenerator.getHomePageObject(driver);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
    }

    protected WebDriver openBrowser(String browserName, String url) {
        if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("H_FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("H_Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.setHeadless(true);
            driver = new ChromeDriver(option);
        } else {
            throw new RuntimeException("Please check browser");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }
}
