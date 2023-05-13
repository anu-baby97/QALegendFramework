package com.qalegend.qa.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qalegend.qa.base.TestBase;
import com.qalegend.qa.pages.LoginPage;
import com.qalegend.qa.util.GenericUtility;

public class LoginPageTestCases extends TestBase{

	LoginPage lp;
	public Logger logger ;
	
	
	
	public LoginPageTestCases() {
		super();
	}
	
	GenericUtility gUtility = new GenericUtility();
	
	@BeforeMethod(groups = {"Regression"})
	@Parameters("browser")
	public void setUp(String browserName) {
		logger=LogManager.getLogger(this.getClass());
		initialization(browserName);
		lp= new LoginPage();
	}
	
	@Test(priority = 1,groups = {"Regression"})
	public void loginWithValidDetails() {
		logger.info("Starting login...");
		logger.info("Entering the user name and password");
		String url = lp.validCredentials(prop.getProperty("username"), prop.getProperty("password"));
		
		lp.redirectPage();
		Assert.assertEquals("https://qalegend.com/billing/public/home", url,"The page is not redirected to Home page for valid credentials");
	}
	
	@Test(priority = 2,groups = {"Regression","Sanity"})
	public void loginWithInvalidDetails() {
		String url = lp.invalidCredentials(gUtility.randomeString(), gUtility.randomAlphaNumeric());
		Assert.assertEquals("https://qalegend.com/billing/public/", url,"The page is redirected to Home page for invalid credentials");
	}
	
	@Test(priority = 3,groups = {"Regression"})
	public void forgotPasswordWithValidEmail() {
		Boolean success_msg = lp.validEmail(prop.getProperty("email"));
		Assert.assertTrue(success_msg,"Success Message is not displayed");
	}
	
	@Test(priority = 4,groups = {"Regression","Sanity"})
	public void forgotPasswordWithInvalidEmail() {
		Boolean error_msg = lp.invalidEmail(gUtility.randomeString()+"@gmail.com");
		Assert.assertTrue(error_msg,"Error Message is not displayed");
	}
	
	
	@AfterMethod(groups = {"Regression"})
	public void quit() {
	driver.quit();	
	}
	
	
}
