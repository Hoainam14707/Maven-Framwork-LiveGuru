package pageObjects;

import common.BasePage;
import common.PageGenerator;
import interfaces.UserRegisterPageUI;
import org.openqa.selenium.WebDriver;

public class UserRegisterPageObject extends BasePage {
    WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void inputDataToForm(String fieldName, String valueSendKey) {
        waitForElementVisible(String.format(UserRegisterPageUI.FORM_TEXTBOX_DYNAMIC, fieldName));
        sendKeyToElement(String.format(UserRegisterPageUI.FORM_TEXTBOX_DYNAMIC, fieldName), valueSendKey);
    }

    public UserMyAccountPageObject clickToRegisterButton() {
        waitForElementClickable(UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(UserRegisterPageUI.REGISTER_BUTTON);
        return PageGenerator.getMyAccountPageObject(driver);
    }

    public boolean verifyUserRegisterSuccess() {
        waitForElementVisible(UserRegisterPageUI.SUCCESS_MESSAGE);
        return isDisplayed(UserRegisterPageUI.SUCCESS_MESSAGE);
    }
}
