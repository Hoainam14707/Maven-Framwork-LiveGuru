package com.liveguru.product;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import common.Retry;
import data.Product;
import data.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Fe_User_Share_Wishlist_To_Other_People_Using_Email extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    public void TC_08_Verify_Share_Wishlist_To_Other_People_By_Email(Method method) {
        System.out.println("Step 02: Login To System");
        ExtentTestManager.startTest(method.getName(), "TC_08_Verify_Share_Wishlist_To_Other_People_By_Email");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Login To System");
        homePage.clickToAccountMenu();
        loginPage = homePage.clickToLoginLink("Log In");
        loginPage.inputDataToLoginField("email", User.FE_USER);
        loginPage.inputDataToLoginField("pass", User.FE_PASSWORD);
        myAccountPage = loginPage.clickToLoginButton();

        System.out.println("Step 03: Go To TV Menu");
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Go To TV Menu");
        TVTabPage = myAccountPage.clickToTVMenuTab();

        System.out.println("Step 04: Add" + Product.TV_LG_LCD + "product in your wishlist");
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Add" + Product.TV_LG_LCD + "product in your wishlist");
        myAccountPage = TVTabPage.clickAddToWishListLink(Product.TV_LG_LCD);

        System.out.println("Step 05: Click 'Share wishlist button");
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click 'Share wishlist button");
        myAccountPage.clickShareToWishListButton();

        System.out.println("Step 06: Enter Email and a message then click Share wishlist");
        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Enter Email and a message then click Share wishlist");
        myAccountPage.inputDataToEmailTextbox("testmail@gmail.com");
        myAccountPage.inputDataToMessageTextbox("abc");
        myAccountPage.clickShareToWishListButton();
        Assert.assertTrue(myAccountPage.verifySharedSuccessfullyWithMessage());

        System.out.println("Step 07: Open 'My Wishlist Page");
        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Open 'My Wishlist Page");
        myAccountPage.verifyProductInMyWishList(Product.TV_LG_LCD);
    }
}
