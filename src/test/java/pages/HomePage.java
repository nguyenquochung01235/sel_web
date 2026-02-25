package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.properties.TestProperties;
import utils.AssertHelper;
import utils.ConfigReader;
import utils.DriverManagement;
import utils.ElementHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public void clickButtonFilter(){
        String filterButton = ConfigReader.getSpecificTestProperty(HOME_PAGE_PROPERTIES,"filter_button");
        elementHandler.getElement(driver,filterButton,60).click();
    }
    public void selectAZOption(){
        String azValue = ConfigReader.getSpecificTestProperty(HOME_PAGE_PROPERTIES,"option_value_az");
        elementHandler.getElement(driver,azValue,60).click();
    }
    public void selectZAOption(){
        String zaValue = ConfigReader.getSpecificTestProperty(HOME_PAGE_PROPERTIES,"option_value_za");
        elementHandler.getElement(driver,zaValue,60).click();
    }
    public void selectLoHiOption(){
        String lohiValue = ConfigReader.getSpecificTestProperty(HOME_PAGE_PROPERTIES,"option_value_lohi");
        elementHandler.getElement(driver,lohiValue,60).click();
    }
    public void selectHiLoOption(){
        String hiloValue = ConfigReader.getSpecificTestProperty(HOME_PAGE_PROPERTIES,"option_value_hilo");
        elementHandler.getElement(driver,hiloValue,60).click();
    }
    public List<String> getProductName(){
        String inventoryList = ConfigReader.getSpecificTestProperty(HOME_PAGE_PROPERTIES,"inventory_list");
        int numberOfProduct = elementHandler.getElements(driver,inventoryList,60).size();
        List <String> getActualList = new ArrayList<>();
        for (int i = 1; i<=numberOfProduct; i++){
            String productNameList = ConfigReader.getSpecificTestProperty(HOME_PAGE_PROPERTIES,"product_name_list");
            List<WebElement> elements = elementHandler.getElements(driver, productNameList.replace("<index>",String.valueOf(i)), 60);
            for (WebElement el : elements) {
                getActualList.add(el.getText().trim());
            }

        }

        return getActualList;
    }
    public List<Float> getProductPrice(){
        String inventoryList = ConfigReader.getSpecificTestProperty(HOME_PAGE_PROPERTIES,"inventory_list");
        int numberOfProduct = elementHandler.getElements(driver,inventoryList,60).size();
        List <Float> getActualList = new ArrayList<>();
        for (int i = 1; i<=numberOfProduct; i++){
            String productPriceList = ConfigReader.getSpecificTestProperty(HOME_PAGE_PROPERTIES,"product_price_list");
            List<WebElement> elements = elementHandler.getElements(driver, productPriceList.replace("<index>",String.valueOf(i)), 60);
            for (WebElement el : elements) {
                getActualList.add(Float.valueOf(el.getText().trim().replace("$","")));
            }

        }

        return getActualList;
    }

    public void verifySortAzOption(){
        List<String> actualList = getProductName();
        //create a copy
        List<String> expectedList = new ArrayList<>(actualList);
        Collections.sort(expectedList);
        AssertHelper.assertEquals(actualList.size(),expectedList.size(),"The Size must be equal");
        for(int i=0; i<expectedList.size();i++) {
            AssertHelper.assertEquals(actualList.get(i), expectedList.get(i), "The List must be sort A-Z");
        }
        System.out.println(actualList);
        System.out.println(expectedList);
    }
    public void verifySortZAOption(){
        List<String> actualList = getProductName();
        //create a copy
        List<String> expectedList = new ArrayList<>(actualList);
        Collections.sort(expectedList,Collections.reverseOrder());
        AssertHelper.assertEquals(actualList.size(),expectedList.size(),"The size must be equal");
        for(int i=0; i<expectedList.size();i++) {
            AssertHelper.assertEquals(actualList, expectedList, "The List must be sort A-Z");
        }
        System.out.println(actualList);
        System.out.println(expectedList);
    }
    public void verifySortLoHiOption(){
        List<Float> actualList = getProductPrice();
        //create a copy
        List<Float> expectedList = new ArrayList<>(actualList);
        Collections.sort(expectedList);
        AssertHelper.assertEquals(actualList.size(),expectedList.size(),"The Size must be Equal");
        for (int i=0;i<expectedList.size();i++) {
            AssertHelper.assertEquals(actualList, expectedList, "The List must be sort Low to High");
        }
        System.out.println(actualList);
        System.out.println(expectedList);
    }
    public void verifySortHiLoOption(){
        List<Float> actualList = getProductPrice();
        //create a copy
        List<Float> expectedList = new ArrayList<>(actualList);
        Collections.sort(expectedList,Collections.reverseOrder());
        AssertHelper.assertEquals(actualList.size(),expectedList.size(),"The Size must be Equal");
        for(int i=0;i<expectedList.size();i++) {
            AssertHelper.assertEquals(actualList, expectedList, "The List must be sort High to Low");
        }
        System.out.println(actualList);
        System.out.println(expectedList);
    }
}
