package com.liveguru.user;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import data.User;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Be_User_Check_Account extends BaseTest {
    private String firstName = "automation";
    private String lastName = "FC";
    private String email = "automation" + getRandomNumber() + "@gmail.com";
    private String password = "123456";
    private String confirmPassword = password;

    @Test
    public void TC_01_Checking_Account_In_Backend(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_01_Checking_Account_In_Backend");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Go To FE and Create account");
        homePage = goToFEHomePage();
        homePage.clickToAccountMenu();
        registerPage = homePage.clickToRegisterLink("Register");
        registerPage.inputDataToForm("firstname", firstName);
        registerPage.inputDataToForm("lastname", lastName);
        registerPage.inputDataToForm("email_address", email);
        registerPage.inputDataToForm("password", password);
        registerPage.inputDataToForm("confirmation", confirmPassword);
        myAccountPage = registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Go To BE and Check account create exists");
        beLoginPage = goToBELoginPage();
        beLoginPage.inputDataToForm("username", User.BE_USER);
        beLoginPage.inputDataToForm("login", User.BE_PASSWORD);
        beHomePage = beLoginPage.clickToLoginButton();
        beHomePage.handlePopup();

        beHomePage.inputDataToTextbox("Email", "2", email);
    }
}
