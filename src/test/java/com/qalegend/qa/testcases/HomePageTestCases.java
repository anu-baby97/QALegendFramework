package com.qalegend.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qalegend.qa.base.TestBase;
import com.qalegend.qa.pages.HomePage;
import com.qalegend.qa.pages.LoginPage;

public class HomePageTestCases extends TestBase {

	HomePage hp;
	LoginPage lp;
	
	@BeforeMethod
	public void setUp(String browser) {
		initialization(browser);
		lp= new LoginPage();
		lp.validCredentials(prop.getProperty("username"), prop.getProperty("password"));
		hp=new HomePage();
	}
	
	@Test(priority = 1,groups = {"Regression"})	
	public void isCalculatorDisplayed() {
		Boolean calc = hp.calculatorDisplay();
		Assert.assertTrue(calc,"Calculator not displayed");
	}
	
	@Test(priority = 2,groups = {"Regression","Sanity"})
	public void isAppTourDisplayed() {
		Boolean tour = hp.appTourDisplay();
		Assert.assertTrue(tour,"Application tour window not displayed");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(hp.isPrevClickable(),"Previous button is not clickable");
		softAssert.assertFalse(hp.closeApptour(),"Application tour window not closed");
		softAssert.assertAll();
	}
	
	@Test(priority = 3,groups = {"Regression","Sanity"})
	public void userlogOff() {
		Assert.assertEquals("https://qalegend.com/billing/public/login", hp.userLogOff(),"The user couldn't be logged off");
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
