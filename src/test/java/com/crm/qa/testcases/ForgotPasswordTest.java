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

public class ForgotPasswordTest extends TestBase{
    RegistrationPage registrationPage;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;
    TestUtil testUtil;
    String username = "GTD";


    public ForgotPasswordTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
        forgotPasswordPage = new ForgotPasswordPage();
        testUtil = new TestUtil();
    }

    @Test(priority=3,description = "User is on the Registration screen")
    public void FP01() throws InterruptedException {
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


    @Test(priority=3,description = "User is on the Registration screen")
    public void FP02() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        forgotPasswordPage = loginPage.clickOnForgotpwd();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("forgot-password"));
        Assert.assertTrue(forgotPasswordPage.forgotPwdPage.getText().contains("Forgot Password?"));

    }

    @Test(priority=3,description = "User is on the Registration screen")
    public void FP03() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        forgotPasswordPage = loginPage.clickOnForgotpwd();
        Thread.sleep(5000);
        forgotPasswordPage.emailField.sendKeys("invalid#@!@.com");
        forgotPasswordPage.submitbtn.click();
        Thread.sleep(2000);
        Assert.assertEquals(forgotPasswordPage.emailError.getText(),"Enter a valid email address","Error message mismatch");
    }

    @Test(priority=3,description = "User is on the Registration screen")
    public void FP04() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        forgotPasswordPage = loginPage.clickOnForgotpwd();
        Thread.sleep(5000);
        forgotPasswordPage.emailField.sendKeys("nandan.h.a@gmail.com");
        forgotPasswordPage.submitbtn.click();
        Thread.sleep(2000);
        Assert.assertEquals(forgotPasswordPage.emailError.getText(),"Email not registered","Error message mismatch");
    }

    @Test(priority=3,description = "User is on the Registration screen")
    public void FP05() throws InterruptedException {
        String title = registrationPage.verifyRegistrationPageTitle();
        testUtil.isElementVisible(registrationPage.GTDLogo);
        testUtil.isElementVisible(registrationPage.registerBtn);
        Assert.assertEquals(registrationPage.login.isDisplayed(), true, "login link is not displayed");
        registrationPage.clickOnLogin();
        Thread.sleep(5000);
        forgotPasswordPage = loginPage.clickOnForgotpwd();
        Thread.sleep(5000);
        forgotPasswordPage.submitbtn.click();
        Thread.sleep(2000);
        Assert.assertEquals(forgotPasswordPage.emailError.getText(),"This field cannot be empty","Error message mismatch");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
