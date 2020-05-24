package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="email-2")
	public WebElement username;

	@FindBy(xpath ="//input[@name='username']")
    public WebElement usrname;


	@FindBy(xpath="//input[@data-name='Email 3']/following-sibling::input")
	public WebElement submitbtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	public WebElement signUpBtn;
	
	@FindBy(xpath="//div[@class='profile-info has-sidebar-view']/img")
	public WebElement zomentumLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	public String pagetitle="The sales tool built exclusively for MSPs | Zomentum";
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return zomentumLogo.isDisplayed();
	}
	
	public HomePage getStarted(String un) throws InterruptedException {
		username.sendKeys(un);
		/*
		submitbtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", submitbtn);

		 */
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='home-v3-button w-button']")).click();
		return new HomePage();
	}
	
}
