package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import util.PlaywrightHelper;
import util.PlaywrightLocators;

public class LoginPage extends SauceLabPageBase {
    public Locator USERNAME_TEXT_BOX = PlaywrightLocators.locateByDifferentLocatorTypes(page, "//*[@id='user-name']");
    public Locator PASSWORD_TEXT_BOX = PlaywrightLocators.locateByDifferentLocatorTypes(page, "//*[@id='password']");
    public Locator LOGIN_BUTTON = PlaywrightLocators.locateByDifferentLocatorTypes(page, "//*[@id='login-button']");

    public LoginPage(Page page) {
        super(page);
    }

    private void enterUsername(String userName)
    {
        PlaywrightHelper.fill(USERNAME_TEXT_BOX, userName);
    }

    private void enterPassword(String password)
    {
        PlaywrightHelper.fill(PASSWORD_TEXT_BOX, password);
    }

    public ProductsPage loginUser(String userName, String password)
    {
        enterUsername(userName);
        enterPassword(password);
        PlaywrightHelper.click(LOGIN_BUTTON);
        return new ProductsPage(page);
    }
}
