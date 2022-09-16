package pageObjects;

import common.BasePage;
import interfaces.UserShoppingCartPageUI;
import org.openqa.selenium.WebDriver;

public class UserShoppingCartPageObject extends BasePage {
    WebDriver driver;

    public UserShoppingCartPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void changeQTYValue(String value) {
        waitForElementVisible(UserShoppingCartPageUI.QTY_TEXTBOX);
        sendKeyToElement(UserShoppingCartPageUI.QTY_TEXTBOX, value);
    }

    public void clickToUpdateButton() {
        waitForElementClickable(UserShoppingCartPageUI.UPDATE_BUTTON);
        clickToElement(UserShoppingCartPageUI.UPDATE_BUTTON);
    }

    public boolean errorMsgIsDisplayed() {
        waitForElementVisible(UserShoppingCartPageUI.ERROR_MESSAGE);
        return isDisplayed(UserShoppingCartPageUI.ERROR_MESSAGE);
    }

    public void clickToFooterLink(String value) {
        waitForElementClickable(String.format(UserShoppingCartPageUI.DYNAMIC_FOOTER_LINK, value));
        clickToElement(String.format(UserShoppingCartPageUI.DYNAMIC_FOOTER_LINK,value));
    }

    public boolean verifyMsgCartEmpty() {
        waitForElementVisible(UserShoppingCartPageUI.CART_EMPTY_TITLE);
        return isDisplayed(UserShoppingCartPageUI.CART_EMPTY_TITLE);
    }
}
