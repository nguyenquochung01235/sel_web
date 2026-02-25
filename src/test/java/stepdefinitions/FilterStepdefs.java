package stepdefinitions;

import constants.ConfigFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManagement;
import utils.ExcelReader;

public class FilterStepdefs {
    WebDriver driver = DriverManagement.getDriver();
    LoginPage login = new LoginPage();
    HomePage homePage = new HomePage();


    @Then("user click filter button")
    public void clickFilterButton(){
        homePage.clickButtonFilter();
    }
    @Then("user chose filter A-Z option")
    public void selectFilterAZOption(){
        homePage.selectAZOption();
    }
    @Then("verify A-Z Product List")
    public void verifyAZFilter(){
        homePage.getProductName();
        homePage.verifySortAzOption();
    }
    @Then("user chose filter Z-A option")
    public void selectFilterZAOption(){homePage.selectZAOption();}
    @Then("verify Z-A Product List")
    public void verifyZAFilter(){
        homePage.getProductName();
        homePage.verifySortZAOption();
    }
    @Then("user chose filter Low - High option")
    public void selectFilterLoHiOption(){homePage.selectLoHiOption();}
    @Then("verify Low to High Product Price")
    public void verifyLoHIFilter(){
        homePage.getProductName();
        homePage.verifySortLoHiOption();
    }
    @Then("user chose filter High-Low option")
    public void selectFilterHiLoOption(){homePage.selectHiLoOption();}
    @Then("verify High to Low Product Price")
    public void verifyHiLoFilter(){
        homePage.getProductName();
        homePage.verifySortHiLoOption();
    }


}
