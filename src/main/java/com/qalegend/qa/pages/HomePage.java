package com.qalegend.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegend.qa.base.TestBase;

public class HomePage extends TestBase{
	

	@FindBy(xpath = "//*[@id=\"step-0\"]/div[3]/button[3]")
	WebElement popup;
	
	@FindBy(xpath = "//i[@class='fa fa-calculator fa-lg']")
	WebElement calc_icon;
	
	@FindBy(xpath = "//div[@class='calcBG col-md-12 text-center']")
	WebElement calculator;
	
	@FindBy(xpath = "/html/body/div[2]/header/nav/div/button[3]/strong/i")
	WebElement appTourIcon;
	
	@FindBy(xpath = "//*[@id='step-0']/h3")
	WebElement appTourWindow;
	
	@FindBy(xpath = "//button[text()='Next »']")
	WebElement next;
	
	@FindBy(xpath = "//button[text()='« Prev']")
	WebElement prev;
	
	@FindBy(xpath = "//*[@id=\"step-1\"]/div[3]/button[3]")
	WebElement endTour;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement profile;
	
	@FindBy(linkText = "Sign Out" )
	WebElement logoutButton;
	
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean calculatorDisplay() {
		popup.click();
		calc_icon.click();
		return calculator.isDisplayed();	
	}
	
	public boolean appTourDisplay() {
		appTourIcon.click();
		return appTourWindow.isDisplayed();
			
	}
	
	public boolean isPrevClickable() {
		next.click();
		return prev.isEnabled();
	}
	
	public boolean closeApptour() {
		endTour.click();
		return appTourWindow.isDisplayed();
	}
	
	public String userLogOff() {
		profile.click();
		logoutButton.click();
		return driver.getCurrentUrl();
	}
}
