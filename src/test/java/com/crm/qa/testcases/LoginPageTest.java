package com.crm.qa.testcases;

import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

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

public class LoginPageTest extends TestBase{
    RegistrationPage registrationPage;
    LoginPage loginPage;
    TestUtil testUtil;
    String username = "GTD";


    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
    }

    @Test(priority=1,description = "User is on the Registration screen")
    public void LO01() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.emailField.isDisplayed(), "Email field is not displayed");
        Assert.assertTrue(loginPage.passwordField.isDisplayed(), "password field is not displayed");
        Assert.assertTrue(loginPage.loginbtn.isDisplayed(), "loginbtn field is not displayed");
    }

    @Test(priority=2,description = "User is on the Registration screen")
    public void LO02() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        loginPage.loginbtn.click();
        Assert.assertEquals(loginPage.getTextOf(loginPage.emailError),"This field cannot be empty","Error message is not matching the expected");
        Assert.assertEquals(loginPage.getTextOf(loginPage.passwordError),"This field cannot be empty","Error message is not matching the expected");
    }

    @Test(priority=3,description = "User is on the Registration screen")
    public void LO03() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        registrationPage.emailField.sendKeys("invalid3$#@!");
        registrationPage.passwordField.sendKeys("Test$123");
        loginPage.loginbtn.click();
        Assert.assertEquals(loginPage.getTextOf(loginPage.emailError),"Enter a valid email address","Error message is not matching the expected");
    }

    @Test(priority=3,description = "User is on the Registration screen")
    public void LO04() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        registrationPage.emailField.sendKeys("gtd872@mailinator.com");
        registrationPage.passwordField.sendKeys("Test@!@#");
        loginPage.loginbtn.click();
        Assert.assertEquals(loginPage.getTextOf(loginPage.passwordError),"Incorrect Email or Password","Error message is not matching the expected");
    }

    @Test(priority=3,description = "User is on the Registration screen")
    public void LO05() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//p[@class='or_sign']")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='email']")).isDisplayed(),"gmail input is not displayed");
        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // s
    }


    @Test(priority=3,description = "User is on the Registration screen")
    public void LO06() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        loginPage.getThingsDone.click();
        Thread.sleep(5000);
        String actual = driver.getTitle();
        Assert.assertEquals(actual,"Get Things Done","website mismatch");
    }

     @Test(priority=3,description = "User is on the Registration screen")
    public void LO07() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        loginPage.googlePlay.click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertEquals(driver.getTitle(),"GetThingsDone.io - Apps on Google Play","google play is not displayed");
        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // s
    }

    @Test(priority=3,description = "User is on the Registration screen")
    public void LO08() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        loginPage.appleStore.click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertTrue(driver.getTitle().contains("GetThingsDone.io dans l’App Store"),"apple store is not displayed");
        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // s
    }

    @Test(priority=3,description = "User is on the Registration screen")
    public void LO09() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        loginPage.registerLink.click();
        Thread.sleep(5000);
        Assert.assertTrue(testUtil.isElementVisible(registrationPage.GTDLogo));
        Assert.assertTrue(testUtil.isElementVisible(registrationPage.registerBtn));
    }


    @Test(priority=3,description = "User is on the Registration screen")
    public void LO10() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        loginPage.forgotpwdLink.click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("forgot-password"));
        System.out.println("---------fp:"+loginPage.forgotPwdPage.getText());
        Assert.assertTrue(loginPage.forgotPwdPage.getText().contains("Forgot Password?"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
