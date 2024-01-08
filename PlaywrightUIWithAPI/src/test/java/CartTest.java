import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest extends TestBase {

    @Test
    public void verifyShoppingSummaryTest()
    {
        String productName = "Sauce Labs Backpack";
        LoginPage loginPage = new LoginPage(getPage());
        ProductsPage productsPage = loginPage.loginUser("standard_user", "secret_sauce");

        String price = productsPage.getPriceOfSpecifiedProduct(productName);
        productsPage.addSpecifiedProductToTheCart(productName);
        CartPage cartPage = productsPage.openCart();

        Assert.assertEquals(productName, cartPage.getProductName());
        Assert.assertEquals(price, cartPage.getProductPrice(cartPage.getProductName()));
    }

}
