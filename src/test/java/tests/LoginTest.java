package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import core.Base;
import pages.LoginPage;
import utilities.DriverUtility;

public class LoginTest extends Base {

	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");

	}

	@Test()
	public void loginPage() {
		LoginPage loginPage = new LoginPage();
		loginPage.enterUsername(Base.getUserName());
		logger.info("user entered email address");
		loginPage.enterPassword(Base.getPassword());
		logger.info("user entered password");
		loginPage.clickLoginButton();
		logger.info("user clicked on sign in button");
		DriverUtility.wait(5000);
		DriverUtility.screenShot();

	}

	@Test(priority = 1)
	@Parameters({ "userName", "password" })
	public void loginWithParameters(String userName, String password) {
		LoginPage loginPage = new LoginPage();
		loginPage.enterUsername(userName);
		logger.info("user entered email address");
		loginPage.enterPassword(password);
		logger.info("user entered password");
		loginPage.clickLoginButton();
		logger.info("user clicked on sign in button");
		DriverUtility.wait(5000);
		DriverUtility.screenShot();
	}
	
	@AfterMethod
	public void afterMethod() {
		Base.tearDown();
		logger.info("Browser closed");
	}
}
