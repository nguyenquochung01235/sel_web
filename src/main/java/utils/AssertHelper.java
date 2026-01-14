package utils;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AssertHelper {

    private static SoftAssert softAssert = new SoftAssert();

    // =========================
    // HARD ASSERTIONS
    // =========================

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static void assertNotEquals(Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    public static void assertNotNull(Object object, String message) {
        Assert.assertNotNull(object, message);
    }

    public static void assertNull(Object object, String message) {
        Assert.assertNull(object, message);
    }

    public static void fail(String message) {
        Assert.fail(message);
    }

    // =========================
    // SOFT ASSERTIONS
    // =========================

    public static void softAssertTrue(boolean condition, String message) {
        softAssert.assertTrue(condition, message);
    }

    public static void softAssertFalse(boolean condition, String message) {
        softAssert.assertFalse(condition, message);
    }

    public static void softAssertEquals(Object actual, Object expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public static void softAssertNotEquals(Object actual, Object expected, String message) {
        softAssert.assertNotEquals(actual, expected, message);
    }

    public static void softAssertNotNull(Object object, String message) {
        softAssert.assertNotNull(object, message);
    }

    public static void softAssertNull(Object object, String message) {
        softAssert.assertNull(object, message);
    }

    public static void assertAll() {
        softAssert.assertAll();
        softAssert = new SoftAssert(); // reset after execution
    }

    // =========================
    // SELENIUM WEBELEMENT ASSERTIONS
    // =========================

    public static void assertElementDisplayed(WebElement element, String message) {
        Assert.assertTrue(element.isDisplayed(), message);
    }

    public static void assertElementEnabled(WebElement element, String message) {
        Assert.assertTrue(element.isEnabled(), message);
    }

    public static void assertElementSelected(WebElement element, String message) {
        Assert.assertTrue(element.isSelected(), message);
    }

    public static void assertElementTextEquals(WebElement element, String expectedText, String message) {
        Assert.assertEquals(element.getText().trim(), expectedText, message);
    }

    public static void assertElementContainsText(WebElement element, String expectedText, String message) {
        Assert.assertTrue(
                element.getText().contains(expectedText),
                message + " | Actual text: " + element.getText()
        );
    }

    public static void assertElementAttributeEquals(
            WebElement element,
            String attribute,
            String expectedValue,
            String message
    ) {
        Assert.assertEquals(element.getAttribute(attribute), expectedValue, message);
    }

    // =========================
    // LIST ASSERTIONS
    // =========================

    public static <T> void assertListNotEmpty(List<T> list, String message) {
        Assert.assertTrue(list != null && !list.isEmpty(), message);
    }

    public static <T> void assertListSizeEquals(List<T> list, int expectedSize, String message) {
        Assert.assertEquals(list.size(), expectedSize, message);
    }

    public static <T> void assertListContains(List<T> list, T value, String message) {
        Assert.assertTrue(list.contains(value), message);
    }

    // =========================
    // CUCUMBER FRIENDLY ASSERTIONS
    // =========================

    public static void assertStep(boolean condition, String successMsg, String failureMsg) {
        if (!condition) {
            Assert.fail(failureMsg);
        }
        // success message will appear in report via step description
    }
}
