package common;

import org.openqa.selenium.WebDriver;
import pageObjects.UserMyAccountPageObject;
import pageObjects.UserHomePageObject;
import pageObjects.UserRegisterPageObject;

public class PageGenerator {
    public static UserHomePageObject getHomePageObject(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserRegisterPageObject getRegisterPageObject(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }

    public static UserMyAccountPageObject getMyAccountPageObject(WebDriver driver) {
        return new UserMyAccountPageObject(driver);
    }
}
