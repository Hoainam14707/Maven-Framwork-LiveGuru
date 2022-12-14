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
import pageObjects.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected UserHomePageObject homePage;
    protected UserRegisterPageObject registerPage;
    protected UserMyAccountPageObject myAccountPage;
    protected UserLoginPageObject loginPage;
    protected UserMobileTabPage mobileTabPage;
    protected UserProductDetailPage productDetailPage;
    protected UserShoppingCartPageObject shoppingCartPage;
    protected UserTVTabPage TVTabPage;
    protected CatalogAdvancedSearchPage advancedSearchPage;
    protected BEHomePageObject beHomePage;
    protected BELoginPageObject beLoginPage;

    public WebDriver getDriver() {
        return this.driver;
    }


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

    public UserHomePageObject goToFEHomePage() {
        driver.get(GlobalConstant.URL_FE);
        return new UserHomePageObject(driver);
    }

    public BELoginPageObject goToBELoginPage() {
        driver.get(GlobalConstant.URL_BE);
        return new BELoginPageObject(driver);
    }
}
