package pageObjects;

import common.BasePage;
import interfaces.UserMyAccountPageUI;
import org.openqa.selenium.WebDriver;

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
}
