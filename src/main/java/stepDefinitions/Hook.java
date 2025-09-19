package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import manager.Driver;
import manager.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class Hook {

    @Before
    public void setUp(Scenario scenario) throws InterruptedException, MalformedURLException {
        System.out.println("Starting scenario:"+scenario.getName());
        Driver.initDriver();
    }

    @After
    public void close_the_browser(Scenario scenario) throws InterruptedException {
        System.out.println("Ending scenario:"+scenario.getName());
        Driver.quitDriver();
    }

}