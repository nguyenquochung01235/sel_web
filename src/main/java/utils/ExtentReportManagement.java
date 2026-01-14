package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.LocalDateTime;

public class ExtentReportManagement {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> stepNode = new ThreadLocal<>();

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("report/Automation-Report_"+LocalDateTime.now().toString()+".html");
            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("UI Automation Results");
            spark.viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[] {
                            ViewName.DASHBOARD,
                            ViewName.TEST,
                            ViewName.CATEGORY,
                            ViewName.DEVICE,
                            ViewName.AUTHOR
                    })
                    .apply();
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Framework", "Cucumber + TestNG");
        }
        return extent;
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
    public static void setStep(ExtentTest step) {
        stepNode.set(step);
    }

    public static ExtentTest getStep() {
        return stepNode.get();
    }

    public static void pass(String message){
        getStep().pass(message);
    }

    public static void fail(String message){
        String screenshot = ((TakesScreenshot) DriverManagement.getDriver())
                .getScreenshotAs(OutputType.BASE64);

        getStep().fail(message,
                MediaEntityBuilder
                        .createScreenCaptureFromBase64String(screenshot)
                        .build());
    }

    public static void info(String message){
        getStep().info(message);
    }

    public static void skip(String message){
        getStep().skip(message);
    }


}
