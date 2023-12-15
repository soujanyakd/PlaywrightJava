package configurations;

import com.microsoft.playwright.Page;

public interface IBrowsers {
    void setUpBrowser();
    void setUpBrowserContext();
    Page getNewPage();

}
