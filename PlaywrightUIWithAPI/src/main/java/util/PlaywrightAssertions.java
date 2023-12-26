package util;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightAssertions {

    public void verifyLocatorContainsText(Locator locator, String expectedValue) {
        assertThat(locator).containsText(expectedValue);
    }

    public void verifyLocatorsContainsTexts(Locator locator, String[] expectedValues) {
        assertThat(locator).containsText(expectedValues);
    }

    public void verifyLocatorContainsExactText(Locator locator, String expectedValue) {
        assertThat(locator).containsText(expectedValue, new LocatorAssertions.ContainsTextOptions().setIgnoreCase(false));
    }

    public void verifyLocatorHasText(Locator locator, String expectedValue) {
        assertThat(locator).hasText(expectedValue);
    }

    public void verifyLocatorsHasTexts(Locator locator, String[] expectedValue) {
        assertThat(locator).hasText(expectedValue);
    }

    public void verifyLocatorHasExactText(Locator locator, String expectedValue) {
        assertThat(locator).hasText(expectedValue, new LocatorAssertions.HasTextOptions().setIgnoreCase(false));
    }

    public void verifyAttributeValue(Locator locator, String attributeValue, String expectedValue) {
        assertThat(locator).hasAttribute(attributeValue, expectedValue);
    }

    public void verifyHasValue(Locator locator, String expectedOption) {
        assertThat(locator).hasValue(expectedOption);
    }

    public void verifyHasValues(Locator locator, String[] expectedOptions) {
        assertThat(locator).hasValues(expectedOptions);
    }

    public void verifyIfLocatorIsChecked(Locator locator, boolean isChecked) {
        assertThat(locator).isChecked(new LocatorAssertions.IsCheckedOptions().setChecked(isChecked));
    }

    public void verifyIfLocatorDisabled(Locator locator) {
        assertThat(locator).isDisabled();
    }

    public void verifyIfLocatorEnabled(Locator locator) {
        assertThat(locator).isEnabled();
    }

    public void verifyIfFieldEditable(Locator locator, boolean isEditable) {
        assertThat(locator).isEditable(new LocatorAssertions.IsEditableOptions().setEditable(isEditable));
    }

    public void verifyIfFieldIsEmpty(Locator locator) {
        assertThat(locator).isEmpty();
    }

    public void verifyIfFieldIsHidden(Locator locator) {
        assertThat(locator).isHidden();
    }

    public void verifyIfFieldIsVisible(Locator locator) {
        assertThat(locator).isVisible();
    }
}