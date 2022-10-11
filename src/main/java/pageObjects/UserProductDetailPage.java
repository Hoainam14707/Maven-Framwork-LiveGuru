package pageObjects;

import common.BasePage;
import interfaces.UserProductDetailPageUI;
import org.openqa.selenium.WebDriver;

public class UserProductDetailPage extends BasePage {
    WebDriver driver;

    public UserProductDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getProductCostInDetailPage(String productName) {
        waitForElementVisible(String.format(UserProductDetailPageUI.PRODUCT_COST, productName));
        return getTextElement(String.format(UserProductDetailPageUI.PRODUCT_COST, productName));
    }

    // TV Tab
    public void clickToAddYourReviewLink() {
        waitForElementClickable(UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
    }

    public void clickSubmitReviewButton() {
        waitForElementClickable(UserProductDetailPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(UserProductDetailPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public boolean verifyErrorMessageThoughFieldDisplayed() {
        waitForElementVisible(UserProductDetailPageUI.THOUGHT_FIELD_ERROR_MESSAGE);
        return isDisplayed(UserProductDetailPageUI.THOUGHT_FIELD_ERROR_MESSAGE);
    }

    public boolean verifyErrorMessageSummaryFieldDisplayed() {
        waitForElementVisible(UserProductDetailPageUI.SUMMARY_FIELD_ERROR_MESSAGE);
        return isDisplayed(UserProductDetailPageUI.SUMMARY_FIELD_ERROR_MESSAGE);
    }

    public boolean verifyErrorMessageNicknameFieldDisplayed() {
        waitForElementVisible(UserProductDetailPageUI.NICKNAME_FIELD_ERROR_MESSAGE);
        return isDisplayed(UserProductDetailPageUI.NICKNAME_FIELD_ERROR_MESSAGE);
    }

    public void inputDataToThoughtField(String value) {
        waitForElementVisible(UserProductDetailPageUI.THOUGHT_FIELD_TEXTBOX);
        sendKeyToElement(UserProductDetailPageUI.THOUGHT_FIELD_TEXTBOX, value);
    }

    public void inputDataToSummaryField(String value) {
        waitForElementVisible(UserProductDetailPageUI.SUMMARY_FIELD_TEXTBOX);
        sendKeyToElement(UserProductDetailPageUI.SUMMARY_FIELD_TEXTBOX, value);
    }

    public void inputDataToNicknameField(String value) {
        waitForElementVisible(UserProductDetailPageUI.NICKNAME_FIELD_TEXTBOX);
        sendKeyToElement(UserProductDetailPageUI.NICKNAME_FIELD_TEXTBOX, value);
    }

    public void selectRating() {
        waitForElementClickable(UserProductDetailPageUI.RATING_RADIO);
        checkTheCheckBoxOrRadio(UserProductDetailPageUI.RATING_RADIO);
    }

    public boolean verifySuccessMessageDisplayed() {
        waitForElementClickable(UserProductDetailPageUI.SUCCESS_MESSAGE);
        return isDisplayed(UserProductDetailPageUI.SUCCESS_MESSAGE);
    }
}
