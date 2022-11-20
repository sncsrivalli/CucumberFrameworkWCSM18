package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerLoginTest {
	WebDriver driver;
	
	@Given("Launch Browser and enter URL")
	public void launch_browser_and_enter_url() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://localhost:8888/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("Enter valid credentials")
	public void enter_valid_credentials() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
	}

	@And("click on login")
	public void click_on_login() {
		driver.findElement(By.id("submitButton")).click();
	}

	@Then("home page should display")
	public void home_page_should_display() {
	    System.out.println(driver.getTitle());
	    driver.quit();
	}


}
