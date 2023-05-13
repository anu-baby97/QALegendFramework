package com.qalegend.qa.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qalegend.qa.base.TestBase;
import com.qalegend.qa.util.GenericUtility;

public class UserManagementPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"step-0\"]/div[3]/button[3]")
	WebElement popup;

	@FindBy(linkText = "User Management")
	WebElement userManagementLink;
	
	@FindBys({@FindBy(xpath = "//ul[@class='treeview-menu menu-open']/li")})
	List<WebElement> menuItems;
	
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
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchField;
	
	GenericUtility gUtility = new GenericUtility();
	
	public UserManagementPage(){
		PageFactory.initElements(driver, this);

	}
	
	public void IsUserManagementMenuDisplayed() {
		popup.click();
		userManagementLink.click();
		for(int i=0;i<menuItems.size();i++) {
			Assert.assertTrue( menuItems.get(i).isDisplayed(),"Menu items are not displayed");
		}
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
	
	public Boolean searchFunctionality() throws InterruptedException {
		popup.click();
		userManagementLink.click();
		userLink.click();
		String searchText = "abc@gmail.com";
		Boolean found =true;
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(searchText);
		Thread.sleep(3000);
		int rowsize = driver.findElements(By.xpath("//table[@id='users_table']/tbody/tr")).size();
		int colsize = driver.findElements(By.xpath("//table[@id='users_table']/thead/tr/th")).size();
		for (int j = 1; j <= rowsize; j++) {
			for (int k = 1; k <= colsize; k++) {
				if(driver.findElement(By.xpath("//table[@id='users_table']/tbody/tr[1]//td[1]"))
						.getText().equals("No matching records found")) {
					found=false;
					break;
				}
				
				else if (driver.findElement(By.xpath("//table[@id='users_table']/tbody/tr[" + j + "]//td[" + k + "]"))
						.getText().toLowerCase().equals(searchText.toLowerCase())) {
					System.out.println("Match found at row: " + j + ", Column: " + k);
					break;
				}
				
				else {
					if (k<=colsize) {
						continue;
						
					}
					else {
						found=false;
					}
				}
				

			}
			
		}
		return found;
	}
}
