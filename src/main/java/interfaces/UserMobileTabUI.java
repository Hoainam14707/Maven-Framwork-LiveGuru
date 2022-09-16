package interfaces;

public class UserMobileTabUI {
    public static final String PRODUCT_COST = "//a[text()='%s']//parent::h2//following-sibling::div[@class='price-box']//span[contains(@id,'product-price')]";
    public static final String PRODUCT_NAME = "//h2[@class='product-name']//a[text()='%s']";
    public static final String ADD_TO_CART_BUTTON = "//a[text()='%s']//parent::h2//following-sibling::div[@class='actions']//span[text()='Add to Cart']";
}
