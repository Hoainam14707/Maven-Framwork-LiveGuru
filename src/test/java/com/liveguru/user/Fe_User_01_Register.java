package com.liveguru.user;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Fe_User_01_Register extends BaseTest {
    private String firstName = "automation";
    private String lastName = "FC";
    private String email = "automation" + getRandomNumber() + "@gmail.com";
    private String password = "123456";
    private String confirmPassword = password;

    @Test (retryAnalyzer = common.Retry.class)
    public void TC_01_Register_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register Successfully");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Account Menu");
        homePage.clickToAccountMenu();

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click to Register Link");
        registerPage = homePage.clickToRegisterLink("Register");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input all valid data to form");
        registerPage.inputDataToForm("firstname", firstName);
        registerPage.inputDataToForm("lastname", lastName);
        registerPage.inputDataToForm("email_address", email);
        registerPage.inputDataToForm("password", password);
        registerPage.inputDataToForm("confirmation", confirmPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click 'Register' button ");
        myAccountPage = registerPage.clickToRegisterButton();
        Assert.assertFalse(registerPage.verifyUserRegisterSuccess());
    }

    @Test(dependsOnMethods = "TC_01_Register_Success")
    public void TC_02_User_Information() {
        ExtentTestManager.getTest().log(Status.INFO, "Open Account Information");
        myAccountPage.clickToLeftSideBar("Account Information");
        Assert.assertEquals(myAccountPage.getValueInForm("firstname", "value"), firstName);
        Assert.assertEquals(myAccountPage.getValueInForm("lastname", "value"), lastName);
        Assert.assertEquals(myAccountPage.getValueInForm("email", "value"), email);
    }
}
