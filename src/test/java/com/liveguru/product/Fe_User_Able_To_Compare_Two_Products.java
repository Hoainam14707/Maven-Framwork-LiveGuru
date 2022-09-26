package com.liveguru.product;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Fe_User_Able_To_Compare_Two_Products extends BaseTest {
    private String productName01 = "Sony Xperia";
    private String productName02 = "IPhone";

    @Test
    public void TC_07_Verify_Able_To_Compare_Two_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_07_Verify_Able_To_Compare_Two_Product");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Mobile Tab");
        mobileTabPage = homePage.clickToMenuTab("Mobile");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on 'Add Two Compare' for 2 mobiles" + productName01 + "and" + productName02);
        mobileTabPage.clickAddToCompareLink(productName01);
        mobileTabPage.clickAddToCompareLink(productName02);

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click Compare button");
        mobileTabPage.clickCompareButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: verify Popup display with selected products in it");
        Assert.assertEquals(mobileTabPage.getTextPopUpWindowTitle(), "COMPARE PRODUCTS");
        Assert.assertTrue(mobileTabPage.getTextProductName(productName01, productName02));
    }
}
