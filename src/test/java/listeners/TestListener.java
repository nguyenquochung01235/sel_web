package listeners;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverManagement;
import utils.ExtentReportManagement;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentReportManagement.getExtentReports().createTest(result.getMethod().getMethodName());
        ExtentReportManagement.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManagement.getTest().pass("✅ Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentReportManagement.getTest();
        test.fail("❌ Failed: " + result.getThrowable());

        try {
            String screenshot = ((TakesScreenshot) DriverManagement.getDriver())
                    .getScreenshotAs(OutputType.BASE64);
            test.addScreenCaptureFromBase64String(screenshot, "Failed Screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManagement.flush();
    }
}