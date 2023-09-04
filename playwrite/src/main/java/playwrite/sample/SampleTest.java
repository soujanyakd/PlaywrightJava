package playwrite.sample;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import configurations.Chrome;
import pages.CareersPage;
import pages.ContactUsPage;
import pages.HomePage;
import util.PlaywrightLocators;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SampleTest {
    public static void main(String[] args) {
        Chrome chrome = new Chrome();
        Page page = chrome.getPage();
        HomePage homePage = new HomePage(page);
        homePage.verifyHomePageUrl();
        System.out.println(homePage.getAllMenuItemsPresentInThePage());
        CareersPage careersPage = homePage.clickOnCareers();
        careersPage.verifyCareersURL();
        careersPage.verifyCompanyValues(Arrays.asList("Trust", "Transparency", "Integrity", "Leadership"));
        careersPage.clickOnBlogs();
        careersPage.clickOnInTimeTecBlog();
        careersPage.clickOnAIAndFraudBlog();
        careersPage.clickOnBook();
        ContactUsPage contactUsPage = careersPage.clickOnContactUS();
        homePage = contactUsPage.clickOnInTimeTecLogo();
        homePage.verifyHomePageUrl();
        assertThat(PlaywrightLocators.locateByText(page, "Blogs")).containsText("abc", new LocatorAssertions.ContainsTextOptions().setIgnoreCase(true));
        page.close();
        //System.out.println(careersPage.getAllTheVisibleLinks());
    }
}
