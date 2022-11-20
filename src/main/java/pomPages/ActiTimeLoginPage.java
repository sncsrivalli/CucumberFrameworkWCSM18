package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeLoginPage {
	
	@FindBy(xpath = "//div[@class = 'atLogoImg']") private WebElement logo;
	@FindBy(name="username") private WebElement usernameTextField;
	@FindBy(name = "pwd") private WebElement passwordTextField;
	@FindBy(id = "loginButton") private WebElement loginButton;
	
	public ActiTimeLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogo() {
		return logo;
	}
	
	public void loginToActiTime(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
}
