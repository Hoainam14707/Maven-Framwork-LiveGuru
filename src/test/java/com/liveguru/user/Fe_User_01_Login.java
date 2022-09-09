package com.liveguru.user;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Fe_User_01_Login extends BaseTest {
    private final String  email = "automationfc@@gmail.com";
    private final String password = "123123";

    @Test
    public void TC_01_Register_Success() {
        homePage.clickToAccountMenu();
        loginPage = homePage.clickToLoginLink("Log In");

        loginPage.inputDataToLoginField("email", email);
        loginPage.inputDataToLoginField("pass", password);

        myAccountPage = loginPage.clickToLoginButton();
        Assert.assertEquals(myAccountPage.getTextDashboardHeaderText(), "Hello, Automation FC!");
    }
}
