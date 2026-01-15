package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "@target/rerun.txt",
        glue = {"stepdefinitions", "hooks", },
        plugin = {"pretty", "summary","listeners.CucumberListener"},
        monochrome = true,
        dryRun = false
)
public class TestRerunFailCaseRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
