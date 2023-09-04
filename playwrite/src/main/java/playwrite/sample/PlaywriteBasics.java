package playwrite.sample;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class PlaywriteBasics {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        LaunchOptions launchOptions = new LaunchOptions();
        launchOptions.setChannel("chrome").setHeadless(false);
        Browser browser = playwright.chromium().launch(launchOptions);
        BrowserContext context = browser.newContext();

        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        Page page = context.newPage();
        page.navigate("https://www.orangehrm.com/");

        String pageTitle = page.title();
        System.out.println("URL is : " + pageTitle);
        page.getByPlaceholder("Enter your email address here").fill("test1@gmail.com");
        page.getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName("OHRM Slider Section")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Try it for Free")).click();
        page.getByPlaceholder("Your Full Name*").click();
        page.getByPlaceholder("Your Full Name*").fill("Playwrite test");
        page.getByPlaceholder("Phone Number*").click();
        page.getByPlaceholder("Phone Number*").fill("9876543210");
        page.locator("#Form_getForm_Country").selectOption("India");
        page.frameLocator("iframe[title=\"reCAPTCHA\"]").getByRole(AriaRole.CHECKBOX, new FrameLocator.GetByRoleOptions().setName("I'm not a robot")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        browser.close();//to close the server
        playwright.close();//to close the server*/

    }
}
