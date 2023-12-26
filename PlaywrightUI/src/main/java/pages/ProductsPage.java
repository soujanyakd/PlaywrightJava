package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import util.PlaywrightHelper;
import util.PlaywrightLocators;

public class ProductsPage extends SauceLabPageBase {
    public Locator CART_ICON = PlaywrightLocators.locateByDifferentLocatorTypes(page, "//*[@class='shopping_cart_link']");

    public String priceTag = "//div[text()='%s']//parent::a//../..//div[@class='pricebar']/div";
    public String addToCartButton = "//div[text()='%s']//parent::a//../..//div[@class='pricebar']/button";

    protected ProductsPage(Page page) {
        super(page);
    }

    public String getPriceOfSpecifiedProduct(String productName)
    {
        return PlaywrightHelper.getTextContentValue(PlaywrightLocators.locateByDifferentLocatorTypes(page, String.format(priceTag, productName))).split("$")[0];
    }

    public void addSpecifiedProductToTheCart(String productName)
    {
        PlaywrightHelper.click(PlaywrightLocators.locateByDifferentLocatorTypes(page, String.format(addToCartButton, productName)));
    }

    public CartPage openCart()
    {
        PlaywrightHelper.click(CART_ICON);
        return new CartPage(page);
    }
}
