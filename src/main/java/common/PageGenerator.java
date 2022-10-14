package common;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

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

    public static UserLoginPageObject getLoginPageObject(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserMobileTabPage getMobileTabPage(WebDriver driver) {
        return new UserMobileTabPage(driver);
    }

    public static UserTVTabPage getTVTabPage(WebDriver driver) {
        return new UserTVTabPage(driver);
    }

    public static UserProductDetailPage getProductDetailPage(WebDriver driver) {
        return new UserProductDetailPage(driver);
    }

    public static UserShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
        return new UserShoppingCartPageObject(driver);
    }

    public static CatalogAdvancedSearchPage getCatalogAdvancedSearchPage(WebDriver driver) {
        return new CatalogAdvancedSearchPage(driver);
    }
}
