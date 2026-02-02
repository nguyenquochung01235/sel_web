package stepdefinitions;

import constants.ConfigFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AddUserPage;
import pages.Login;
import pages.Logout;
import utils.ConfigReader;
import utils.DriverManagement;

public class AddUserStepDef {
    WebDriver driver =  DriverManagement.getDriver();
    Login login = new Login();
    Logout logout = new Logout();
    AddUserPage addUserPage = new AddUserPage();

    @Given("user have login to OrangeHRM")
    public void userHaveLogin(){
        driver.get(ConfigReader.getSpecificProperty(ConfigFile.APP_CONFIG,"APP_URL"));
        login.inputUsername();
        login.inputPassword();
        login.clickLoginButton();
    }
    @When("user navigate to AddUserPage Page")
    public void navigateToAdminPage(){
        addUserPage.navigateToAdminPage();
    }
    @When("click button Add User")
    public void clickAddButton(){
        addUserPage.clickAddButton();
    }
    @When("user enter username as \"([^\"]*)\"$")
    public void enterUsername(String username){
        addUserPage.enterUsername(username);
    }
    @Then("verify username message as \"([^\"]*)\"$")
    public void verifyUsernameMessage(String expectedMessage){
        addUserPage.verifyUsernameMessage(expectedMessage);
    }
    @When("user click Save Button")
    public  void clickSaveButton(){
        addUserPage.clickButtonSave();
    }
    @When("user select User Role")
    public void selectUserRole(){
        addUserPage.selectUserRole();
    }
    @Then("verify user role message as \"([^\"]*)\"$")
    public void verifyUserRoleMessage(String expectedUserRoleMessage){
        addUserPage.verifyUserRoleMessage(expectedUserRoleMessage);
    }
    @When("user input employee name as \"([^\"]*)\"$")
    public void inputEmployeeName(String username){
        addUserPage.inputEmployeeName(username);
    }
    @Then("verify employee name message as \"([^\"]*)\"$")
    public void verifyEmployeeNameMessage(String expectedEmployeeNameMessage){
        addUserPage.verifyEmployeeNameMessage(expectedEmployeeNameMessage);
    }
    @When("User select status")
    public void selectStatus(){
        addUserPage.selectStatus();
    }
    @Then("verify status message as \"([^\"]*)\"$")
    public void verifyStatusMessage(String expectedStatus){
        addUserPage.verifyStatusMessage(expectedStatus);
    }
    @When("User input Password")
    public void inputPassword(){
        addUserPage.inputPasswordField();
    }
    @Then("verify password Message as \"([^\"]*)\"$")
    public void verifyPasswordMessage(String expectedPassword){
        addUserPage.verifyPasswordMessage(expectedPassword);
    }
    @When("User input confirm Password")
    public void inputConfirmPassword(){
        addUserPage.inputConfirmPasswordField();
    }
    @Then("verify Confirm Password Message as \"([^\"]*)\"$")
    public void verifyConfirmPasswordMessage(String expectedConfirmPassword){
        addUserPage.verifyConfirmPasswordMessage(expectedConfirmPassword);
    }
    @Then("User click Cancel Button")
    public  void clickCancelButton(){
        addUserPage.clickCancelButton();
    }
    @Then("User logout")
    public void logoutButton(){
        logout.clickButtonUser();
        logout.clickButtonLogout();
    }

}
