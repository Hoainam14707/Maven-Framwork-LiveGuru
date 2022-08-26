package com.liveguru.user;

import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class User_01_Register extends BaseTest {
    WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void beforeTest(String browserName, String url) {
        driver = openBrowser(browserName, url);
    }

    @Test
    public void f() {
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
    }

}
