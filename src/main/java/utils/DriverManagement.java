package utils;

import org.openqa.selenium.WebDriver;

public class DriverManagement {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("Driver has not been initialized. Call setDriver() first.");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}