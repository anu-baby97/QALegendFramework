package com.qalegend.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(id = "last_name")
	WebElement lastName;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(xpath = "//select[@id='role']")
	WebElement roleSelect;
	
	@FindBy(id = "username")
	WebElement uname;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "confirm_password")
	WebElement confirm_password;
	
	@FindBy(id = "cmmsn_percent")
	WebElement sales_percent;
	
	GenericUtility gUtility = new GenericUtility();
	
	public UserManagementPage(){
		PageFactory.initElements(driver, this);

	}
	
	public void addUser(String fname, String lname, String roles,String password, String confirm_password, String sales_percent) {
		popup.click();
		userManagementLink.click();
		userLink.click();
		addButton.click();
		firstName.sendKeys(fname);
		email.sendKeys(gUtility.randomeString()+"@gmail.com");
		lastName.sendKeys(lname);
		Select role = new Select(roleSelect);
		role.selectByVisibleText(roles);
		uname.sendKeys(gUtility.randomAlphaNumeric());
		this.password.sendKeys(password);
		this.confirm_password.sendKeys(confirm_password);
		this.sales_percent.sendKeys(sales_percent);
		
	}
}
