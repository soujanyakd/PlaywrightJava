package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import util.PlaywrightHelper;
import util.PlaywrightLocators;

public class CartPage extends SauceLabPageBase {
    public Locator CART_PRODUCT_NAME = PlaywrightLocators.locateByDifferentLocatorTypes(page, "//*[@class='inventory_item_name']");

    public String priceTag = "//div[text()='%s']//parent::a//../..//div[@class='item_pricebar']/div";

    protected CartPage(Page page) {
        super(page);
    }

    public String getProductName()
    {
        return PlaywrightHelper.getTextContentValue(CART_PRODUCT_NAME);
    }

    public String getProductPrice(String productName)
    {
        return PlaywrightHelper.getTextContentValue(PlaywrightLocators.locateByDifferentLocatorTypes(page, String.format(priceTag, productName))).split("$")[0];
    }
}
