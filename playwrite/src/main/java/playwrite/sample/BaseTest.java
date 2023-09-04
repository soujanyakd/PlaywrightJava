package playwrite.sample;

import com.microsoft.playwright.Page;
import pages.PageBase;

public abstract class BaseTest extends PageBase {

    protected BaseTest(Page page) {
        super(page);
    }
}
