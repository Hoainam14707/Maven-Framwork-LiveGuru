package com.liveguru.user;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Fe_User_01_Login extends BaseTest {
    private final String email = "automationfc@gmail.com";
    private final String password = "123123";

    @Test
    public void TC_01_Register_Success() {
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Account Menu");
        homePage.clickToAccountMenu();

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click to Login Link");
        loginPage = homePage.clickToLoginLink("Log In");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input all valid data to form");
        loginPage.inputDataToLoginField("email", email);
        loginPage.inputDataToLoginField("pass", password);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click Login button");
        myAccountPage = loginPage.clickToLoginButton();
        Assert.assertEquals(myAccountPage.getTextDashboardHeaderText(), "Hello, Automation FC!");
    }
}
