package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CatalogAdvancedSearchPage;
import pageObjects.UserMobileTabPage;
import pageObjects.UserTVTabPage;

import java.util.List;
import java.util.Set;

public class BasePage {
    private WebDriver driver;
    private Alert alert;
    Select select;
    JavascriptExecutor jsExecutor;
    private WebDriverWait explicitWait;
    long timeout = 30;
    private Color color;
    private Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //======================================BROWSER=========================================================

    protected void openPageURL(String url) {
        driver.get(url);
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    protected String getPageSource() {
        return driver.getPageSource();
    }

    protected void backPage() {
        driver.navigate().back();
    }

    protected void forwardPage() {
        driver.navigate().forward();
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected void waitForAlertPresence() {
        explicitWait = new WebDriverWait(driver, timeout);
        alert = explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert() {
        waitForAlertPresence();
        alert.accept();
    }

    protected void cancelAlert() {
        waitForAlertPresence();
        alert.dismiss();
    }

    protected String getTextAlert() {
        waitForAlertPresence();
        return alert.getText();
    }

    protected void sendKeyToAlert(String value) {
        waitForAlertPresence();
        alert.sendKeys(value);
    }

    protected void switchWindowByID(String parentID) {
        Set<String> allWindowID = driver.getWindowHandles();
        for (String windowID : allWindowID) {
            if (!windowID.equals(parentID)) {
                driver.switchTo().window(windowID);
            }
        }
    }

    protected void switchWindowByTitle(String expectedWindow) {
        Set<String> allWindowID = driver.getWindowHandles();
        for (String windowID : allWindowID) {
            driver.switchTo().window(windowID);
            String titleWindow = driver.getTitle();
            if (titleWindow.equals(expectedWindow)) {
                break;
            }
        }
    }

    protected void closeAllWindowWithoutParent(String parentID) {
        String titleParentWindow = driver.getTitle();
        Set<String> allWindowID = driver.getWindowHandles();
        for (String windowID : allWindowID) {
            driver.switchTo().window(windowID);
            String titleWindow = driver.getTitle();
            if (!titleWindow.equals(titleParentWindow)) {
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    //========================================================Web Element===============================================

    protected By getXpath(String locator) {
        return By.xpath(locator);
    }

    protected By getDynamicXpath(String locator, String... dynamicValue) {
        return By.xpath(String.format(locator, (Object[]) dynamicValue));
    }

    protected WebElement getElement(String locator) {
        return driver.findElement(getXpath(locator));
    }

    public WebElement getElement(WebDriver driver, String locator, String... dynamicValue) {
        return driver.findElement(getDynamicXpath(locator, dynamicValue));
    }

    protected List<WebElement> getElements(String locator) {
        return driver.findElements(getXpath(locator));
    }

    public List<WebElement> getElements(WebDriver driver, String locator, String... dynamicValue) {
        return driver.findElements(getDynamicXpath(locator, dynamicValue));
    }

    protected void clickToElement(String locator) {
        getElement(locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... dynamicValue) {
        getElement(driver, locator, dynamicValue).click();
    }

    protected void sendKeyToElement(String locator, String value) {
        getElement(locator).clear();
        getElement(locator).sendKeys(value);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value, String... dynamicValue) {
        WebElement element = getElement(driver, locator, dynamicValue);
        element.clear();
        element.sendKeys(value);
    }

    protected void selectItemInDefaultDropdown(String locator, String value) {
        select = new Select(getElement(locator));
        select.selectByVisibleText(value);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String value, String... dynamicValue) {
        select = new Select(getElement(driver, locator, dynamicValue));
        select.selectByVisibleText(value);
    }

    protected void selectItemInCustomDropdown(String parentLocator, String childXpath, String valueChosen) {
        clickToElement(parentLocator);
        List<WebElement> allItem = getElements(childXpath);
        for (WebElement item : allItem) {
            if (item.getText().equalsIgnoreCase(valueChosen)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
            }
        }
    }

    protected boolean isDropdownMultiple(String locator) {
        select = new Select(getElement(locator));
        return select.isMultiple();
    }

    protected String getAttributeValue(String locator, String attribute) {
        return getElement(locator).getAttribute(attribute);
    }

    protected String getTextElement(String locator) {
        return getElement(locator).getText();
    }

    public String getTextElement(WebDriver driver, String locator, String... dynamicValue) {
        return getElement(driver, locator, dynamicValue).getText();
    }

    protected String getCssValue(String locator, String cssName) {
        return getElement(locator).getCssValue(cssName);
    }

    protected String getHexaColorByRgbaColor(String rgbaValue) {
        return color.fromString(rgbaValue).asHex();
    }

    protected int getElementSize(String locator) {
        return getElements(locator).size();
    }

    protected boolean isSelected(String locator) {
        return getElement(locator).isSelected();
    }

    public boolean isControlSelected(WebDriver driver, String locator, String... dynamicValue) {
        return getElement(driver, locator, dynamicValue).isSelected();
    }

    protected boolean isEnable(String locator) {
        return getElement(locator).isEnabled();
    }

    protected boolean isDisplayed(String locator) {
        return getElement(locator).isDisplayed();
    }

    public boolean isControlDisplayed(WebDriver driver, String locator, String... dynamicValue) {
        return getElement(driver, locator, dynamicValue).isDisplayed();
    }

    protected boolean checkingElementPresence(String locator) {
        try {
            explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            return true;
        } catch (Exception a) {
            return false;
        }
    }

    protected void checkTheCheckBoxOrRadio(String locator) {
        if (!isSelected(locator)) {
            clickToElement(locator);
        }
    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator, String... dynamicValue) {
        if (!isControlSelected(driver, locator, dynamicValue)) {
            getElement(driver, locator, dynamicValue).click();
        }
    }

    protected void uncheckTheCheckBoxOrRadio(String locator) {
        if (isSelected(locator)) {
            clickToElement(locator);
        }
    }

    protected void switchToFrameOrIframe(String locator) {
        driver.switchTo().frame(getElement(locator));
    }

    protected void switchToWindowByID() {
        String parentID = driver.getWindowHandle();
        Set<String> allID = driver.getWindowHandles();
        for (String id : allID) {
            if (id.equals(parentID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    protected void switchToWindowByTitle(String expectedTitle) {
        Set<String> allID = driver.getWindowHandles();
        for (String id : allID) {
            driver.switchTo().window(id);
            String title = driver.getTitle();
            if (title.equalsIgnoreCase(expectedTitle)) {
                break;
            }
        }
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    protected void doubleClickToElement(String locator) {
        action = new Actions(driver);
        action.doubleClick(getElement(locator)).perform();
    }

    protected void hoverMouseToElement(String locator) {
        action = new Actions(driver);
        action.moveToElement(getElement(locator)).perform();
    }

    public void hoverMouseToElement(WebDriver driver, String locator, String... dynamicLocator) {
        action = new Actions(driver);
        action.moveToElement(getElement(driver, locator, dynamicLocator)).perform();
    }

    protected void rightClick(String locator) {
        action = new Actions(driver);
        action.contextClick(getElement(locator)).perform();
    }

    protected void dragAndDrop(String locatorStart, String locatorTarget) {
        action = new Actions(driver);
        action.dragAndDrop(getElement(locatorStart), getElement(locatorTarget)).perform();
    }

    public void sendKeyboardToElement(String locator, Keys key) {
        action = new Actions(driver);
        action.sendKeys(getElement(locator), key).perform();
    }

    public Object executeForBrowser(String javaScript) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText() {
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(String textExpected) {
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(locator));
    }

    public void scrollToElement(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void sendKeyToElementByJS(WebDriver driver, String locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public boolean areJQueryAndJSLoadedSuccess() {
        explicitWait = new WebDriverWait(driver, timeout);
        jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public void waitForElementVisible(String locator) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getXpath(locator)));
    }

    public void waitForElementVisible(String locator, String... dynamicValue) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getDynamicXpath(locator, dynamicValue)));
    }

    public void waitForAllElementVisible(String locator) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getXpath(locator)));
    }

    public void waitForElementClickable(String locator) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable((getXpath(locator))));
    }

    public void waitForElementClickable(String locator, String... dynamicValue) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getDynamicXpath(locator, dynamicValue)));
    }

    public void waitForElementInvisible(String locator) {
        explicitWait = new WebDriverWait(driver, timeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getXpath(locator)));
    }


    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public UserMobileTabPage clickToMobileMenuTab() {
        waitForElementClickable(BasePageUI.MENU_MOBILE_TAB);
        clickToElement(BasePageUI.MENU_MOBILE_TAB);
        return PageGenerator.getMobileTabPage(driver);
    }

    public UserTVTabPage clickToTVMenuTab() {
        waitForElementClickable(BasePageUI.MENU_TV_TAB);
        clickToElement(BasePageUI.MENU_TV_TAB);
        return PageGenerator.getTVTabPage(driver);
    }

    public CatalogAdvancedSearchPage clickToAdvancedSearch(String nameLink) {
        waitForElementClickable(String.format(BasePageUI.DYNAMIC_FOOTER_LINK, nameLink));
        clickToElement(String.format(BasePageUI.DYNAMIC_FOOTER_LINK, nameLink));
        return PageGenerator.getCatalogAdvancedSearchPage(driver);
    }
}
