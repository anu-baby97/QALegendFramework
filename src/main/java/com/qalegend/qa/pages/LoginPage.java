package com.qalegend.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Objects
	
	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(tagName = "button")
	WebElement loginButton;
	
	@FindBy(linkText = "Forgot Your Password?")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement successMessage;
	
	@FindBy(xpath = "//input[@id='email']//parent::div//span//strong")
	WebElement errorMessage;
	
	@FindBy(id = "email")
	WebElement emailField;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	
	//Driver initialization
	
	public LoginPage(){
		PageFactory.initElements(driver, this);

	}
	
	//Actions

	/*
	 * public HomePage validCredentials(String un, String pwd) {
	 * username.sendKeys(un); password.sendKeys(pwd); loginButton.click(); return
	 * new HomePage(); }
	 */
	public String validCredentials(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return driver.getCurrentUrl();
	}
	
	public HomePage redirectPage() {
		return new HomePage();
	}
	
	public String invalidCredentials(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return driver.getCurrentUrl();
	}
	
	public boolean validEmail(String email) {
		forgotPasswordLink.click();
		emailField.sendKeys(email);
		submitButton.click();
		return successMessage.isDisplayed();
	}
	
	public boolean invalidEmail(String email) {
		forgotPasswordLink.click();
		emailField.sendKeys(email);
		submitButton.click();
		return errorMessage.isDisplayed();
	}
	
}
