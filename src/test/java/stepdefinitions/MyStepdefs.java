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
    Login login = new Login();

    @Given("user open browser")
    public void userOpenBrowser() throws InterruptedException {
        Thread.sleep(5000);
    }

    @When("navigate to google.com")
    public void navigateToGoogleCom() {
        driver.get("https://www.google.com");
        login.clickLoginButton();
    }

    @Then("close browser")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);

    }

    @When("navigate to example.com")
    public void navigateToExampleCom() throws InterruptedException {
        driver.get("https://www.example.com");
        Thread.sleep(1000);
        throw new RuntimeException("Login button not found");

    }
}
