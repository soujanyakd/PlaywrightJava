package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage extends InTimeTecBasePage{

    public HomePage(Page page) {
        super(page);
    }

    public void verifyHomePageUrl() {
        assertThat(page).hasURL("https://www.intimetec.com/");
    }
}
