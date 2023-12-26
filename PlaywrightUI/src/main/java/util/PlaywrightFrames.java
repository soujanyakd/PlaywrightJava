package util;

import com.microsoft.playwright.Page;

public class PlaywrightFrames {

    //This method can be used when you know the locator of the frame
    public static void clickOnFrameLocator(Page page, String frameLocator, String locator) {
        page.frameLocator(frameLocator).locator(locator).click();
    }

    //This method can be used when you know the @name of the frame
    public static void clickOnFrameNameLocator(Page page, String frameName, String locator) {
        page.frame(frameName).locator(locator).click();
    }
}
