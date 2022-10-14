package com.liveguru.product;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import common.ExtentTestManager;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Fe_User_Search_Functionality extends BaseTest {

    @Test
    public void TC_11_Verify_Search_Functionality(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_07_Verify_Able_To_Compare_Two_Product");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Advanced Search in Footer");
        advancedSearchPage = homePage.clickToAdvancedSearch("Advanced Search");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input price field range 0 - 150 and Click Search");
        advancedSearchPage.inputPrice("price", "0");
        advancedSearchPage.inputPrice("price_to", "150");
        advancedSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Note the Price and Product Name in the result");
        advancedSearchPage.storageProductName();
        advancedSearchPage.storageProductPrice();

        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input price field range 151 - 1000 and Click Search");
        advancedSearchPage.clickToAdvancedSearch("Advanced Search");
        advancedSearchPage.inputPrice("price", "151");
        advancedSearchPage.inputPrice("price_to", "1000");
        advancedSearchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 06: Note the Price and Product Name in the result");
        advancedSearchPage.storageProductName();
        advancedSearchPage.storageProductPrice();
    }
}
