package pageObjects;

import common.BasePage;
import common.PageGenerator;
import interfaces.UserMobileTabUI;
import org.openqa.selenium.WebDriver;

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
        waitForElementClickable(String.format(UserMobileTabUI.PRODUCT_NAME,productName));
        clickToElement(String.format(UserMobileTabUI.PRODUCT_NAME,productName));
        return PageGenerator.getProductDetailPage(driver);
    }
}
