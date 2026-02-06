package pages;

import org.openqa.selenium.WebDriver;
import pages.properties.TestProperties;
import utils.ConfigReader;
import utils.DriverManagement;
import utils.ElementHandler;

public class HomePage {
    WebDriver driver = DriverManagement.getDriver();
    ElementHandler elementHandler = new ElementHandler();
    private static final String HOME_PAGE_PROPERTIES = TestProperties.HOME_PAGE.getTestPropertiesFileName();
    public String getTitle(){
        String titleLogo = ConfigReader.getSpecificTestProperty(HOME_PAGE_PROPERTIES,"home_page_logo");
        return elementHandler.getElement(driver,titleLogo,60).getText();
    }
    public String getHomePageURL(){
        return driver.getCurrentUrl();
    }

}
