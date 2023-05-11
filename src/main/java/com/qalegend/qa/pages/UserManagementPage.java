package com.qalegend.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.qa.base.TestBase;
import com.qalegend.qa.util.GenericUtility;

public class UserManagementPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"step-0\"]/div[3]/button[3]")
	WebElement popup;

	@FindBy(linkText = "User Management")
	WebElement userManagementLink;
	
	@FindBy(xpath = "//i[@class='fa fa-user']//following-sibling::span[@class='title']")
	WebElement userLink;
	
	@FindBy(xpath = "//a[text()=' Add']")
	WebElement addButton;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "email")
	WebElement email;
	
	GenericUtility gUtility = new GenericUtility();
	
	public UserManagementPage(){
		PageFactory.initElements(driver, this);

	}
	
	public void addUser(String fname) {
		popup.click();
		userManagementLink.click();
		userLink.click();
		addButton.click();
		firstName.sendKeys(fname);
		email.sendKeys(gUtility.randomeString()+"@gmail.com");
	}
}
