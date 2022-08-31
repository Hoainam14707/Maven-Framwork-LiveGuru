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
        registerPage = homePage.clickToRegisterLink();

        registerPage.inputDataToForm("firstname",firstName);
        registerPage.inputDataToForm("lastname",lastName);
        registerPage.inputDataToForm("email_address",email);
        registerPage.inputDataToForm("password",password);
        registerPage.inputDataToForm("confirmation",confirmPassword);

        registerPage.clickToRegisterButton();
        Assert.assertTrue(registerPage.verifyUserRegisterSuccess());

    }
}
