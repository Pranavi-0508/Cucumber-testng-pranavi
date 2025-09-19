package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

public class ToDoStepDefinition {

	public RemoteWebDriver driver = DriverManager.getDriver();

	@Given("^User Navigates to Selenium Playground URL$")
	public void User_Navigates_Selenium_Playground_URL() throws InterruptedException {
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}

	@When("^User Selects on Simple Form Demo$")
	public void user_selects_simple_form() {
		WebElement simpleform = driver.findElement(By.xpath("//a[text()='Simple Form Demo']"));
		simpleform.click();
	}

	@Then("^Validate the URL Contains Simple Form Demo Title$")
	public void user_validates_simple_form_demo_title() {
		String expectedTitle ="Selenium Grid Online | Run Selenium Test On Cloud";
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
		String input = driver.findElement(By.xpath("//p[@id='message']")).getText().trim();
		Assert.assertEquals("Expected message does not match","Welcome to LambdaTest",input);
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

	@When("^User Selects on Input Form Submit$")
	public void user_selects_input_form_submit(){
		WebElement inputform = driver.findElement(By.xpath("//a[text()='Input Form Submit']"));
		inputform.click();
	}

	@Then("^Click on Submit without filling any information in the form$")
	public void click_on_submit_input_form(){
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		submit.click();
	}

	@Then("^Check whether Error message is displayed or not$")
	public void check_whether_error_message_is_displayed_or_not(){
		WebElement name=driver.findElement(By.xpath("//input[@placeholder='Name']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", name);
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", name);

		System.out.println("Is field valid? " + isValid);
		System.out.println("Validation message: " + validationMessage);
	}

	@Then("^Fill All the fields and select United States from Country Dropdown$")
	public void fill_all_the_fields(){
		WebElement name=driver.findElement(By.xpath("//input[@placeholder='Name']"));
		name.sendKeys("Pranavi");
		WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email']"));
		email.sendKeys("lakshmi-narayana.pranavi@capgemini.com");
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("Nagamani@05");
		WebElement company =driver.findElement(By.xpath("//input[@placeholder='Company']"));
		company.sendKeys("Capgemini");
		WebElement website =driver.findElement(By.xpath("//input[@placeholder='Website']"));
		website.sendKeys("Capgemini");
		WebElement country =driver.findElement(By.xpath("//select[@name='country']"));
		Select countrydropdown=new Select(country);
		countrydropdown.selectByVisibleText("United States");
		WebElement city =driver.findElement(By.xpath("//input[@placeholder='City']"));
		city.sendKeys("Bangalore");
		WebElement address1 =driver.findElement(By.xpath("//input[@placeholder='Address 1']"));
		address1.sendKeys("Bangalore");
		WebElement address2 =driver.findElement(By.xpath("//input[@placeholder='Address 2']"));
		address2.sendKeys("Bangalore");
        WebElement state= driver.findElement(By.xpath("//input[@placeholder='State']"));
		state.sendKeys("Karnataka");
		WebElement zipcode= driver.findElement(By.xpath("//input[@placeholder='Zip code']"));
		zipcode.sendKeys("560036");
	}


	@And("Click on Submit")
	public void click_on_submit(){
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		submit.click();
	}
}