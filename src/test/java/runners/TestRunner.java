package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/filter.feature",//"src/test/resources/features",
        glue = {"stepdefinitions", "hooks", },
        plugin = {"pretty", "summary", "rerun:target/rerun.txt","listeners.CucumberListener"},
        monochrome = true,
        dryRun = false
        //tags = "@test-filter"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
