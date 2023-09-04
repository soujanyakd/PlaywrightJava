package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CareersPage extends InTimeTecBasePage{

    public String COMPANY_VALUES = "//div[@class='span3 widget-span widget-type-custom_widget dnd-module']//h3[@class='atmc-h4 mt-3']";

    public CareersPage(Page page) {
        super(page);
    }

    public void verifyCareersURL() {
        assertThat(page).hasURL("https://www.intimetec.com/careers");
    }

    public void verifyCompanyValues(List<String> values) {
        Locator locator = page.locator(COMPANY_VALUES);
        for(int i = 0; i< locator.count(); i++) {
            if(values.contains(locator.nth(i).textContent())) {
                System.out.println(locator.nth(i).textContent() + "\n");
            }
        }

        System.out.println("---------------- Via AllTextContent()-----------------");
        System.out.println(locator.allTextContents());
        System.out.println("------------------------------------------------------");

        if(values.containsAll(locator.allInnerTexts())) {
            System.out.println(locator.allInnerTexts());
        }
    }

}
