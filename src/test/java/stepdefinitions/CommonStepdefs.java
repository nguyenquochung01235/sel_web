package stepdefinitions;

import constants.ConfigFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Login;
import pages.Logout;
import utils.ConfigReader;
import utils.DriverManagement;

public class CommonStepdefs {
    WebDriver driver =  DriverManagement.getDriver();
    Login login = new Login();
    Logout logout = new Logout();

    @Given("user open browser")
    public  void loginPage(){
        driver.get(ConfigReader.getSpecificProperty(ConfigFile.APP_CONFIG,"APP_URL"));
        //login.clickLoginButton();
    }
    @When("user input username and password")
        public void inputUsernamePassword(){
            login.inputUsername();
            login.inputPassword();
        }
    @Then("user click button Login")
        public void clickButtonUsername(){
        login.clickLoginButton();
    }

    @Given("user click user button")
    public void clickUserButton(){
        logout.clickButtonUser();
    }
    @Then("user click logout button")
    public void clickLogoutButton(){
        logout.clickButtonLogout();
    }

}
