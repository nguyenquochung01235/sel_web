package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.properties.TestProperties;
import utils.ConfigReader;
import utils.DriverManagement;
import utils.ElementHandler;
import utils.AssertHelper;

public class AddUserPage {
    WebDriver driver = DriverManagement.getDriver();
    ElementHandler elementHandler = new ElementHandler();
    private static final String ADMIN_PAGE_PROPERTIES = TestProperties.ADMIN_PAGE.getTestPropertiesFileName();


    public void navigateToAdminPage(){
        String adminButtonLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"admin_button_locator");
        elementHandler.getElement(driver,adminButtonLocator,60).click();
    }
    public void clickAddButton(){
        String addUserButtonLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"admin_addUser_button_locator");
        elementHandler.getElement(driver,addUserButtonLocator,60).click();
    }
    public void enterUsername(String username){
        String usernameInputLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"username_input_locator");
        elementHandler.getElement(driver,usernameInputLocator,60).sendKeys(username);
    }
    public void clickButtonSave(){
        String saveButtonLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"save_button_locator");
        elementHandler.getElement(driver,saveButtonLocator,60).click();
    }
    public void verifyUsernameMessage(String expectedMessage){
        String usernameMessageLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"username_input_message_locator");
        String usernameMes =  elementHandler.getElement(driver,usernameMessageLocator,60).getText();
        AssertHelper.assertEquals(usernameMes,expectedMessage,"Username is mandatory field");
        AssertHelper.assertAll();
    }
    public void selectUserRole(){
        String userRoleListLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"userRole_list_locator");
        String essRoleLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"dropdown_ESS_role_locator");
        elementHandler.getElement(driver, userRoleListLocator,60).click();
        elementHandler.getElement(driver,essRoleLocator,60).click();
    }
    public void verifyUserRoleMessage(String expectedUserRoleMessage){
        String userRoleMessageLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"userRole_dropdown_message_locator");
        String userRoleMes = elementHandler.getElement(driver,userRoleMessageLocator,60).getText();
        AssertHelper.assertEquals(userRoleMes,expectedUserRoleMessage,"User Role is mandatory field");
        AssertHelper.assertAll();
    }
    public void inputEmployeeName(String username){
        String employeeNameLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"employee_name_locator");
        String dropDownEmployeeLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"dropdown_EmployeeName_locator");
        elementHandler.getElement(driver,employeeNameLocator,60).sendKeys(username);
        elementHandler.getElement(driver,dropDownEmployeeLocator,60).click();
    }
    public void verifyEmployeeNameMessage(String expectedEmployeeNameMessage){
        String employeeNameMessageLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"employeeName_input_message_locator");
        String employeeNameMess = elementHandler.getElement(driver,employeeNameMessageLocator,60).getText();
        AssertHelper.assertEquals(employeeNameMess,expectedEmployeeNameMessage,"Employee Name is mandatory field");
        AssertHelper.assertAll();
    }
    public void selectStatus(){
        String statusLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"dropdown_Enable_locator");
        String userStatusListLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"userStatus_list_locator");
        elementHandler.getElement(driver,userStatusListLocator,60).click();
        elementHandler.getElement(driver,statusLocator,60).click();
    }
    public void verifyStatusMessage(String expectedStatusMessage){
        String statusMessageLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"status_dropdown_message_locator");
        String statusMess = elementHandler.getElement(driver,statusMessageLocator,60).getText();
        AssertHelper.assertEquals(statusMess,expectedStatusMessage,"Status is mandatory field");
        AssertHelper.assertAll();
    }
    public void inputPasswordField(){
        String inputPasswordLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"password_input_locator");
        elementHandler.getElement(driver,inputPasswordLocator,60).sendKeys("Matkhaumoi123@4");
    }
    public void verifyPasswordMessage(String expectedPasswordMessage){
        String passwordMessageLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"password_input_message_locator");
        String passwordMes = elementHandler.getElement(driver,passwordMessageLocator,60).getText();
        AssertHelper.assertEquals(passwordMes,expectedPasswordMessage,"Password is mandatory field");
        AssertHelper.assertAll();
    }
    public void inputConfirmPasswordField(){
        String inputConfirmPasswordLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"confirmPassword_input_locator");
        elementHandler.getElement(driver,inputConfirmPasswordLocator,60).sendKeys("Matkhaumoi123@4");
    }
    public void verifyConfirmPasswordMessage(String expectedConfirmPasswordMessage){
        String confirmPasswordMessageLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"confirm_password_message_locator");
        String confirmPasswordMes = elementHandler.getElement(driver,confirmPasswordMessageLocator,60).getText();
        AssertHelper.assertEquals(confirmPasswordMes,expectedConfirmPasswordMessage,"Confirm Password is mandatory field");
        AssertHelper.assertAll();
    }
    public void clickCancelButton(){
            String cancelButtonLocator = ConfigReader.getSpecificTestProperty(ADMIN_PAGE_PROPERTIES,"cancel_button_locator");
            elementHandler.getElement(driver,cancelButtonLocator,60).click();
    }
}
