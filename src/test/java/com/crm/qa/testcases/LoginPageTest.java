package com.crm.qa.testcases;

import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	BlogPage blogPage;
	IntegrationPage integrationPage;
	VendorsPage vendorsPage;
	GetADemoPage getADemoPage;
	PricingPage pricingPage;
	TestUtil testUtil;

	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage= new HomePage();
	}
	
	@Test(priority=1)
	public void InitialPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,loginPage.pagetitle);
	}

	@Test(priority=2)
	public void NavigationToBlog(){
		blogPage=homePage.clickOnBlogLink();
		System.out.println("---------------"+blogPage.pageload);
		testUtil.waitforelement(blogPage.pageload);
		testUtil.isElementVisible(blogPage.pageload);
		String blogtitle=blogPage.verifyBlogPageTitle();
		Assert.assertEquals(blogtitle,blogPage.pagetitle);
	}


	@Test(priority=3)
	public void NavigationToIntegration(){
		integrationPage=homePage.clickOnIntegrationLink();
		testUtil.waitforelement(integrationPage.pageload);
		testUtil.isElementVisible(integrationPage.pageload);
		String integrationPagetitle=integrationPage.verifyIntegrationPageTitle();
		Assert.assertEquals(integrationPagetitle,integrationPage.pagetitle);
	}

	@Test(priority=4)
	public void NavigationToVendors(){
		vendorsPage=homePage.clickOnVendorLink();
		testUtil.waitforelement(vendorsPage.pageload);
		testUtil.isElementVisible(vendorsPage.pageload);
		String vendorPagetitle=vendorsPage.verifyVendorsPageTitle();
		Assert.assertEquals(vendorPagetitle,vendorsPage.pagetitle);
	}


	@Test(priority=5)
	public void NavigationToPricingPage(){
		pricingPage=homePage.clickOnPricingLink();
		testUtil.waitforelement(pricingPage.pageload);
		testUtil.isElementVisible(pricingPage.pageload);
		String getademoPagetitle=pricingPage.verifyPricingPageTitle();
		Assert.assertEquals(getademoPagetitle,pricingPage.pagetitle);
	}


	@Test(priority=6)
	public void NavigationToGetDemo(){
		getADemoPage=homePage.clickOnGetADemoLink();
		testUtil.waitforelement(getADemoPage.pageload);
		testUtil.isElementVisible(getADemoPage.pageload);
		String getademoPagetitle=getADemoPage.verifyGetaDemoPageTitle();
		Assert.assertEquals(getademoPagetitle,getADemoPage.pagetitle);
	}

	@Test(priority=7)
	public void NavigationToProductsAndCheckOptions() throws InterruptedException {
		testUtil.waitforelement(homePage.products);
		testUtil.isElementVisible(homePage.products);
		Actions actions = new Actions(driver);
		WebElement menuOption = homePage.products;
		actions.moveToElement(menuOption);
		actions.click().build().perform();
		WebElement submenu=homePage.MSP;
        actions.click().build().perform();
		testUtil.isElementVisible(homePage.MSP);
		testUtil.isElementVisible(homePage.PropasalBuilder);
		testUtil.isElementVisible(homePage.SalesAssessments);
		testUtil.isElementVisible(homePage.InsightsReports);
	}

	@Test(priority=8)
	public void NavigationToLoginPage(){
		String currentPageHandle = driver.getWindowHandle();
		loginPage=homePage.clickOnLoginLink();
		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
		String pageTitle = "Log in to Zomentum";
		boolean myNewTabFound = false;

		for(String eachHandle : tabHandles)
		{
			driver.switchTo().window(eachHandle);
			// Check Your Page Title
			if(driver.getTitle().equalsIgnoreCase(pageTitle))
			{
				testUtil.waitforelement(loginPage.usrname);
				driver.close(); // Note driver.quit() will close all tabs
				driver.switchTo().window(currentPageHandle);
				myNewTabFound = true;
			}
		}
		// Switch newly open Tab
		String loginPagetitle=loginPage.validateLoginPageTitle();
		Assert.assertEquals(true,myNewTabFound);
	}


	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
