package stepdefinitions;

import constants.ConfigFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Login;
import utils.ConfigReader;
import utils.DriverManagement;
import utils.ExtentReportManagement;

public class MyStepdefs {
    WebDriver driver = DriverManagement.getDriver();
    Login login = new Login();

    @Given("user open browser")
    public void userOpenBrowser()  {
        driver.manage().window().maximize();
        ExtentReportManagement.pass("step 1");
    }

    @When("navigate to google.com")
    public void navigateToGoogleCom() {
        driver.get(ConfigReader.getSpecificProperty(ConfigFile.APP_CONFIG,"APP_URL"));
        login.clickLoginButton();
    }

    @Then("close browser")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);

    }

    @When("navigate to example.com")
    public void navigateToExampleCom() throws InterruptedException {
        driver.get("https://www.example.com");
        ExtentReportManagement.getStep().pass("Navigate to web successfully");
        Thread.sleep(1000);
        throw new RuntimeException("Login button not found");

    }
}
