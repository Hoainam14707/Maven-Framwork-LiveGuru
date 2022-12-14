package pageObjects;

import common.BasePage;
import interfaces.BEHomePageUI;
import org.openqa.selenium.WebDriver;

public class BEHomePageObject extends BasePage {
    private WebDriver driver;

    public BEHomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void handlePopup() {
        waitForElementVisible(BEHomePageUI.POPUP);
        if (checkingElementPresence(BEHomePageUI.POPUP)) {
            clickToElement(BEHomePageUI.BUTTON_CLOSE_POPUP);
        }
    }

    public void inputDataToTextbox(String columnName, String rowIndex, String email) {
        //get index column
        int columnIndex = getElements(String.format(BEHomePageUI.COLUMN_INDEX, columnName)).size() + 1;
        waitForElementVisible(BEHomePageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        sendKeyToElement(String.format(BEHomePageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex)),email);
    }
}
