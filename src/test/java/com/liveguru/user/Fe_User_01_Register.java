package com.liveguru.user;

import common.BaseTest;
import common.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import pageObjects.UserHomePageObject;
import pageObjects.UserRegisterPageObject;

public class Fe_User_01_Register extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private String firstName = "automation";
    private String lastName = "FC";
    private String email = "automation" + getRandomNumber() + "@gmail.com";
    private String password = "123456";
    private String confirmPassword = password;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void beforeTest(String browserName, String url) {
        driver = openBrowser(browserName, url);
        homePage = PageGenerator.getHomePageObject(driver);
    }

    @Test
    public void TC_01_Register_Success() {
        homePage.clickToAccountMenu();
        registerPage = homePage.clickToRegisterLink();

        registerPage.inputDataToForm("firstname",firstName);
        registerPage.inputDataToForm("lastname",lastName);
        registerPage.inputDataToForm("email_address",email);
        registerPage.inputDataToForm("password",password);
        registerPage.inputDataToForm("confirmation",confirmPassword);

        registerPage.clickToRegisterButton();
        Assert.assertTrue(registerPage.verifyUserRegisterSuccess());

    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
    }
}
