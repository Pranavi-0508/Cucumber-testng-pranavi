package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class ToDoStepDefinition {

	public RemoteWebDriver driver = DriverManager.getDriver();

	@Given("^User Navigates to Selenium Playground URL$")
	public void User_Navigates_Selenium_Playground_URL() throws InterruptedException {
		System.out.println(driver.getCapabilities());
		DriverManager.getDriver().get("https://www.lambdatest.com/selenium-playground/");
	}

	@When("^User Selects on Simple Form Demo$")
	public void user_selects_simple_form() {
		WebElement simpleform = driver.findElement(By.xpath("//a[text()='Simple Form Demo']"));
		simpleform.click();
	}

	@Then("^Validate the URL Contains Simple Form Demo Title$")
	public void user_validates_simple_form_demo_title() {
		String expectedTitle ="Simple Form Demo";
		String actualTitle =DriverManager.getDriver().getTitle();
		System.out.println("Expected Title: "+expectedTitle);
		System.out.println("Actual Title: "+actualTitle);
		Assert.assertEquals("Page title does not match",expectedTitle,actualTitle);

	}

	@Then("Enter the text {string} in the input box and click on Get CheckedValue")
	public void enter_text_in_input_box(String text){
		WebElement inputBox= driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']"));
		inputBox.sendKeys(text);
		driver.findElement(By.xpath("//button[text()='Get Checked Value']")).click();
	}

	@And("^Check whether the same text message is displayed in the right handle panel$")
	public void check_same_text_message_is_displayed() {
		String input = driver.findElement(By.xpath("//p[@id='message']")).getText();
		Assert.assertTrue(input.contains("Welcome to LambdaTest"),
				"Expected : Welcome to LambdaTest Actual : " + input);
	}

	@When("^User Selects on Drag & Drop Sliders$")
	public void user_selects_drag_and_drop_sliders() {
		WebElement draganddrop = driver.findElement(By.xpath("//a[text()='Drag & Drop Sliders']"));
		draganddrop.click();
	}

	@Then("^Select the slider Default value 15 and drag the bar to 95$")
	public void select_the_slider_and_drag_the_bar(){
		WebElement slider=driver.findElement(By.xpath("//input[@value='15']"));
		Actions actions= new Actions(driver);
		actions.dragAndDropBy(slider,212,0).build().perform();
	}

	@And("^Validate whether the range value shows 95$")
	public void validate_range_success_shows_95(){
		WebElement output=driver.findElement(By.xpath("//output[@id='rangeSuccess']"));
		Assert.assertEquals(output.getText(),"95");
	}
}