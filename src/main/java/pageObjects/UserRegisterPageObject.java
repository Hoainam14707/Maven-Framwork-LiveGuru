package pageObjects;

import common.BasePage;
import interfaces.UserRegisterPageUI;
import org.openqa.selenium.WebDriver;

public class UserRegisterPageObject extends BasePage {
    WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
       super(driver);
       this.driver = driver;
    }


    public void inputDataToForm(String fieldName, String valueSendKey) {
        waitForAllElementVisible(String.format(UserRegisterPageUI.FORM_TEXTBOX_DYNAMIC, fieldName));
        sendKeyToElement(String.format(UserRegisterPageUI.FORM_TEXTBOX_DYNAMIC),valueSendKey);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(UserRegisterPageUI.REGISTER_BUTTON);
    }

    public boolean verifyUserRegisterSuccess() {
        waitForElementVisible(UserRegisterPageUI.SUCCESS_MESSAGE);
        return isDisplayed(UserRegisterPageUI.SUCCESS_MESSAGE);
    }
}
