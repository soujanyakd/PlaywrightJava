package Base;

import com.microsoft.playwright.Page;

public class PageBase {
    protected Page page;

    protected PageBase(Page page) {
        this.page = page;
    }

}
