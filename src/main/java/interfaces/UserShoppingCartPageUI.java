package interfaces;

public class UserShoppingCartPageUI {
    public static final String QTY_TEXTBOX = "//input[@class = 'input-text qty']";
    public static final String UPDATE_BUTTON = "//span[text()='Update']//ancestor::button";
    public static final String ERROR_MESSAGE = "//p[@class='item-msg error' and contains(text(),'The maximum quantity allowed for purchase is 500.')]";
    public static final String DYNAMIC_FOOTER_LINK = "//span[text()='%s']//ancestor::button";
    public static final String CART_EMPTY_TITLE = "//h1[text()='Shopping Cart is Empty']";
}
