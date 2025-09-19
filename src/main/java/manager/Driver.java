package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Driver {
  private Driver() {
  }

  public static void initDriver() throws MalformedURLException {

    if (Objects.isNull(DriverManager.getDriver())) {
      ChromeOptions browserOptions = new ChromeOptions();
      browserOptions.setPlatformName("Windows 10");
      browserOptions.setBrowserVersion("119.0");
      HashMap<String, Object> ltOptions = new HashMap<String, Object>();
      ltOptions.put("username", "lakshminarayanapranavi");
      ltOptions.put("accessKey", "LT_qW3tNe5tibD71BD0PHg3s5Rd3JsYHCmMcWdu7sVCApqnlzh");
      ltOptions.put("build", "SeleniumBuild");
      ltOptions.put("project", "SeleniumBuild");
      ltOptions.put("w3c", true);
      browserOptions.setCapability("LT:Options", ltOptions);

      RemoteWebDriver driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
      DriverManager.setDriver(driver);
      DriverManager.getDriver().manage().window().maximize();
    }
  }

  public static void quitDriver() {
    if (Objects.nonNull(DriverManager.getDriver())) {
      DriverManager.getDriver().quit();
      DriverManager.unload();
    }
  }

}
