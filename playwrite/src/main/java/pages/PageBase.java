package pages;

import com.microsoft.playwright.Page;
import configurations.Chrome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PageBase {
    protected Page page;
    Chrome chrome;

    protected PageBase(Page page) {
        this.page = page;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.chrome = new Chrome();
        chrome.launchWebsite();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        this.chrome.tearDown();
    }

}
