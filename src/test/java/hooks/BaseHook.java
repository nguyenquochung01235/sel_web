package hooks;

import base.BaseDriver;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverManagement;
import utils.ExtentReportManagement;

public class BaseHook {

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = ExtentReportManagement.getExtentReports().createTest(scenario.getName());
        ExtentReportManagement.setTest(test);
        BaseDriver.initialize();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshot = ((TakesScreenshot) DriverManagement.getDriver())
                    .getScreenshotAs(OutputType.BASE64);
            ExtentReportManagement.getTest()
                    .fail("❌ Step failed")
                    .addScreenCaptureFromBase64String(screenshot, "Failed Screenshot");
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportManagement.getTest().fail("❌ Scenario failed");
        } else {
            ExtentReportManagement.getTest().pass("✅ Scenario passed");
        }
        DriverManagement.quitDriver();
        ExtentReportManagement.flush();
    }
}
