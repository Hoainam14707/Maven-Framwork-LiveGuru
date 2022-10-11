package com.liveguru.product;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import data.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Fe_User_Add_Your_Review extends BaseTest {
    @Test
    public void TC_09_Verify_Can_Add_Your_Review(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_09_Verify_Can_Add_Your_Review");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Go To TV Menu");
        TVTabPage = homePage.clickToTVMenuTab();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click" + Product.TV_SAMSUNG_LCD + "product detail");
        productDetailPage = TVTabPage.clickToProductDetail(Product.TV_SAMSUNG_LCD);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click 'Add your review' link");
        productDetailPage.clickToAddYourReviewLink();

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Input Empty Data to 3 field: Thought/ Your Review/ Your Nickname");


        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click Submit Review");
        productDetailPage.clickSubmitReviewButton();
        Assert.assertTrue(productDetailPage.verifyErrorMessageThoughFieldDisplayed());
        Assert.assertTrue(productDetailPage.verifyErrorMessageSummaryFieldDisplayed());
        Assert.assertTrue(productDetailPage.verifyErrorMessageNicknameFieldDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Input Valid Data to 3 field: Thought/ Your Review/ Your Nickname");
        productDetailPage.selectRating();
        productDetailPage.inputDataToThoughtField("Good");
        productDetailPage.inputDataToSummaryField("Good");
        productDetailPage.inputDataToNicknameField("Kid");

        ExtentTestManager.getTest().log(Status.INFO, "Step 09: Click Submit Review");
        productDetailPage.clickSubmitReviewButton();
        Assert.assertTrue(productDetailPage.verifySuccessMessageDisplayed());
    }
}
