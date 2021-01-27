package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.DriverUtility;

public class RegisterPage extends Base {

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Register']")
	private WebElement regisTer;

	@FindBy(how = How.ID, using = "customer.firstName")
	private WebElement firstName;

	@FindBy(how = How.ID, using = "customer.lastName")
	private WebElement lastName;

	@FindBy(how = How.ID, using = "customer.address.street")
	private WebElement addRess;

	@FindBy(how = How.ID, using = "customer.address.city")
	private WebElement ciTy;

	@FindBy(how = How.ID, using = "customer.address.state")
	private WebElement sTate;

	@FindBy(how = How.ID, using = "customer.address.zipCode")
	private WebElement zipCode;

	@FindBy(how = How.ID, using = "customer.phoneNumber")
	private WebElement phoNe;

	@FindBy(how = How.ID, using = "customer.ssn")
	private WebElement ssnNo;

	@FindBy(how = How.ID, using = "customer.username")
	private WebElement userName;

	@FindBy(how = How.ID, using = "customer.password")
	private WebElement passWord;
	
	@FindBy(how = How.ID, using = "repeatedPassword")
	private WebElement conFirm;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Register']")
	private WebElement registerButton;

	@FindBy(how = How.XPATH, using = "//table[@class='form2']")
	private WebElement foRm;
	
	public void clickOnRegister() {
		regisTer.click();
	}

	public void fillPersonalInformation(String firstname, String lastname, String address, String city, String state, String zipcode, String phone, String ssn, String username, String password, String confirm) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		addRess.sendKeys(address);
		ciTy.sendKeys(city);
		sTate.sendKeys(state);
		zipCode.sendKeys(zipcode);
		phoNe.sendKeys(phone);
		ssnNo.sendKeys(ssn);
		userName.sendKeys(username);
		passWord.sendKeys(password);
		conFirm.sendKeys(confirm);
	}
	
	public void registerAccount() {
		registerButton.click();
	}
	
	public boolean createAccountisPresent() {
		 boolean createAnAccountPresent = DriverUtility.isElementDisplayed(regisTer);
		  return createAnAccountPresent;
	}
	
	public boolean registerFormisPresent() {
		 boolean mrsTitlePresent = DriverUtility.isElementDisplayed(foRm);
		  return mrsTitlePresent;
	}

	public boolean registerButtonisPresent() {
		 boolean registerButtonPresent = DriverUtility.isElementDisplayed(registerButton);
		  return registerButtonPresent;
	}
	
	
	
	
}
