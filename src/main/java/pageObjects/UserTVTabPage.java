package pageObjects;

import common.BasePage;
import common.PageGenerator;
import interfaces.UserTVTabUI;
import org.openqa.selenium.WebDriver;

public class UserTVTabPage extends BasePage {
    WebDriver driver;

    public UserTVTabPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserMyAccountPageObject clickAddToWishListLink(String productName) {
        waitForElementVisible(String.format(UserTVTabUI.ADD_TO_WISHLIST_LINK, productName));
        clickToElement(String.format(UserTVTabUI.ADD_TO_WISHLIST_LINK, productName));
        return PageGenerator.getMyAccountPageObject(driver);
    }
}
