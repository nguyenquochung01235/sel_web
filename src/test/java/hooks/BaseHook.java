package hooks;

import base.BaseDriver;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import org.testng.annotations.BeforeSuite;
import utils.DriverManagement;
import utils.ExtentReportManagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseHook {
    @BeforeSuite
    public void beforeSuite() throws IOException {
        if (!System.getProperty("rerun").equals("true")){
            Files.deleteIfExists(Paths.get("target/rerun.txt"));
        }
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = ExtentReportManagement.getExtentReports().createTest(scenario.getName());
        ExtentReportManagement.setTest(test);
        BaseDriver.initialize();
    }


    @After
    public void afterScenario(Scenario scenario) {
        DriverManagement.quitDriver();
        ExtentReportManagement.flush();
    }
}
