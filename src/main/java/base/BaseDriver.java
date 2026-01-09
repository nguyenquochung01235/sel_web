package base;

import constants.ConfigFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.ConfigReader;
import utils.DriverManagement;

import java.util.List;

public class BaseDriver {

    private static final String CHROME = "chrome";
    private static final String EDGE = "edge";


    public static void initialize() {
        WebDriver driver;
        String browser = ConfigReader.getSpecificProperty(ConfigFile.TEST_CONFIG, "browser.type");
        List<String> browserConfig = ConfigReader.getArrayProperty(ConfigFile.TEST_CONFIG, "browser.properties", ";");

        switch (browser) {
            case CHROME :
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(browserConfig);
                driver = new ChromeDriver(chromeOptions);
                break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(browserConfig);
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        DriverManagement.setDriver(driver);
        driver.manage().window().maximize();
    }


}
