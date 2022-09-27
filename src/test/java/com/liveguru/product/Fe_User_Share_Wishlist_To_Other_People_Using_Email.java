package com.liveguru.product;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import data.Product;
import data.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Fe_User_Share_Wishlist_To_Other_People_Using_Email extends BaseTest {
    @Test
    public void TC_08_Verify_Share_Wishlist_To_Other_People_By_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_08_Verify_Share_Wishlist_To_Other_People_By_Email");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Login To System");
        homePage.clickToAccountMenu();
        loginPage = homePage.clickToLoginLink("Log In");
        loginPage.inputDataToLoginField("email", User.email);
        loginPage.inputDataToLoginField("pass", User.password);
        myAccountPage = loginPage.clickToLoginButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Go To TV Menu");
        TVTabPage = myAccountPage.clickToTVMenuTab();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Add" + Product.TV_LG_LCD + "product in your wishlist");
        myAccountPage = TVTabPage.clickAddToWishListLink(Product.TV_LG_LCD);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click 'Share wishlist button");
        myAccountPage.clickShareToWishListButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Enter Email and a message then click Share wishlist");
        myAccountPage.inputDataToEmailTextbox("testmail@gmail.com");
        myAccountPage.inputDataToMessageTextbox("abc");
        myAccountPage.clickShareToWishListButton();
        Assert.assertTrue(myAccountPage.verifySharedSuccessfullyWithMessage());

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Open 'My Wishlist Page");
        myAccountPage.verifyProductInMyWishList(Product.TV_LG_LCD);
    }
}
