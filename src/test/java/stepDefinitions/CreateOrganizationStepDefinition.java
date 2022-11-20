package stepDefinitions;

import org.openqa.selenium.WebDriver;

import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertyFileUtility;
import genericLibraries.TabNames;
import genericLibraries.WebDriverUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomPages.CreateNewOrganizationPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import pomPages.NewOrganizationInfoPage;
import pomPages.OrganizationsPage;

public class CreateOrganizationStepDefinition {
	private WebDriverUtility webdriver;
	private JavaUtility javaUtility;
	private PropertyFileUtility property;
	private LoginPage login;
	private WebDriver driver;
	private HomePage home;
	private OrganizationsPage organizationPage;
	private CreateNewOrganizationPage createOrganization;
	private ExcelUtility excel;
	private NewOrganizationInfoPage organizationInfo;
	private String newOrganizationName;
	
	@Given("Open chrome browser and enter VtigerCRM url")
	public void open_chrome_browser_and_enter_vtiger_crm_url() {
		webdriver = new WebDriverUtility();
		javaUtility = new JavaUtility();
		
		property = new PropertyFileUtility();
		property.propertyFileInitialization(IConstantPath.PROPERTY_FILE_PATH);
		
		String browser = property.getDataFromPropertyFile("browser");
		String url = property.getDataFromPropertyFile("url");
		long time = Long.parseLong(property.getDataFromPropertyFile("timeouts"));
		
		driver = webdriver.openBrowserAndApplication(browser, url, time);
		
	}

	@Then("Vtiger Login page should display")
	public void vtiger_login_page_should_display() {
		login = new LoginPage(driver);
		if (login.getLogo().isDisplayed())
			System.out.println("Pass: Vtiger login page is diplayed");
		else
			System.out.println("Fail: Vtiger login page is not displayed");
	}

	@When("User enters username and password and clicks on login")
	public void user_enters_username_and_password_and_clicks_on_login() {
		String username = property.getDataFromPropertyFile("username");
		String password = property.getDataFromPropertyFile("password");
		login.loginToApplication(username, password);
	}

	@Then("Vtiger home page should display")
	public void vtiger_home_page_should_display() {
		home = new HomePage(driver);
		if (driver.getTitle().contains("Administrator"))
			System.out.println("Pass : Login successful");
		else
			System.out.println("Fail : Login not successful");
	}

	@When("User clicks on Organization tab")
	public void user_clicks_on_organization_tab() {
		home.clickRequiredTab(webdriver, TabNames.ORGANIZATIONS);
	}

	@Then("Organizations page should display")
	public void organizations_page_should_display() {
		organizationPage = new OrganizationsPage(driver);
		if (driver.getTitle().contains("Organizations"))
			System.out.println("Pass : Organizations page displayed");
		else
			System.out.println("Fail : Organizations page not displayed");

	}

	@When("User clicks plus button")
	public void user_clicks_plus_button() {
		organizationPage.clickPlusButton();
	}

	@Then("Creating New Organization page should display")
	public void creating_new_organization_page_should_display() {
		createOrganization = new CreateNewOrganizationPage(driver);
		if (createOrganization.getPageHeader().contains("Creating New Organization"))
			System.out.println("Pass : Creating new organization page is displayed");
		else
			System.out.println("Fail : Creating new organization page is not displayed");
		
	}

	@When("user enters organization name, industry type, hits group radio button and selects from assigned To dropdown and clicks on save button")
	public void user_enters_organization_name_industry_type_hits_group_radio_button_and_selects_from_assigned_to_dropdown_and_clicks_on_save_button() {
		excel = new ExcelUtility();
		excel.excelFileInitialization(IConstantPath.EXCEL_FILE_PATH);
		newOrganizationName = createOrganization.createOrganization(webdriver, excel, javaUtility);
	}

	@Then("New Organization Info page should display")
	public void new_organization_info_page_should_display() {
		organizationInfo = new NewOrganizationInfoPage(driver);
		if (organizationInfo.getPageHeader().contains(newOrganizationName))
			System.out.println("Pass : New organization created successfully");
		else
			System.out.println("Fail : Organization is not created");
	}

	@When("user clicks on Organizations link")
	public void user_clicks_on_organizations_link() {
		organizationInfo.clickOrganization();
	}

	@Then("Organizations page should display and Validate if new org is added to the list")
	public void organizations_page_should_display_and_validate_if_new_org_is_added_to_the_list() {
		if (organizationPage.getPageHeader().contains("Organizations"))
			System.out.println("Pass : Organizations page displayed");
		else
			System.out.println("Fail : Organizations page is not displayed");

				
		if (organizationPage.getNewOrganization().equalsIgnoreCase(newOrganizationName)) {
			System.out.println("Test Case Passed");
			excel.writeDataIntoExcel("TestData", "Pass", IConstantPath.EXCEL_FILE_PATH, "Create Organization");
		}
			
		else {
			System.out.println("Test Case Failed");
			excel.writeDataIntoExcel("TestData", "Fail", IConstantPath.EXCEL_FILE_PATH, "Create Organization");
		}
			
		home.mouseHoverToAdministratorImage(webdriver);
		home.clickRequiredTab(webdriver, TabNames.SIGNOUT);
				
		webdriver.closeBrowser();
		excel.closeExcel();
	}

}
