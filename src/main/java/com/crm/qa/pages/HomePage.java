package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {


	@FindBy(xpath = "//nav//a[contains(text(),'Login')]")
	WebElement loginLink;

	@FindBy(xpath = "//nav//a/div[contains(text(),'Get a demo')]")
	WebElement getADemo;

	@FindBy(xpath = "//nav//a[contains(text(),'Pricing')]")
	WebElement PricingLink;

	@FindBy(xpath = "//nav//a[contains(text(),'Vendors')]")
	WebElement VendorsLink;

	@FindBy(xpath = "//nav//a[contains(text(),'Blog')]")
	WebElement blogLink;

	@FindBy(xpath = "//nav//a[contains(text(),'Integration')]")
	WebElement IntegrationLink;


	@FindBy(xpath = "//div[contains(text(),'Product')]")
	public WebElement products;

	@FindBy(xpath = "//nav//a//div[contains(text(),'MSP')]")
	public WebElement MSP;

	@FindBy(xpath = "//nav//a//div[contains(text(),'Proposal builder')]")
	public WebElement PropasalBuilder;

	@FindBy(xpath = "//nav//a//div[contains(text(),'Sales Assessments')]")
	public WebElement SalesAssessments;

	@FindBy(xpath = "//nav//a//div[contains(text(),'Inisghts & Reports')]")
	public WebElement InsightsReports;




	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	

	public IntegrationPage clickOnIntegrationLink(){
		IntegrationLink.click();
		return new IntegrationPage();
	}
	
	public GetADemoPage clickOnGetADemoLink(){
		getADemo.click();
		return new GetADemoPage();
	}
	
	public LoginPage clickOnLoginLink(){
		loginLink.click();
		return new LoginPage();
	}

	public VendorsPage clickOnVendorLink(){
		VendorsLink.click();
		return new VendorsPage();
	}

	public BlogPage clickOnBlogLink(){
		blogLink.click();
		return new BlogPage();
	}

	public PricingPage clickOnPricingLink(){
		PricingLink.click();
		return new PricingPage();
	}
}
