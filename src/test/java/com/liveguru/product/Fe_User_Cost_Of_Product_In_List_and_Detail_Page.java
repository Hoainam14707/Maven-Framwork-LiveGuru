package com.liveguru.product;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import data.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Fe_User_Cost_Of_Product_In_List_and_Detail_Page extends BaseTest {

    @Test
    public void TC_04_Verify_Cost_Of_Product_In_List_Page_And_Detail_Page_Are_Equal(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_04_Verify_Cost_Of_Product_In_List_Page_And_Detail_Page_Are_Equal");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Mobile Tab");
        mobileTabPage = homePage.clickToMobileMenuTab();

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Get cost of" + Product.MOBILE_SONY + "in list of all mobile");
        String productCost_01 = mobileTabPage.getCostProductMobile(Product.MOBILE_SONY);

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click on" + Product.MOBILE_SONY + "detail");
        productDetailPage = mobileTabPage.clickToProductDetail(Product.MOBILE_SONY);

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Get cost of" + Product.MOBILE_SONY + "in detail page");
        String productCostDetail = productDetailPage.getProductCostInDetailPage(Product.MOBILE_SONY);

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Compare Step 03 and 05");
        Assert.assertEquals(productCost_01, productCostDetail);

    }
}
