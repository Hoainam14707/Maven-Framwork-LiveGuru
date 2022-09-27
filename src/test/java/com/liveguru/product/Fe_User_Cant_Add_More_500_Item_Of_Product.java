package com.liveguru.product;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import data.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Fe_User_Cant_Add_More_500_Item_Of_Product extends BaseTest {

    @Test
    public void TC_06_Verify_Can_Add_More_500_Item_Of_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_06_Verify_Can_Add_More_500_Item_Of_Product");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Mobile Tab");
        mobileTabPage = homePage.clickToMobileMenuTab();

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click Add To Cart button");
        shoppingCartPage = mobileTabPage.clickAddToCartButton(Product.MOBILE_SONY);

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Change 'QTY' and Click Update button");
        shoppingCartPage.changeQTYValue("501");
        shoppingCartPage.clickToUpdateButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify error Msg");
        Assert.assertTrue(shoppingCartPage.errorMsgIsDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Click 'Empty Cart' Link");
        shoppingCartPage.clickToFooterLink("Empty Cart");

        ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify Cart Is empty");
        Assert.assertTrue(shoppingCartPage.verifyMsgCartEmpty());



    }
}
