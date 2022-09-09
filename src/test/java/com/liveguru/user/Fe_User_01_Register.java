package com.liveguru.user;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Fe_User_01_Register extends BaseTest {
    private String firstName = "automation";
    private String lastName = "FC";
    private String email = "automation" + getRandomNumber() + "@gmail.com";
    private String password = "123456";
    private String confirmPassword = password;

    @Test
    public void TC_01_Register_Success() {
        homePage.clickToAccountMenu();
        registerPage = homePage.clickToRegisterLink("Register");

        registerPage.inputDataToForm("firstname", firstName);
        registerPage.inputDataToForm("lastname", lastName);
        registerPage.inputDataToForm("email_address", email);
        registerPage.inputDataToForm("password", password);
        registerPage.inputDataToForm("confirmation", confirmPassword);

        myAccountPage = registerPage.clickToRegisterButton();
        Assert.assertTrue(registerPage.verifyUserRegisterSuccess());
    }

    @Test(dependsOnMethods = "TC_01_Register_Success")
    public void TC_02_User_Information() {
        myAccountPage.clickToLeftSideBar("Account Information");
        Assert.assertEquals(myAccountPage.getValueInForm("firstname", "value"), firstName);
        Assert.assertEquals(myAccountPage.getValueInForm("lastname", "value"), lastName);
        Assert.assertEquals(myAccountPage.getValueInForm("email", "value"), email);
    }
}
