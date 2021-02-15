package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"seleniumgluecode"},
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:src/test/output/reports/report.html"},
        snippets = SnippetType.CAMELCASE
)

public class TestRunner {
}
