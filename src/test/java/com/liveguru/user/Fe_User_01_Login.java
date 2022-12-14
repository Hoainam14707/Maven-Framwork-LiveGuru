package com.liveguru.user;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import data.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Fe_User_01_Login extends BaseTest {

    @Test
    public void TC_01_Register_Success(Method method) {
        ExtentTestManager.startTest(method.getName(),"TC_01_Register_Success");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Account Menu");
        homePage.clickToAccountMenu();

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click to Login Link");
        loginPage = homePage.clickToLoginLink("Log In");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input all valid data to form");
        loginPage.inputDataToLoginField("email", User.FE_USER);
        loginPage.inputDataToLoginField("pass", User.FE_PASSWORD);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click Login button");
        myAccountPage = loginPage.clickToLoginButton();
        Assert.assertEquals(myAccountPage.getTextDashboardHeaderText(), "Hello, Automation FC!");
    }
}
