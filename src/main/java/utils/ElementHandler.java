package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementHandler {
    private static final int TIME_OUT = 60;
    private static final int POLLING = 2;

    public WebElement getElement(WebDriver driver, String locator, int timeout){
        try{
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofSeconds(POLLING))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        }catch (Exception e){
            throw new TimeoutException("Element not visible after " + timeout + "s. Locator: " + locator + "</br>" + e.getMessage());
        }
    }

    public WebElement getElement(WebDriver driver, String locator){
        return getElement(driver,locator,TIME_OUT);
    }

    public List<WebElement> getElements(WebDriver driver, String locator, int timeout){
        try{
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofSeconds(POLLING))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class);
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
        }catch (Exception e){
            ExtentReportManagement.info("Can not found any element after " + timeout + "s. Locator: " + locator);
            return null;
        }
    }

    public List<WebElement> getElements(WebDriver driver, String locator){
        return getElements(driver,locator,TIME_OUT);
    }

    public void waitUntilElementIsVisible(WebDriver driver, String locator, int timeout){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitUntilElementIsInvisibility(WebDriver driver, String locator, int timeout){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitUntilElementIsEnable(WebDriver driver, String locator, int timeout){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void waitUntilElementIsDisabled(WebDriver driver, String locator, int timeout){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            wait.until(d -> !element.isEnabled());
    }

}
