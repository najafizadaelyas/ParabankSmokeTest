package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import core.Base;
import pages.LoginPage;
import pages.RegisterPage;
import utilities.ExcelUtility;

@Listeners(utilities.TestNGListeners.class)
public class SmokeTest extends Base {
	
	LoginPage loginPage;
	RegisterPage registerPage;

	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");
	}

	@Test(dataProvider = "getInfoData")
	public void createAccount(String firstname, String lastname, String address, String city, String state, String zipcode, String phone, String ssn, String username, String password, String confirm) {
		registerPage = new RegisterPage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(registerPage.createAccountisPresent(), "Register Link is Present");
		registerPage.clickOnRegister();
		logger.info("User clicked on Register");
		softAssert.assertTrue(registerPage.registerFormisPresent(), "Register Form is Present");
		registerPage.fillPersonalInformation(firstname, lastname, address, city, state, zipcode, phone, ssn, username, password, confirm);
		logger.info("User entered personal information");
		softAssert.assertTrue(registerPage.registerButtonisPresent(), "Register Button is Present");
		logger.info("User created account");
		softAssert.assertAll();
	}
	
	@Test()
	public void loginAccount() {
		loginPage = new LoginPage();
	}

	@DataProvider()
	public Object[][] getInfoData() {
		Object data[][] = ExcelUtility.getExcelData("info");
		return data;
	}

	@AfterMethod
	public void afterMethod() {
		Base.tearDown();
		logger.info("Browser closed");
	}
}
