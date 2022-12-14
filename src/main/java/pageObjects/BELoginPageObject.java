package pageObjects;

import common.BasePage;
import common.PageGenerator;
import interfaces.BELoginPageUI;
import org.openqa.selenium.WebDriver;

public class BELoginPageObject extends BasePage {
    private WebDriver driver;

    public BELoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputDataToForm(String username, String value) {
        waitForElementVisible(String.format(BELoginPageUI.DYNAMIC_FORM, username));
        sendKeyToElement(String.format(BELoginPageUI.DYNAMIC_FORM, username), value);
    }

    public BEHomePageObject clickToLoginButton() {
        waitForElementVisible(BELoginPageUI.LOGIN_BUTTON);
        clickToElement(BELoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getBEHomePage(driver);
    }
}
