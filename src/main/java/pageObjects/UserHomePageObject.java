package pageObjects;

import common.BasePage;
import common.PageGenerator;
import interfaces.UserHomePageUI;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAccountMenu() {
        waitForElementClickable(UserHomePageUI.ACCOUNT_MENU);
        clickToElement(UserHomePageUI.ACCOUNT_MENU);
    }

    public UserRegisterPageObject clickToRegisterLink(String value) {
        waitForElementClickable(String.format(UserHomePageUI.MENU_LINK, value));
        clickToElement(String.format(UserHomePageUI.MENU_LINK, value));
        return PageGenerator.getRegisterPageObject(driver);
    }

    public UserLoginPageObject clickToLoginLink(String value) {
        waitForElementClickable(String.format(UserHomePageUI.MENU_LINK, value));
        clickToElement(String.format(UserHomePageUI.MENU_LINK, value));
        return PageGenerator.getLoginPageObject(driver);
    }

    public UserMobileTabPage clickToMenuTab(String nameTab) {
        waitForElementVisible(String.format(UserHomePageUI.MENU_TAB, nameTab));
        clickToElement(String.format(UserHomePageUI.MENU_TAB, nameTab));
        return PageGenerator.getMobileTabPage(driver);
    }
}
