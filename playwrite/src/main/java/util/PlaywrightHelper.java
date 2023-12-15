package util;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.KeyboardModifier;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class PlaywrightHelper {

    public static void click(Locator locator) {
        locator.click();
    }

    public static void doubleClick(Locator locator) {
        locator.dblclick();
    }

    public static void rightClick(Locator locator) {
        locator.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }

    //Ctrl + click, Shift + click
    public static void comboClick(Locator locator, List<KeyboardModifier> keys) {
        locator.click(new Locator.ClickOptions().setModifiers(keys));
    }

    public static void forceClick(Locator locator) {
        locator.click(new Locator.ClickOptions().setForce(true));
    }

    public static void hover(Locator locator) {
        locator.hover();
    }

    //Enter, Control+S, Control+A, $ etc
    public static void performKeyboardActions(Locator locator, String keys) {
        locator.press(keys);
    }

    //fill() works as copy and paste, It clears the existing text and then enters the text to the Input Field
    public static void fill(Locator locator, String value) {
        locator.fill(value);
    }

    //type() enters each character one by one, It will append the text to the  beginning of existing value in the Input Field
    public static void type(Locator locator, String value) {
        locator.type(value);
    }

    public static void clear(Locator locator) {
        locator.clear();
    }

    public static void check(Locator locator) {
        locator.check();
    }

    public static void unCheck(Locator locator) {
        locator.uncheck();
    }

    public static void toggleTheRadioButton(Locator locator, Boolean isCheck) {
        locator.setChecked(isCheck);
    }

    public static void selectOption(Locator locator, String optionValue) {
        locator.selectOption(optionValue);
    }

    public static void selectMultipleOptions(Locator locator, String[] optionValues) {
        locator.selectOption(optionValues);
    }

    public static void selectOptionBySpecifiedLabel(Locator locator, String label) {
        locator.selectOption(new SelectOption().setLabel(label));
    }

    public static void selectOptionBySpecifiedIndex(Locator locator, int index) {
        locator.selectOption(new SelectOption().setIndex(index));
    }

    public static List<String> getAllInnerTexts(Locator locator) {
        return locator.allInnerTexts();
    }

    public static List<String> getAllTextContents(Locator locator) {
        return locator.allTextContents();
    }

    public static String getAttributeValue(Locator locator, String attribute) {
        return locator.getAttribute(attribute);
    }

    public static String getTextContentValue(Locator locator) {
        return locator.textContent();
    }

    public static String getInnerTextValue(Locator locator) {
        return locator.innerText();
    }
}
