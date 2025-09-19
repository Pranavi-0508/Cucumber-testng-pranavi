package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/main/java/Features/lambda-test-selenium-scenarios.feature",
        glue = {"src/main/stepDefinitions"},
        plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public final class Testrunner extends AbstractTestNGCucumberTests {

}
