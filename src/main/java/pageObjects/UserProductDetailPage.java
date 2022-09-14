package pageObjects;

import common.BasePage;
import interfaces.UserProductDetailPageUI;
import org.openqa.selenium.WebDriver;

public class UserProductDetailPage extends BasePage {
    WebDriver driver;

    public UserProductDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getProductCostInDetailPage(String productName) {
        waitForElementVisible(String.format(UserProductDetailPageUI.PRODUCT_COST,productName));
        return getTextElement(String.format(UserProductDetailPageUI.PRODUCT_COST,productName));
    }
}
