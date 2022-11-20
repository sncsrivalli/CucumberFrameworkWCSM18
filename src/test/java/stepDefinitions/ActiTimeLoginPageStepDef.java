package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomPages.ActiTimeLoginPage;

public class ActiTimeLoginPageStepDef {
	
	ActiTimeLoginPage loginPage;
	WebDriver driver;
	
	@Given("User opens browser")
	public void user_opens_browser() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   loginPage = new ActiTimeLoginPage(driver);
	}

	@When("enters URL - actitime.com")
	public void enters_url_actitime_com() {
	   driver.get("https://demo.actitime.com/login.do");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Then("I validate Login page")
	public void i_validate_login_page() {
	 if(loginPage.getLogo().isDisplayed())
		 System.out.println("Pass");
	 else
		 System.out.println("Fail");
	}
}
