package listeners;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverManagement;
import utils.ExtentReportManagement;

public class CucumberListener implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepStarted.class, this::onStepStarted);
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::onStepFinished);
    }

    private void onStepStarted(TestStepStarted event){
        if (event.getTestStep() instanceof PickleStepTestStep) {

            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();

            String stepText = step.getStep().getKeyword() + step.getStep().getText();

            ExtentTest stepNode = ExtentReportManagement.getTest().createNode(stepText);

            ExtentReportManagement.setStep(stepNode);

        }
    }

    private void onStepFinished(TestStepFinished event) {

        if (event.getTestStep() instanceof PickleStepTestStep) {
            Status status = event.getResult().getStatus();
            ExtentTest stepNode = ExtentReportManagement.getStep();

            switch (status) {
                case PASSED:
                    stepNode.pass("Step passed");
                    break;

                case FAILED:
                    String screenshot = ((TakesScreenshot) DriverManagement.getDriver())
                            .getScreenshotAs(OutputType.BASE64);

                    String errorMessage = event.getResult().getError().getMessage();

                    stepNode.fail(errorMessage,
                            MediaEntityBuilder
                                    .createScreenCaptureFromBase64String(screenshot)
                                    .build());
                    break;

                case SKIPPED:
                    stepNode.skip("Step skipped");
                    break;

                default:
                    break;
            }
        }
    }

}
