package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverManagement;
import utils.ElementHandler;

public class Login {
    WebDriver driver = DriverManagement.getDriver();
    ElementHandler elementHandler = new ElementHandler();

    public void clickLoginButton(){
        elementHandler.getElement(driver, By.xpath("//login")).click();
    }
}
