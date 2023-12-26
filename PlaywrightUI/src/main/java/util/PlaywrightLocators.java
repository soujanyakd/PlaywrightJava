package util;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PlaywrightLocators {

    public static Locator locateByRole(Page page, String name, AriaRole role) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(name));
    }

    public static Locator locateByRole(Page page, AriaRole role) {
        return page.getByRole(role);
    }

    public static Locator locateByRoleWithExactName(Page page, String name, AriaRole role) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(name).setExact(true));
    }

    public static Locator locateByText(Page page, String text) {
        return page.getByText(text);
    }

    public static Locator locateByExactText(Page page, String text) {
        return page.getByText(text, new Page.GetByTextOptions().setExact(true));
    }

    public static Locator locateByAltText(Page page, String altText) {
        return page.getByAltText(altText);
    }

    public static Locator locateByExactAltText(Page page, String altText) {
        return page.getByAltText(altText, new Page.GetByAltTextOptions().setExact(true));
    }

    public Locator locateByLabel(Page page, String labelName) {
        return page.getByLabel(labelName);
    }

    public static Locator locateByExactLabel(Page page, String labelName) {
        return page.getByLabel(labelName, new Page.GetByLabelOptions().setExact(true));
    }

    public static Locator locateByPlaceholder(Page page, String placeholderName) {
        return page.getByPlaceholder(placeholderName);
    }

    public static Locator locateByExactPlaceholder(Page page, String placeholderName) {
        return page.getByPlaceholder(placeholderName, new Page.GetByPlaceholderOptions().setExact(true));
    }

    public static Locator locateByDifferentLocatorTypes(Page page, String locator) {
        return page.locator(locator);
    }
}
