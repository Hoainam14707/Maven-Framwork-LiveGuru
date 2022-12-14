package interfaces;

public class BEHomePageUI {

//Popup
    public static final String POPUP = "//div[@id='message-popup-window']";
    public static final String BUTTON_CLOSE_POPUP = "//div[@id='message-popup-window']//span[text()='close']";
    public static final String COLUMN_INDEX = "//table[@id='customerGrid_table']//span[text()='%s']//ancestor::th";
    public static final String TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "//table[@id='customerGrid_table']//thead//tr[%s]//th[%s]";

}
