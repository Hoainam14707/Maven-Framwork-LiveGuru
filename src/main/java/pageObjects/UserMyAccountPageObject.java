package pageObjects;

import common.BasePage;
import interfaces.UserMyAccountPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserMyAccountPageObject extends BasePage {
    private WebDriver driver;

    public UserMyAccountPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToLeftSideBar(String titleName) {
        waitForElementVisible(String.format(UserMyAccountPageUI.TITLE_LEFT_SIDE_BAR, titleName));
        clickToElement(String.format(UserMyAccountPageUI.TITLE_LEFT_SIDE_BAR, titleName));
    }

    public String getValueInForm(String title, String attribute) {
        waitForElementVisible(String.format(UserMyAccountPageUI.FORM_TEXTBOX_DYNAMIC, title));
        return getAttributeValue(String.format(UserMyAccountPageUI.FORM_TEXTBOX_DYNAMIC, title), attribute);
    }

    public String getTextDashboardHeaderText() {
        waitForElementVisible(UserMyAccountPageUI.WELCOME_MESSAGE);
        return getTextElement(UserMyAccountPageUI.WELCOME_MESSAGE);
    }

    //WishList
    public void clickShareToWishListButton() {
        waitForElementClickable(UserMyAccountPageUI.SHARE_WISHLIST_BUTTON);
        clickToElement(UserMyAccountPageUI.SHARE_WISHLIST_BUTTON);
    }


    public void inputDataToEmailTextbox(String value) {
        waitForElementVisible(UserMyAccountPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(UserMyAccountPageUI.EMAIL_TEXTBOX, value);
    }

    public void inputDataToMessageTextbox(String value) {
        waitForElementVisible(UserMyAccountPageUI.MESSAGE_TEXTBOX);
        sendKeyToElement(UserMyAccountPageUI.MESSAGE_TEXTBOX, value);
    }

    public boolean verifyProductInMyWishList(String productName) {
        boolean result = false;
        List<WebElement> allProduct = getElements(UserMyAccountPageUI.PRODUCT_NAME);
        for (int i = 0; i < allProduct.size(); i++) {
            String a = allProduct.get(i).getText();
            if (a.equalsIgnoreCase(productName)) {
                result = true;
            }
        }
        return result;
    }

    public boolean verifySharedSuccessfullyWithMessage() {
        waitForElementVisible(UserMyAccountPageUI.SUCCESS_MESSAGE);
        return isDisplayed(UserMyAccountPageUI.SUCCESS_MESSAGE);
    }
}
