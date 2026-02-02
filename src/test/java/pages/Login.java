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
       // AssertHelper.assertTrue(false, loginLocator);
        elementHandler.getElement(driver,loginLocator,60).click();
    }
    public void inputUsername(){
        String username = "Admin";
        String inputUsernameLocator = ConfigReader.getSpecificTestProperty(LOGIN_PAGE_PROPERTIES,"input_username_locator");
        elementHandler.getElement(driver,inputUsernameLocator,60).sendKeys(username);
    }
    public void inputPassword(){
        String password = "admin123";
        String inputPasswordLocator = ConfigReader.getSpecificTestProperty(LOGIN_PAGE_PROPERTIES,"input_password_locator");
        elementHandler.getElement(driver,inputPasswordLocator,60).sendKeys(password);
    }
}
