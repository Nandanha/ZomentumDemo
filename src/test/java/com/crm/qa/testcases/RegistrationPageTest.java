package com.crm.qa.testcases;

import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.io.File;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import java.time.LocalTime;
import java.util.Random;
import com.crm.qa.base.TestBase;
import java.util.List;

public class RegistrationPageTest extends TestBase{
	RegistrationPage registrationPage;
	TestUtil testUtil;
	String username = "GTD";
	ExtentReports extent;
	ExtentTest logger;
	
	public RegistrationPageTest(){
		super();
	}

	
	@BeforeMethod
	public void setUp(){
		initialization();
		registrationPage = new RegistrationPage();
		testUtil = new TestUtil();
	}

/*
	@Test(priority=1,description = "User is on the Registration screen")
	public void RE01(){
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		Assert.assertEquals(registrationPage.registerBtn.isDisplayed(),true,"Registration button is not displayed");
		Assert.assertEquals(registrationPage.registerBtn.isEnabled(),true,"Registration button is not enabled");
	}

	@Test(priority=2,description = "User does not enter value in any of the fields and clicks on Register button.")
	public void RE02() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		registrationPage.registerBtn.click();
		Thread.sleep(5000);
	}

	@Test(priority=3,description = "User types name in the name field and clicks on Register button")
	public void RE03() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		registrationPage.registerBtn.click();
		Thread.sleep(5000);
		Assert.assertEquals(registrationPage.getTextOf(registrationPage.emailError),"This field cannot be empty","Error message is not matching the expected");
		Assert.assertEquals(registrationPage.getTextOf(registrationPage.passwordError),"This field cannot be empty","Error message is not matching the expected");
		Assert.assertEquals(registrationPage.getTextOf(registrationPage.userError),"This field cannot be empty","Error message is not matching the expected");
	}

	@Test(priority=4,description = "User hovers on the info icon in the email field.")
	public void RE04() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		Actions action = new Actions(driver);
		action.moveToElement(registrationPage.emailInfo).build().perform();
		String tooltipText = registrationPage.emailinfoTooltip.getText();
		Assert.assertEquals(tooltipText,"Providing a business email would help us find your organization for you.","Tooltip is not displayed");
	}

	@Test(priority=5,description = "User enters invalid email format in the email field.")
	public void RE05() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		registrationPage.emailField.sendKeys("nandan#$%^.com");
		registrationPage.registerBtn.click();
		Thread.sleep(5000);
		Assert.assertEquals(registrationPage.getTextOf(registrationPage.emailError),"Enter a valid email address","Error message is not matching the expected");

	}

//div[@class='ytp-title-beacon']/following-sibling::a

	@Test(priority=6,description = "User has entered a Registered email id and clicks on Register button.")
	public void RE06() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		registrationPage.passwordField.sendKeys("reset$123");
		registrationPage.nameField.sendKeys("Ranga");
		registrationPage.emailField.sendKeys("rangaraj@peppersquare.com");
		registrationPage.registerBtn.click();
		Thread.sleep(5000);
		Assert.assertEquals(registrationPage.getTextOf(registrationPage.emailError),"This email is already registered. Try Login instead.","Error message is not matching the expected");

	}

	@Test(priority=7,description = "User clicks on the Login link under the email field.")
	public void RE07() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		registrationPage.login.click();
		Thread.sleep(5000);
		testUtil.isElementVisible(registrationPage.loginbtn);
		String loginPage = driver.getCurrentUrl();
		Assert.assertTrue(loginPage.endsWith("/login"),"Link is not matching the expected");
		String pagetitle = driver.getTitle();
		Assert.assertEquals(pagetitle,"Get Things Done","page title mismatch");
		Assert.assertTrue(registrationPage.loginbtn.isDisplayed());
		Assert.assertTrue(registrationPage.loginbtn.isEnabled());
	}


	@Test(priority=8,description = "User types password in the password field and clicks on show passsword icon.")
	public void RE08() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		registrationPage.passwordField.sendKeys("TestVisibility");
		Thread.sleep(5000);
		String before=registrationPage.passwordField.getText();
		System.out.println("------before:"+before);
		registrationPage.passwordInfo.click();
		Thread.sleep(5000);
		String after=registrationPage.passwordField.getText();
		System.out.println("------after:"+after);
//		Assert.assertFalse(before.equals(after));
	}


	@Test(priority=9,description = "User has entered password less than 6 characters and clicks on Register button.")
	public void RE09() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		registrationPage.passwordField.sendKeys("Test");
		registrationPage.nameField.sendKeys("Test");
		registrationPage.emailField.sendKeys("Test@email.com");
        registrationPage.registerBtn.click();
		Thread.sleep(5000);
		Assert.assertEquals(registrationPage.getTextOf(registrationPage.passwordError),"Password cannot be less than 6 characters","Error message is not matching the expected");
	}

	@Test(priority=10,description = "User has entered password less than 6 characters and clicks on Register button.")
	public void RE10() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		registrationPage.passwordField.sendKeys("reset");
		registrationPage.nameField.sendKeys("Ranga");
		registrationPage.emailField.sendKeys("testthis@email.com");
		registrationPage.registerBtn.click();
		Thread.sleep(5000);
		Assert.assertEquals(registrationPage.getTextOf(registrationPage.passwordError),"Password cannot be less than 6 characters","Error message is not matching the expected");
	}

	@Test(priority=11,description = "User has entered all the fields and clicks on Register button.")
	public void RE11() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		String email = emailCreation();
		username=email;
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("url"));
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		registrationPage.passwordField.sendKeys("Test$123");
		registrationPage.nameField.sendKeys("Test");
		System.out.println("---------username:"+username);
		System.out.println("---------username:"+email);
		registrationPage.emailField.sendKeys(email+"@mailinator.com");
		registrationPage.registerBtn.click();
		Thread.sleep(5000);
		testUtil.isElementVisible(registrationPage.registrationLink);
		//Assert.assertEquals(registrationPage.getTextOf(registrationPage.registrationLink),"Thank you for registering with Get Things Done","Error message is not matching the expected");
	}

	@Test(priority=12,description = "User has entered all the fields and clicks on Register button.",dependsOnMethods = "RE11")
	public void RE13() throws InterruptedException {
		Random rand = new Random();
		registrationPage.registerBtn.isEnabled();
		driver.get("https://www.mailinator.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[(@class='nav-item') and text()='Email']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='inbox_field']")).click();
		driver.findElement(By.xpath("//input[@id='inbox_field']")).clear();
		System.out.println("---------username:"+username);
		driver.findElement(By.xpath("//input[@id='inbox_field']")).sendKeys(username);
		driver.findElement(By.xpath("//button[@id='go_inbox']")).click();
		Thread.sleep(3000);
		String actual=driver.findElement(By.xpath("//div[@class='title_left']//div[contains(@class,'ng-binding')]")).getText();
		Assert.assertTrue(actual.contains(username.toLowerCase()),"Username mismatch");
		driver.findElement(By.xpath("//tr[@ng-repeat='email in emails']//a[@tabindex=0]")).click();
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,350)", "");
		driver.switchTo().frame("msg_body");
		driver.findElement(By.xpath("//a[@class='verify_btn']")).click();
		Thread.sleep(5000);
	}


	@Test(priority=13,description = "User has entered all the fields and clicks on Register button.")
	public void RE14() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
        registrationPage.login.click();
        Thread.sleep(2000);
		registrationPage.emailField.sendKeys("gtd40@mailinator.com");
		registrationPage.passwordField.sendKeys("Test$123");
		registrationPage.loginbtn.click();
		Thread.sleep(5000);
		String actual = registrationPage.registrationSuccess.getText();
		Assert.assertEquals(actual,"Registration successful!");
		registrationPage.registrationOrg.sendKeys("Test Org");
		//registrationPage.registrationCountry.sendKeys("India");
		//driver.findElement(By.xpath("//ul[@class='md-autocomplete-suggestions']/li")).click();
		String filePath = System.getProperty("user.dir") + "/src/main/resources/AddPhoto.jpg";
		registrationPage.profileImage.sendKeys(filePath);
		//Thread.sleep(15000);
		TestUtil.waitforelement(driver.findElement(By.xpath("//img[contains(@src,'AddPhoto')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'AddPhoto')]")).isDisplayed());
		registrationPage.continueReg.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("joinWorkspace"),"It has not landed in joinWorkspace page");
        Assert.assertEquals(registrationPage.joinWorkspace.getText(),"We couldn’t find any workspaces for you to join","This is not join workspace page");
		Assert.assertTrue(registrationPage.findYourWorkspace.isDisplayed(),"Find your workspace is not displayed");
		Assert.assertTrue(registrationPage.createNewWorkspace.isDisplayed(),"Create your workspace is not displayed");
	}


 */
/*
	@Test(priority=14,description = "User enters/does not enter other fields and clicks on the Continue buton and there are workspace suggestions.",dependsOnMethods = "RE14")
	public void RE15() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.login.click();
		Thread.sleep(2000);
		registrationPage.emailField.sendKeys(username+"@mailinator.com");
		registrationPage.passwordField.sendKeys("Test$123");
		registrationPage.loginbtn.click();
		Thread.sleep(5000);
		String actual = registrationPage.registrationSuccess.getText();
		Assert.assertEquals(actual,"Registration successful!");
		registrationPage.registrationOrg.sendKeys("Test Org");
		registrationPage.registrationCountry.sendKeys("India");
		driver.findElement(By.xpath("//ul[@class='md-autocomplete-suggestions']/li")).click();
		registrationPage.continueReg.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("joinWorkspace"),"It has not landed in joinWorkspace page");
		registrationPage.findYourWorkspace.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("findWorkspace"),"It has not landed in findWorkspace page");
		Assert.assertTrue(registrationPage.backbutton.getText().equals("Back"),"back button is not displayed");
		Assert.assertEquals(registrationPage.fwpPage.getText(),"Find your workspace","find your workspace page is not displayed");
        registrationPage.searchInput.sendKeys("test");
		Thread.sleep(5000);
		List<WebElement>searchList = driver.findElements(By.xpath("//div[@class='join-user-details']/p[contains(@class,'user-name')]"));
        for(int i=0;i<searchList.size();i++)
		{
			System.out.println("-----element:"+searchList.get(i).getText());
			//Assert.assertTrue(searchList.get(i).getText().contains("test"));
		}
		registrationPage.closeSearch.click();
        Thread.sleep(2000);
        Assert.assertFalse(registrationPage.isElementVisible(registrationPage.requestToJoin));
	}


	@Test(priority=15,description = "Find workspace and search workspace",dependsOnMethods = "RE15")
	public void RE16() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.login.click();
		Thread.sleep(2000);
		registrationPage.emailField.sendKeys(username+"@mailinator.com");
		registrationPage.passwordField.sendKeys("Test$123");
		registrationPage.loginbtn.click();
		Thread.sleep(5000);
		String actual = registrationPage.registrationSuccess.getText();
		Assert.assertEquals(actual,"Registration successful!");
		registrationPage.registrationOrg.sendKeys("Test Org");
		registrationPage.registrationCountry.sendKeys("India");
		driver.findElement(By.xpath("//ul[@class='md-autocomplete-suggestions']/li")).click();
		registrationPage.continueReg.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("joinWorkspace"),"It has not landed in joinWorkspace page");
		registrationPage.findYourWorkspace.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("findWorkspace"),"It has not landed in findWorkspace page");
		Assert.assertTrue(registrationPage.backbutton.getText().equals("Back"),"back button is not displayed");
		Assert.assertEquals(registrationPage.fwpPage.getText(),"Find your workspace","find your workspace page is not displayed");
		registrationPage.searchInput.sendKeys("test");
		Thread.sleep(5000);
		List<WebElement>searchList = driver.findElements(By.xpath("//div[@class='join-user-details']/p[contains(@class,'user-name')]"));
		for(int i=0;i<searchList.size();i++)
		{
			System.out.println("-----element:"+searchList.get(i).getText());
			//Assert.assertTrue(searchList.get(i).getText().contains("test"));
		}
		registrationPage.closeSearch.click();
		Thread.sleep(2000);
		Assert.assertFalse(registrationPage.isElementVisible(registrationPage.requestToJoin));
		registrationPage.searchInput.sendKeys("thereIsNoWorkSpace");
		Assert.assertEquals(registrationPage.noWorkSpaceFound.getText(),"No workspaces found","Text not found");
		registrationPage.backbutton.click();
		Thread.sleep(2000);
		Assert.assertEquals(registrationPage.joinWorkspace.getText(),"We couldn’t find any workspaces for you to join","This is not join workspace page");

	}

	@Test(priority=16,description = "Create workspace and add user",dependsOnMethods = "RE16")
	public void RE17() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.login.click();
		Thread.sleep(2000);
		registrationPage.emailField.sendKeys(username+"@mailinator.com");
		registrationPage.passwordField.sendKeys("Test$123");
		registrationPage.loginbtn.click();
		Thread.sleep(5000);
		String actual = registrationPage.registrationSuccess.getText();
		Assert.assertEquals(actual,"Registration successful!");
		registrationPage.registrationOrg.sendKeys("Test Org");
		registrationPage.registrationCountry.sendKeys("India");
		driver.findElement(By.xpath("//ul[@class='md-autocomplete-suggestions']/li")).click();
		registrationPage.continueReg.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("joinWorkspace"),"It has not landed in joinWorkspace page");
		registrationPage.createNewWorkspace.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("createWorkspace"),"It has not landed in createWorkspace page");
		Assert.assertEquals(registrationPage.workspaceTitle.getText(),"Create a workspace","This is not create Workspace page");
		registrationPage.workspaceName.sendKeys("TestWorkspace");
		registrationPage.proceedbtn.click();
		Thread.sleep(5000);
		System.out.println("--------------------"+registrationPage.adduserpage.getText());
		Assert.assertTrue(registrationPage.adduserpage.getText().contains("testworkspace"),"Workspace name mismatch");
        registrationPage.addmember.click();
        registrationPage.searchMember.sendKeys("gtd872@mailinator.com");
        Thread.sleep(2000);
        registrationPage.addAction.click();
		Thread.sleep(2000);
		registrationPage.proceedToActivity.click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getCurrentUrl().contains("activity"),"Not in activity page");
	}

@Test(priority=16,description = "Create workspace and add user",dependsOnMethods = "RE17")
public void RE18() throws InterruptedException {
	String title = registrationPage.verifyRegistrationPageTitle();
	testUtil.isElementVisible(registrationPage.GTDLogo);
	testUtil.isElementVisible(registrationPage.registerBtn);
	testUtil.isElementVisible(registrationPage.appleStore);
	testUtil.isElementVisible(registrationPage.googlePlay);
	Assert.assertEquals(title,registrationPage.pagetitle);
	registrationPage.login.click();
	Thread.sleep(2000);
	registrationPage.forgotpwdLink.click();
	Thread.sleep(2000);
	registrationPage.emailField.sendKeys(username+"@mailinator.com");
	registrationPage.submitbtn.click();
	Thread.sleep(5000);
    registrationPage.Resendbtn.isEnabled();
    Assert.assertTrue(registrationPage.Resendbtn.isDisplayed(),"resend button is not displayed");
	verifyEmail();
	String parentHandle = driver.getWindowHandle(); // get the current window handle
	driver.findElement(By.xpath("//a[@class='reset_btn']")).click();
	Thread.sleep(5000);
	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	}
	Assert.assertTrue(driver.getCurrentUrl().contains("reset-password"),"apple store is not displayed");
	registrationPage.passwordField.sendKeys("Test@1234");
	registrationPage.retypePwd.sendKeys("Test@1234");
	registrationPage.submitbtn.click();
	Thread.sleep(5000);
	Assert.assertEquals(registrationPage.passwordSuccessfully.getText(),"Password successfully reset!","Password reset success message missing ");
	driver.close(); // close newly opened window when done with it
	driver.switchTo().window(parentHandle); //
}



*/

