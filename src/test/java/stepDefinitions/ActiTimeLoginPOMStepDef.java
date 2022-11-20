package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.ActiTimeLoginPage;

public class ActiTimeLoginPOMStepDef {

	ActiTimeLoginPage loginPage;
	WebDriver driver;
	
	@Given("Launch Browser and enter Actitime URL")
	public void launch_browser_and_enter_actitime_url() {
		 WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   loginPage = new ActiTimeLoginPage(driver);
		   driver.get("https://demo.actitime.com/login.do");
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("^enter (.*) and (.*) and click login$")
	public void enter_username_and_password_and_click_login(String username, String password) {
	    loginPage.loginToActiTime(username, password);
	}

	@Then("^Home page is display with (.*)$")
	public void home_page_is_display_with_status(String status) {
		System.out.println(driver.getTitle() + " "+ status);
	   
	}

	
}
