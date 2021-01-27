package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.DriverUtility;

public class LoginPage extends Base {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(how = How.NAME, using = "username")
	private WebElement username;
	@FindBy(how = How.NAME, using = "password")
	private WebElement password;
	@FindBy(how = How.XPATH, using = "//input[@value='Log In']")
	private WebElement LoginButton;

	
	public void enterUsername(String emailID) {
		DriverUtility.enterText(username, emailID);
	}
	public void enterPassword(String passwordID) {
		DriverUtility.enterText(password, passwordID);
	}
	public void clickLoginButton() {
		LoginButton.click();
	}

	
}
