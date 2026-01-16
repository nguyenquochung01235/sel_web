package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Login;
import utils.DriverManagement;
import utils.ExtentReportManagement;

public class MyStepdefs {
    WebDriver driver = DriverManagement.getDriver();

    @Given("user open browser")
    public void userOpenBrowser()  {
        driver.manage().window().maximize();
    }

    @When("navigate to google.com")
    public void navigateToGoogleCom() {
    }

    @Then("close browser")
    public void closeBrowser() throws InterruptedException {
    }

    @When("navigate to example.com")
    public void navigateToExampleCom() {

    }

    @When("navigate to fail google.com")
    public void navigateToFailGoogleCom() {
        throw new RuntimeException("Fail at this step");
    }
}
