package configurations;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Chrome implements IBrowsers {

    Browser browser;
    BrowserContext browserContext;
    Page page;

    @Override
    public void setUpBrowser() {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome").setHeadless(false);
        browser = playwright.chromium().launch(launchOptions);
    }

    @Override
    public void setUpBrowserContext() {
        setUpBrowser();
        browserContext = browser.newContext();
    }

    @Override
    public Page getNewPage() {
        setUpBrowserContext();
        page = browserContext.newPage();
        return page;
    }

    public Page launchWebsite() {
        page = getNewPage();
        page.navigate("https://www.saucedemo.com/");
        return page;
    }

    public void tearDown() {
        browser.close();
        page.close();
    }

    public void initializeTrace() {
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
    }

    public void tearDownTrace() {
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
    }
}
