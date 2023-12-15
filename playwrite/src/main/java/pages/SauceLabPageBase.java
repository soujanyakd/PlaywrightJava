package pages;

import Base.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import util.PlaywrightLocators;

public class SauceLabPageBase extends PageBase {

    public Locator BLOGS_MENU = PlaywrightLocators.locateByText(page, "Blogs");
    public Locator INTIMETEC_BLOGS_LINK = PlaywrightLocators.locateByText(page, "In Time Tec Blog");
    public Locator AI_AND_FRAUD_BLOG_LINK = PlaywrightLocators.locateByDifferentLocatorTypes(page, "h2 a:has-text(\"AI and Fraud: Benefits and Limitations in Today\'s Technology Landscape\")");
    public Locator CONTACT_US_MENU = PlaywrightLocators.locateByRoleWithExactName(page, "Contact Us", AriaRole.MENUITEM);
    public Locator BOOKS_MENU = PlaywrightLocators.locateByRole(page, "Books", AriaRole.MENUITEM);
    public Locator INTIMETEC_LOGO = PlaywrightLocators.locateByAltText(page, "New Updated Logo Jan 2023");
    public String CAREERS = "//div[@id='hs_menu_wrapper_footer-module_']//a[text()='Careers']";

    public SauceLabPageBase(Page page) {
        super(page);
    }
}
