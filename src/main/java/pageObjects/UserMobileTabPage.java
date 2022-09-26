package pageObjects;

import common.BasePage;
import common.PageGenerator;
import interfaces.UserMobileTabUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserMobileTabPage extends BasePage {
    WebDriver driver;

    public UserMobileTabPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getCostProductMobile(String productName) {
        waitForElementVisible(String.format(UserMobileTabUI.PRODUCT_COST, productName));
        return getTextElement(String.format(UserMobileTabUI.PRODUCT_COST, productName));
    }

    public UserProductDetailPage clickToProductDetail(String productName) {
        waitForElementClickable(String.format(UserMobileTabUI.PRODUCT_NAME, productName));
        clickToElement(String.format(UserMobileTabUI.PRODUCT_NAME, productName));
        return PageGenerator.getProductDetailPage(driver);
    }

    public UserShoppingCartPageObject clickAddToCartButton(String productName) {
        clickToElement(String.format(UserMobileTabUI.ADD_TO_CART_BUTTON, productName));
        return PageGenerator.getShoppingCartPage(driver);
    }

    public void clickAddToCompareLink(String productName) {
        waitForElementClickable(String.format(UserMobileTabUI.ADD_TO_COMPARE_LINK, productName));
        clickToElement(String.format(UserMobileTabUI.ADD_TO_COMPARE_LINK, productName));
        sleepInSecond(2);
    }

    public void clickCompareButton() {
        waitForElementClickable(UserMobileTabUI.COMPARE_BUTTON);
        clickToElement(UserMobileTabUI.COMPARE_BUTTON);
    }

    public String getTextPopUpWindowTitle() {
        switchWindowByTitle("Products Comparison List - Magento Commerce");
        waitForElementVisible(UserMobileTabUI.POPUP_PAGE_TITLE);
        return getTextElement(UserMobileTabUI.POPUP_PAGE_TITLE);
    }

    public boolean getTextProductName(String productName1, String productName2) {
        boolean b = false;
        waitForElementVisible(UserMobileTabUI.POPUP_PRODUCT_NAME);
        List<WebElement> allProduct = getElements(UserMobileTabUI.POPUP_PRODUCT_NAME);
        for (int i = 0; i < allProduct.size(); i++) {
            String a = allProduct.get(i).getText();
            if (a.equalsIgnoreCase(productName1) || a.equalsIgnoreCase(productName2)) {
                b = true;
            }
        }
        return b;
    }
}
