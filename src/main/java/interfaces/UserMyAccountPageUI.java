package interfaces;

public class UserMyAccountPageUI {
    public static final String TITLE_LEFT_SIDE_BAR = "//div[@class = 'col-left sidebar col-left-first']//a[text()='%s']";
    public static final String FORM_TEXTBOX_DYNAMIC = "//input[@id='%s']";
    public static final String WELCOME_MESSAGE = "//div[@class='welcome-msg']//strong";

    //Wishlist
    public static final String SHARE_WISHLIST_BUTTON = "//span[text()='Share Wishlist']//ancestor::button";
    public static final String EMAIL_TEXTBOX = "//textarea[@id='email_address']";
    public static final String MESSAGE_TEXTBOX = "//textarea[@id='message']";
    public  static final String PRODUCT_NAME = "//h3[@class = 'product-name']";
    public static final String SUCCESS_MESSAGE = "//li[@class='success-msg']//span[text()='Your Wishlist has been shared.']";
}