	@Test(priority=11,description = "User has entered all the fields and clicks on Register button.")
	public void RE11() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		String email = emailCreation();
		username=email;
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("url"));
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.registerBtn.isEnabled();
		registrationPage.passwordField.sendKeys("Test$123");
		registrationPage.nameField.sendKeys("Test");
		System.out.println("---------username:"+username);
		System.out.println("---------username:"+email);
		registrationPage.emailField.sendKeys(email+"@mailinator.com");
		registrationPage.registerBtn.click();
		Thread.sleep(5000);
		testUtil.isElementVisible(registrationPage.registrationLink);
		//Assert.assertEquals(registrationPage.getTextOf(registrationPage.registrationLink),"Thank you for registering with Get Things Done","Error message is not matching the expected");
	}

	@Test(priority=12,description = "User has entered all the fields and clicks on Register button.",dependsOnMethods = "RE11")
	public void RE13() throws InterruptedException {
		Random rand = new Random();
		registrationPage.registerBtn.isEnabled();
		driver.get("https://www.mailinator.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[(@class='nav-item') and text()='Email']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='inbox_field']")).click();
		driver.findElement(By.xpath("//input[@id='inbox_field']")).clear();
		System.out.println("---------username:"+username);
		driver.findElement(By.xpath("//input[@id='inbox_field']")).sendKeys(username);
		driver.findElement(By.xpath("//button[@id='go_inbox']")).click();
		Thread.sleep(3000);
		String actual=driver.findElement(By.xpath("//div[@class='title_left']//div[contains(@class,'ng-binding')]")).getText();
		Assert.assertTrue(actual.contains(username.toLowerCase()),"Username mismatch");
		driver.findElement(By.xpath("//tr[@ng-repeat='email in emails']//a[@tabindex=0]")).click();
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,350)", "");
		driver.switchTo().frame("msg_body");
		driver.findElement(By.xpath("//a[@class='verify_btn']")).click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		Thread.sleep(5000);
		registrationPage.emailField.sendKeys(username+"@mailinator.com");
		registrationPage.passwordField.sendKeys("Test$123");
		registrationPage.loginbtn.click();
		Thread.sleep(5000);
		registrationPage.registrationOrg.sendKeys("Test Org");
		/*
		registrationPage.registrationCountry.sendKeys("India");
		driver.findElement(By.xpath("//ul[@class='md-autocomplete-suggestions']/li")).click();
		 */
		registrationPage.continueReg.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("joinWorkspace"),"It has not landed in joinWorkspace page");
		registrationPage.createNewWorkspace.click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("createWorkspace"),"It has not landed in createWorkspace page");
		Assert.assertEquals(registrationPage.workspaceTitle.getText(),"Create a workspace","This is not create Workspace page");
		registrationPage.workspaceName.sendKeys("TestWorkspace");
		registrationPage.proceedbtn.click();
		Thread.sleep(5000);
		System.out.println("--------------------"+registrationPage.adduserpage.getText());
		Assert.assertTrue(registrationPage.adduserpage.getText().contains("testworkspace"),"Workspace name mismatch");
		registrationPage.addmember.click();
		registrationPage.searchMember.sendKeys("gtd@testmail.com");
		Thread.sleep(2000);
		registrationPage.addAction.click();
		Thread.sleep(2000);
		registrationPage.proceedToActivity.click();
		Thread.sleep(2000);
		registrationPage.projectName.sendKeys("TestProject");
		Thread.sleep(2000);
		String filePath = System.getProperty("user.dir") + "/src/main/resources/AddPhoto.jpg";
		registrationPage.projectLogo.sendKeys(filePath);
		Thread.sleep(2000);
		registrationPage.proceedbtn.click();
		Assert.assertTrue(driver.getCurrentUrl().contains("activity"),"Not in activity page");

		/*
		registrationPage.proceedToActivity.click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getCurrentUrl().contains("activity"),"Not in activity page");
		 */
	}

	public String emailCreation() throws InterruptedException {
		Random rand = new Random();
		driver.get("https://www.mailinator.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[(@class='nav-item') and text()='Email']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='inbox_field']")).click();
		driver.findElement(By.xpath("//input[@id='inbox_field']")).clear();
		int num = rand.nextInt(1000);
		System.out.println("--------------------Num:"+num);
		username = username+num;
		driver.findElement(By.xpath("//input[@id='inbox_field']")).sendKeys(username);
		driver.findElement(By.xpath("//button[@id='go_inbox']")).click();
		Thread.sleep(3000);
		String actual=driver.findElement(By.xpath("//div[@class='title_left']//div[contains(@class,'ng-binding')]")).getText();
		System.out.println("-------------------Username:"+actual);
		Assert.assertTrue(actual.contains(username.toLowerCase()),"Username mismatch");
		return username;
	}

	public void verifyEmail() throws InterruptedException {
		driver.get("https://www.mailinator.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[(@class='nav-item') and text()='Email']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='inbox_field']")).click();
		driver.findElement(By.xpath("//input[@id='inbox_field']")).clear();
		driver.findElement(By.xpath("//input[@id='inbox_field']")).sendKeys(username);
		driver.findElement(By.xpath("//button[@id='go_inbox']")).click();
		Thread.sleep(3000);
		String actual=driver.findElement(By.xpath("//div[@class='title_left']//div[contains(@class,'ng-binding')]")).getText();
		Assert.assertTrue(actual.contains(username.toLowerCase()),"Username mismatch");
		driver.findElement(By.xpath("//tr[@ng-repeat='email in emails']//a[@tabindex=0]")).click();
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,350)", "");
		driver.switchTo().frame("msg_body");
	}

