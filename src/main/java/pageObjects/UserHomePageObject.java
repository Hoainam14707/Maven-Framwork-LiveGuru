package pageObjects;

import common.BasePage;
import common.PageGenerator;
import interfaces.UserHomePageUI;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        super(driver);
//        this.driver = driver;
    }

    public void clickToAccountMenu() {
        waitForElementClickable(UserHomePageUI.ACCOUNT_MENU);
        clickToElement(UserHomePageUI.ACCOUNT_MENU);
    }

    public UserRegisterPageObject clickToRegisterLink() {
        waitForElementClickable(UserHomePageUI.REGISTER_LINK);
        clickToElement(UserHomePageUI.ACCOUNT_MENU);
        return PageGenerator.getRegisterPageObject(driver);
    }
}
