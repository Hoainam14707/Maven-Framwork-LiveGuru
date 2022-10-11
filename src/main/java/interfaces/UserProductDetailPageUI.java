package interfaces;

public class UserProductDetailPageUI {
    public static final String PRODUCT_COST = "//span[text()='%s']//parent::div//following-sibling::div[@class='price-info']//span[@class='price']";

    //TV
    public static final String ADD_YOUR_REVIEW_LINK = "//p[@class='rating-links']//a[text()='Add Your Review']";
    public static final String SUBMIT_REVIEW_BUTTON = "//span[text()='Submit Review']//ancestor::button";
    public static final String THOUGHT_FIELD_ERROR_MESSAGE = "//div[@id='advice-required-entry-review_field']";
    public static final String SUMMARY_FIELD_ERROR_MESSAGE = "//div[@id='advice-required-entry-summary_field']";
    public static final String NICKNAME_FIELD_ERROR_MESSAGE = "//div[@id='advice-required-entry-nickname_field']";
    public static final String THOUGHT_FIELD_TEXTBOX = "//textarea[@id='review_field']";
    public static final String SUMMARY_FIELD_TEXTBOX = "//input[@id='summary_field']";
    public static final String NICKNAME_FIELD_TEXTBOX = "//input[@id='nickname_field']";
    public static final String RATING_RADIO = "//input[@id='Quality 1_5']";
    public static final String SUCCESS_MESSAGE = "//li[@class='success-msg']//span[text()='Your review has been accepted for moderation.']";
}
