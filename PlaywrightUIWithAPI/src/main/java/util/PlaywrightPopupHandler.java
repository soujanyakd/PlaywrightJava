package util;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PlaywrightPopupHandler {

    public void closeAlert(Page page, Locator locator, Boolean accept) {
        //Handler that handles the Alert
        page.onDialog(dialog -> {
            if(accept) {
                dialog.message();
                dialog.accept();
            } else {
                dialog.dismiss();
            }
        });

        //action that trigger's alert
        PlaywrightHelper.click(locator);

    }

    public void closePrompt(Page page, Locator locator, Boolean accept, String input) {
        //Handler that handles the Alert
        page.onDialog(dialog -> {
            if(accept) {
                dialog.accept(input);
            } else {
                dialog.dismiss();
            }
        });

        //action that trigger's alert
        PlaywrightHelper.click(locator);
    }

    public static Page newTab(Page page, Locator locator) {
        Page newTab = page.waitForPopup(()->{
            PlaywrightHelper.click(locator);
        });
        return newTab;
    }

    public static void bringPageToFront(Page page) {
        page.bringToFront();
    }
}
