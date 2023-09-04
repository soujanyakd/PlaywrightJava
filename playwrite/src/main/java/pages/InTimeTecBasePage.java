package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import util.PlaywrightHelper;
import util.PlaywrightLocators;

import java.util.List;


public class InTimeTecBasePage extends PageBase{

    public Locator BLOGS_MENU = PlaywrightLocators.locateByText(page, "Blogs");
    public Locator INTIMETEC_BLOGS_LINK = PlaywrightLocators.locateByText(page, "In Time Tec Blog");
    public Locator AI_AND_FRAUD_BLOG_LINK = PlaywrightLocators.locateByDifferentLocatorTypes(page, "h2 a:has-text(\"AI and Fraud: Benefits and Limitations in Today\'s Technology Landscape\")");
    public Locator CONTACT_US_MENU = PlaywrightLocators.locateByRoleWithExactName(page,"Contact Us", AriaRole.MENUITEM);
    public Locator BOOKS_MENU = PlaywrightLocators.locateByRole(page,"Books", AriaRole.MENUITEM);
    public Locator INTIMETEC_LOGO = PlaywrightLocators.locateByAltText(page,"New Updated Logo Jan 2023");
    public String CAREERS = "//div[@id='hs_menu_wrapper_footer-module_']//a[text()='Careers']";

    public InTimeTecBasePage(Page page) {
        super(page);
    }

    public CareersPage clickOnCareers() {
        page.locator(CAREERS).click();
        return new CareersPage(page);
    }

    public void clickOnBlogs() {
        PlaywrightHelper.click(BLOGS_MENU);
    }

    public void clickOnInTimeTecBlog() {
        PlaywrightHelper.click(INTIMETEC_BLOGS_LINK);
    }

    public void clickOnAIAndFraudBlog() {
        PlaywrightHelper.click(AI_AND_FRAUD_BLOG_LINK);
    }

    public ContactUsPage clickOnContactUS() {
        PlaywrightHelper.click(CONTACT_US_MENU);
        return new ContactUsPage(page);
    }

    public void clickOnBook() {
        PlaywrightHelper.click(BOOKS_MENU);
    }

    public List<String> getAllMenuItemsPresentInThePage() {
        return PlaywrightHelper.getAllTextContents(PlaywrightLocators.locateByRole(page, AriaRole.MENUITEM));
    }

    public HomePage clickOnInTimeTecLogo() {
        PlaywrightHelper.click(INTIMETEC_LOGO);
        return new HomePage(page);
    }
}
