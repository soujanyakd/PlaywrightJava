package configurations;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public interface IBrowsers {
    void setUpBrowser();
    void setUpBrowserContext();
    Page getNewPage();

}
