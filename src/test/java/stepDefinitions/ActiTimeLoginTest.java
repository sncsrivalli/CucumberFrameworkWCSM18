package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiTimeLoginTest {
	WebDriver driver;
	
	@Given("Open Browser and enter Actitime URL")
	public void open_browser_and_enter_actitime_url() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://demo.actitime.com/login.do");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("^User enters (.*) and (.*) and clicks login$")
	public void user_enters_username_and_password_and_clicks_login(String username, String password) {
	   driver.findElement(By.id("username")).sendKeys(username);
	   driver.findElement(By.name("pwd")).sendKeys(password);
	   driver.findElement(By.id("loginButton")).click();
	}

	@Then("^Home page should display with (.*)$")
	public void home_page_should_display_with_status(String status) {
		System.out.println(status);
		driver.quit();
	}
	    


}
