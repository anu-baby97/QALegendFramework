package com.qalegend.qa.testcases;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
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
	public void setUp(String browse) {
		initialization(browse);
		lp= new LoginPage();
		lp.validCredentials(prop.getProperty("username"), prop.getProperty("password"));
		ump = new UserManagementPage();
	}
	
	@Test(priority = 1,groups = {"Regression"},dataProvider = "testData",dataProviderClass = com.qalegend.qa.util.XLUtility.class)
	public void addUser(String fname, String lname, String roles, String password, String confirm_password, String sales_percent ) throws InterruptedException {
		
		ump.addUser(fname,lname,roles, password,confirm_password,sales_percent);
		Thread.sleep(3000);	
	
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
