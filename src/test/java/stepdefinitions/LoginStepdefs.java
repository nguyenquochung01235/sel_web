package stepdefinitions;

import constants.ConfigFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.AssertHelper;
import utils.ConfigReader;
import utils.DriverManagement;
import utils.ExcelReader;

public class LoginStepdefs {
    WebDriver driver = DriverManagement.getDriver();
    LoginPage login = new LoginPage();
    HomePage homePage = new HomePage();
    @Given("user open browser and navigate to sauce demo")
    public void navigateToSauceDemo(){
        driver.get(ConfigReader.getSpecificProperty(ConfigFile.APP_CONFIG,"APP_URL"));
    }
    @When("user login using data provide in excel file \"([^\"]*)\"$")
    public void setLogin(String roleName){
        String filePath = "src/test/resources/file/Book1.xlsx";
        String sheetName= "LoginPage";

        String[] loginData = ExcelReader.getLoginData(filePath, sheetName, roleName);

        String username = loginData[0];
        String password = loginData[1];

        System.out.println("LoginPage with account: "+username+" "+password);

        login.loginPage(username,password);
    }
    @Then("verify login pass account")
    public void loginResultPass(){
        AssertHelper.softAssertEquals(homePage.getTitle(),"Swag Labs","HomePage title is true");
        AssertHelper.softAssertEquals(homePage.getHomePageURL(),"https://www.saucedemo.com/inventory.html", "HomePage URL is true");
    }
    @Then("verify login fail account \"([^\"]*)\"$")
    public void loginResultFail(String expectedMess){
        login.verifyLoginFail(expectedMess);
    }


}
