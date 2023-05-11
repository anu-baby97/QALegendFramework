package com.qalegend.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qalegend.qa.base.TestBase;
import com.qalegend.qa.pages.HomePage;
import com.qalegend.qa.pages.LoginPage;
import com.qalegend.qa.pages.UserManagementPage;

public class UserManagementTestCases extends TestBase {

	UserManagementPage ump;
	LoginPage lp;
	
	public UserManagementTestCases() {
		super();
	}
	
	@BeforeMethod(groups = {"Regression"})
	@Parameters("browser")
	public void setUp(String browserName) {
		initialization(browserName);
		lp= new LoginPage();
		lp.validCredentials(prop.getProperty("username"), prop.getProperty("password"));
		ump = new UserManagementPage();
	}
	
	@Test(priority = 1,groups = {"Regression"},dataProvider = "testData",dataProviderClass = com.qalegend.qa.util.XLUtility.class)
	public void addUser(String fname) {
		ump.addUser(fname);
		
	
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
