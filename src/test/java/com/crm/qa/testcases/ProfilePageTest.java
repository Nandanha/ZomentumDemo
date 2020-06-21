package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ActivitiesPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ProfilePage;
import com.crm.qa.pages.RegistrationPage;
import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends TestBase {
    RegistrationPage registrationPage;
    LoginPage loginPage;
    ActivitiesPage activitiesPage;
    ProfilePage profilePage;
    TestUtil testUtil;
    String username = "GTD";
    ExtentReports extent;
    ExtentTest logger;

    public ProfilePageTest() {
        super();
    }

    @Test(priority=1,description = "User is on Activities page and clicks on the Search icon.")
    public void PR01() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.gtdProfile.click();
        activitiesPage.profile.isEnabled();
        profilePage=activitiesPage.navigateToProfileSettings();
        TestUtil.waitforelement(profilePage.backbutton);
        Assert.assertTrue(profilePage.profEmail.isDisplayed());
        Assert.assertTrue(profilePage.profName.isDisplayed());
        Assert.assertTrue(profilePage.profUsername.isDisplayed());
        Assert.assertTrue(profilePage.saveChanges.isDisplayed());
        profilePage.backbutton.click();
        Assert.assertTrue(activitiesPage.AddActivity.isDisplayed());
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
