package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import manager.Driver;
import manager.DriverManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;

@CucumberOptions(
	features = "src/main/java/Features/lambda-test-selenium-scenarios.feature",
	glue = {"stepDefinitions"},
	plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public final class TestRunner extends AbstractTestNGCucumberTests {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpCucumber() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "version", "platform" })
	public void setUpClass(String browser, String version, String platform) throws Exception {

		RemoteWebDriver remoteWebdriver = null;

		String username = System.getenv("LT_USERNAME") == null ? "lakshminarayanapranavi" : System.getenv("LT_USERNAME");
		String accesskey = System.getenv("LT_ACCESS_KEY") == null ? "LT_qW3tNe5tibD71BD0PHg3s5Rd3JsYHCmMcWdu7sVCApqnlzh" : System.getenv("LT_ACCESS_KEY");

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability(CapabilityType.BROWSER_NAME, browser);
		capability.setCapability(CapabilityType.VERSION, version);
		capability.setCapability(CapabilityType.PLATFORM, platform);

		capability.setCapability("build", "Cucumber Sample Build");

		 capability.setCapability("network", true);
		 capability.setCapability("video", true);
		 capability.setCapability("console", true);
		 capability.setCapability("visual", true);

		String gridURL = "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub";
		System.out.println(gridURL);
		remoteWebdriver = new RemoteWebDriver(new URL(gridURL), capability);
		System.out.println(capability);
		Driver.initDriver(remoteWebdriver);
		System.out.println(DriverManager.getDriver().getSessionId());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}
}