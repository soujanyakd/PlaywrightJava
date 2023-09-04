package configurations;

import com.microsoft.playwright.*;
import lombok.Getter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Chrome implements IBrowsers {

    Browser browser;
    BrowserContext browserContext;
    @Getter
    Page page;

    @Override
    public void setUpBrowser() {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome").setHeadless(false);
        this.browser = playwright.chromium().launch(launchOptions);
    }

    @Override
    public void setUpBrowserContext() {
        setUpBrowser();
        this.browserContext = browser.newContext();
    }

    @Override
    public Page getNewPage() {
        setUpBrowserContext();
        this.page = browserContext.newPage();
        return this.page;
    }

    public void launchWebsite() {
        System.out.println("Inside @BeforeMethod");
        this.page = getNewPage();
        this.page.navigate("https://letcode.in/windows");
    }


    public void tearDown() {
        this.browser.close();
        this.page.close();
    }
}
