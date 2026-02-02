package pages;

import org.openqa.selenium.WebDriver;
import pages.properties.TestProperties;
import utils.ConfigReader;
import utils.DriverManagement;
import utils.ElementHandler;

public class Logout {
    WebDriver driver = DriverManagement.getDriver();
    ElementHandler elementHandler = new ElementHandler();
    private static final String LOGOUT_PAGE_PROPERTIES = TestProperties.LOGOUT_PAGE.getTestPropertiesFileName();

    public void clickButtonUser(){
        String userButtonLocator = ConfigReader.getSpecificTestProperty(LOGOUT_PAGE_PROPERTIES,"user_button_locator");
        elementHandler.getElement(driver,userButtonLocator,60).click();
    }
    public void clickButtonLogout(){
        String logoutButtonLocator = ConfigReader.getSpecificTestProperty(LOGOUT_PAGE_PROPERTIES,"logout_button_locaotr");
        elementHandler.getElement(driver,logoutButtonLocator,60).click();
    }
}
