package hooks;

import base.BaseDriver;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import utils.DriverManagement;
import utils.ExtentReportManagement;

public class BaseHook {

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
