package playwrite.sample;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import util.PlaywrightPopupHandler;

@Test
public class AlertsAndPopupsTest extends BaseTest{

    protected AlertsAndPopupsTest(Page page) {
        super(page);
    }

    @Test
    public void alertPopUpTest() {
        Page newTab = PlaywrightPopupHandler.newTab(page, page.locator("id=home"));
        newTab.waitForLoadState();

        newTab.locator("//a[text()='Edit']").click();
        newTab.getByPlaceholder("Enter first & last name").type("Soujanya Dinesh Kottari");
        page.bringToFront();
        newTab.bringToFront();
        //newWindow.close();
    }
}
