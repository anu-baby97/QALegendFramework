package com.qalegend.qa.testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qalegend.qa.base.TestBase;
import com.qalegend.qa.pages.LoginPage;
import com.qalegend.qa.pages.UserManagementPage;

public class UserManagementTestCases extends TestBase {
	
	UserManagementPage ump;
	LoginPage lp;
	public Logger logger ;
	
	public UserManagementTestCases() {
		super();
	}
	
	@BeforeMethod(groups = {"Regression"})
	@Parameters("browser")
	public void setUp(String browse) {
		logger=LogManager.getLogger(this.getClass());
		initialization(browse);
		lp= new LoginPage();
		lp.validCredentials(prop.getProperty("username"), prop.getProperty("password"));
		ump = new UserManagementPage();
	}
	
	@Test(enabled = false,priority = 1)
	public void userManagementMenuExpansionCheck() {
		//String[] userMgmtMenu = { "Users", "Roles", "Sales Commission Agent" };
		ump.IsUserManagementMenuDisplayed();
		logger.info("--Menu expansion is displayed--");
		
	}
	
	
	@Test(enabled = false, priority = 2,groups = {"Regression"},dataProvider = "testData",dataProviderClass = com.qalegend.qa.util.XLUtility.class)
	public void addUser(String fname, String lname, String roles, String password, String confirm_password, String sales_percent ) throws InterruptedException {
		
		ump.addUser(fname,lname,roles, password,confirm_password,sales_percent);
		Thread.sleep(3000);	
	
	}
	
	@Test(enabled = true, priority = 3,groups = {"Regression"})
	public void searchFunctionalityCheck() throws InterruptedException {
		
		Boolean found = ump.searchFunctionality();
		Assert.assertTrue(found,"No Search results found");	
	
	}
	
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
