package pageObjects;

import common.BasePage;
import interfaces.CatalogAdvancedSearchPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogAdvancedSearchPage extends BasePage {
    private WebDriver driver;

    public CatalogAdvancedSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputPrice(String price, String value) {
        waitForElementVisible(String.format(CatalogAdvancedSearchPageUI.DYNAMIC_PRICE, price));
        sendKeyToElement(String.format(CatalogAdvancedSearchPageUI.DYNAMIC_PRICE, price), value);
    }

    public void clickToSearchButton() {
        waitForElementClickable(CatalogAdvancedSearchPageUI.SEARCH_BUTTON);
        clickToElement(CatalogAdvancedSearchPageUI.SEARCH_BUTTON);
    }

    public void storageProductName() {
        waitForAllElementVisible(CatalogAdvancedSearchPageUI.PRODUCT_NAME);
        List<WebElement> allProductName = getElements(CatalogAdvancedSearchPageUI.PRODUCT_NAME);
        for (WebElement product : allProductName) {
            System.out.println("Product name is: " + product.getText());
        }
    }

    public void storageProductPrice() {
        waitForAllElementVisible(CatalogAdvancedSearchPageUI.PRODUCT_PRICE);
        List<WebElement> allProductPrice = getElements(CatalogAdvancedSearchPageUI.PRODUCT_PRICE);
        for (WebElement price : allProductPrice) {
            System.out.println("Product price is: " + price.getText());
        }
    }
}
