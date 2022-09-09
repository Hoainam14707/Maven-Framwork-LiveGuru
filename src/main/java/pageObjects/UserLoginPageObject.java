package pageObjects;

import common.BasePage;
import common.PageGenerator;
import interfaces.UserLoginPageUI;
import org.openqa.selenium.WebDriver;

public class UserLoginPageObject extends BasePage {
    WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputDataToLoginField(String fieldName, String valueInput) {
        waitForElementVisible(String.format(UserLoginPageUI.LOGIN_FIELD_TEXTBOX,fieldName));
        sendKeyToElement(String.format(UserLoginPageUI.LOGIN_FIELD_TEXTBOX,fieldName), valueInput);
    }

    public UserMyAccountPageObject clickToLoginButton() {
        waitForElementClickable(UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getMyAccountPageObject(driver);
    }
}