/*
@Test(priority=33,description = "User is on Registration screen and clicks on 'Terms of Service' link.")
public void RE33() throws InterruptedException {
	String title = registrationPage.verifyRegistrationPageTitle();
	testUtil.isElementVisible(registrationPage.GTDLogo);
	testUtil.isElementVisible(registrationPage.registerBtn);
	testUtil.isElementVisible(registrationPage.appleStore);
	testUtil.isElementVisible(registrationPage.googlePlay);
	Assert.assertEquals(title,registrationPage.pagetitle);
	registrationPage.termsOfService.isEnabled();

	String parentHandle = driver.getWindowHandle(); // get the current window handle
	registrationPage.termsOfService.click();
	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	}
	String actual = driver.getTitle();
	Assert.assertEquals(actual,"Terms of service | Get Things Done","get things done is not displayed");
	driver.close(); // close newly opened window when done with it
	driver.switchTo().window(parentHandle);
}

	@Test(priority=34,description = "User is on Registration screen and clicks on 'Privacy Policy' link.")
	public void RE34() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		registrationPage.privacyPolicy.isEnabled();

		String parentHandle = driver.getWindowHandle(); // get the current window handle
		registrationPage.privacyPolicy.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		String actual = driver.getTitle();
		Assert.assertEquals(actual,"Privacy Policy | Get Things Done","get things done is not displayed");
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle);
	}

	@Test(priority=35,description = "Website link on Registration page")
	public void RE35() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
		registrationPage.clickOnLogin();
		Thread.sleep(5000);
		registrationPage.getThingsDone.click();
		Thread.sleep(5000);
		String actual = driver.getTitle();
		Assert.assertEquals(actual,"Get Things Done","website mismatch");
	}

	@Test(priority=36,description = "User is on the Login screen and clicks on 'GET IT ON Google Play' button.")
	public void RE36() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
		registrationPage.clickOnLogin();
		Thread.sleep(5000);
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		registrationPage.googlePlay.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		Assert.assertEquals(driver.getTitle(),"GetThingsDone.io - Apps on Google Play","google play is not displayed");
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle); // s
	}

	@Test(priority=37,description = "User is on the Login screen and clicks on 'App Store' button.")
	public void RE37() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
		registrationPage.clickOnLogin();
		Thread.sleep(5000);
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		registrationPage.appleStore.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		Assert.assertTrue(driver.getTitle().contains("GetThingsDone.io dans l’App Store"),"apple store is not displayed");
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle); // s
	}


	@Test(priority=38,description = "Product demo video link")
	public void RE38() throws InterruptedException {
	String title = registrationPage.verifyRegistrationPageTitle();
	testUtil.isElementVisible(registrationPage.GTDLogo);
	testUtil.isElementVisible(registrationPage.registerBtn);
	testUtil.isElementVisible(registrationPage.appleStore);
	testUtil.isElementVisible(registrationPage.googlePlay);
	Assert.assertEquals(title,registrationPage.pagetitle);
	driver.switchTo().frame(0);
	registrationPage.thumbnail.isEnabled();
	registrationPage.thumbnail.click();
	Assert.assertTrue(driver.findElement(By.xpath("//div/video[contains(@src,'youtube')]")).isDisplayed());
}


	@Test(priority=38,description = "Product demo youtube video link")
	public void RE38() throws InterruptedException {
		String title = registrationPage.verifyRegistrationPageTitle();
		testUtil.isElementVisible(registrationPage.GTDLogo);
		testUtil.isElementVisible(registrationPage.registerBtn);
		testUtil.isElementVisible(registrationPage.appleStore);
		testUtil.isElementVisible(registrationPage.googlePlay);
		Assert.assertEquals(title,registrationPage.pagetitle);
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.switchTo().frame(0);
		registrationPage.prodDemo.isEnabled();
		registrationPage.prodDemo.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		String actual = driver.getTitle();
		Assert.assertEquals(actual,"Get Things Done - YouTube","get things done youtube is not displayed");
		driver.close(); // close newly opened window when done with it
		driver.switchTo().window(parentHandle);
	}

@Test(priority=39,description = "View list of features")
public void RE39() throws InterruptedException {
	String title = registrationPage.verifyRegistrationPageTitle();
	testUtil.isElementVisible(registrationPage.GTDLogo);
	testUtil.isElementVisible(registrationPage.registerBtn);
	testUtil.isElementVisible(registrationPage.appleStore);
	testUtil.isElementVisible(registrationPage.googlePlay);
	Assert.assertEquals(title,registrationPage.pagetitle);
	registrationPage.visitListOfFeatures.isEnabled();

	String parentHandle = driver.getWindowHandle(); // get the current window handle
	registrationPage.visitListOfFeatures.click();
	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	}
	String actual = driver.getTitle();
	Assert.assertEquals(actual,"Prioritize, collaborate, organize & manage projects | Get Things Done","get things done is not displayed");
	driver.close(); // close newly opened window when done with it
	driver.switchTo().window(parentHandle);
}
*/

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}


