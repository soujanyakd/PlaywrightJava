package playwrite.sample;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class MultipleBrowser {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome").setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);

        BrowserContext firstContext = browser.newContext();
        Page firstPage = firstContext.newPage();
        firstPage.navigate("https://www.chatiw.me/");
        firstPage.fill("#input1", "testAuto1");
        firstPage.selectOption("#age_list", "18");
        firstPage.locator(".gender_male").click();
        firstPage.locator("#submit_btn").click();
        firstPage.locator("#recaptcha-anchor").click();
        firstPage.locator(".btn btn-primary").click();

        BrowserContext secondContext = browser.newContext();
        Page secondPage = secondContext.newPage();
        secondPage.navigate("https://www.chatiw.me/");
        secondPage.fill("#input1", "testAuto2");
        secondPage.selectOption("#age_list", "18");
        secondPage.locator(".gender_male").click();
        secondPage.locator("#submit_btn").click();
        secondPage.locator("#recaptcha-anchor").click();
        secondPage.locator(".btn btn-primary").click();
        secondPage.locator(".fas fa-search").click();
        secondPage.locator("#male-checkbox").click();
        secondPage.locator("#nickname").fill("testAuto1");
        secondPage.getByText(" Search ");
        secondPage.locator("div.user-list-container > div.list-group.list-group-flush > a").click();
        secondPage.getByPlaceholder("Type a message").fill("Hi testAuto1");
        secondPage.locator(".fas fa-paper-plane").click();
    }
}
