package com.qalegend.qa.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qalegend.qa.base.TestBase;
import com.qalegend.qa.pages.LoginPage;

public class LoginPageTestCases extends TestBase{

	LoginPage lp;
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	
	public LoginPageTestCases() {
		super();
	}
	
	@BeforeMethod(groups = {"Regression"})
	@Parameters("browser")
	public void setUp(String browserName) {
		initialization(browserName);
		lp= new LoginPage();
	}
	
	@Test(priority = 1,groups = {"Regression"})
	public void loginWithValidDetails() {
		String url = lp.validCredentials(prop.getProperty("username"), prop.getProperty("password"));
		lp.redirectPage();
		Assert.assertEquals("https://qalegend.com/billing/public/home", url,"The page is not redirected to Home page for valid credentials");
	}
	
	@Test(priority = 2,groups = {"Regression","Sanity"})
	public void loginWithInvalidDetails() {
		String url = lp.invalidCredentials(randomeString(), randomAlphaNumeric());
		Assert.assertEquals("https://qalegend.com/billing/public/login", url,"The page is redirected to Home page for invalid credentials");
	}
	
	@Test(priority = 3,groups = {"Regression"})
	public void forgotPasswordWithValidEmail() {
		Boolean success_msg = lp.validEmail(prop.getProperty("email"));
		Assert.assertTrue(success_msg,"Success Message is not displayed");
	}
	
	@Test(priority = 4,groups = {"Regression","Sanity"})
	public void forgotPasswordWithInvalidEmail() {
		Boolean error_msg = lp.invalidEmail(randomeString()+"@gmail.com");
		Assert.assertTrue(error_msg,"Error Message is not displayed");
	}
	
	
	@AfterMethod(groups = {"Regression"})
	public void quit() {
	driver.quit();	
	}
	
	
}
