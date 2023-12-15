package Base;

import com.microsoft.playwright.Page;
import configurations.Chrome;
import lombok.Getter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    Chrome chrome;

    @Getter
    protected Page page;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        chrome = new Chrome();
        this.page = chrome.launchWebsite();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        this.chrome.tearDown();
    }
}
