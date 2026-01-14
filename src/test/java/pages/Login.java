package pages;

import org.openqa.selenium.WebDriver;
import pages.properties.TestProperties;
import utils.AssertHelper;
import utils.ConfigReader;
import utils.DriverManagement;
import utils.ElementHandler;

public class Login {
    WebDriver driver = DriverManagement.getDriver();
    ElementHandler elementHandler = new ElementHandler();
    private static final String LOGIN_PAGE_PROPERTIES = TestProperties.LOGIN_PAGE.getTestPropertiesFileName();

    public void clickLoginButton(){
        String loginLocator = ConfigReader.getSpecificTestProperty(LOGIN_PAGE_PROPERTIES, "login_button_locator");
//        elementHandler.getElement(driver,loginLocator,5);
        AssertHelper.assertTrue(false, loginLocator);

    }
}
