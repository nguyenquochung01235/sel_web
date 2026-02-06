package pages;

import org.openqa.selenium.WebDriver;
import pages.properties.TestProperties;
import utils.*;


public class Login {
    WebDriver driver = DriverManagement.getDriver();
    ElementHandler elementHandler = new ElementHandler();
    private static final String LOGIN_PAGE_PROPERTIES = TestProperties.LOGIN_PAGE.getTestPropertiesFileName();

    public void loginPage(String username, String password){

        String loginLocator = ConfigReader.getSpecificTestProperty(LOGIN_PAGE_PROPERTIES, "login_button");
        String usernameLocator = ConfigReader.getSpecificTestProperty(LOGIN_PAGE_PROPERTIES,"username_input");
        String passwordLocator = ConfigReader.getSpecificTestProperty(LOGIN_PAGE_PROPERTIES,"password_input");
        elementHandler.getElement(driver,usernameLocator,60).clear();
        elementHandler.getElement(driver,usernameLocator,60).sendKeys(username);
        elementHandler.getElement(driver,passwordLocator,60).clear();
        elementHandler.getElement(driver,passwordLocator,60).sendKeys(password);
        elementHandler.getElement(driver,loginLocator,60).click();
    }
    public void verifyLoginFail(String expectedMessage){
        String errorMessage;
        String errorMessageLoc = ConfigReader.getSpecificTestProperty(LOGIN_PAGE_PROPERTIES,"error_message");
        String errorButton = ConfigReader.getSpecificTestProperty(LOGIN_PAGE_PROPERTIES,"error_button");
        String errorUsername = ConfigReader.getSpecificTestProperty(LOGIN_PAGE_PROPERTIES,"error_icon_username");
        String errorPassword = ConfigReader.getSpecificTestProperty(LOGIN_PAGE_PROPERTIES,"error_icon_password");
        elementHandler.getElement(driver,errorMessageLoc,60).isDisplayed();
        errorMessage = elementHandler.getElement(driver, errorMessageLoc, 60).getText();
        elementHandler.getElement(driver,errorButton,60).isDisplayed();
        elementHandler.getElement(driver,errorUsername,60).isDisplayed();
        elementHandler.getElement(driver,errorPassword,60).isDisplayed();
        AssertHelper.softAssertEquals(errorMessage,expectedMessage,"Verify error message");
    }

}
