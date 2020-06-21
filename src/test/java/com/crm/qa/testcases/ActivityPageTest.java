package com.crm.qa.testcases;

import com.crm.qa.pages.ActivitiesPage;
import com.crm.qa.pages.LoginPage;
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
import java.util.function.DoubleToIntFunction;

import com.crm.qa.pages.RegistrationPage;
import com.crm.qa.pages.ActivitiesPage;

public class ActivityPageTest extends TestBase {
    RegistrationPage registrationPage;
    LoginPage loginPage;
    ActivitiesPage activitiesPage;
    TestUtil testUtil;
    String username = "GTD";
    ExtentReports extent;
    ExtentTest logger;

    public ActivityPageTest(){
        super();
    }


    @BeforeMethod
    public void setUp(){
        initialization();
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
        activitiesPage = new ActivitiesPage();
        testUtil = new TestUtil();
    }

    //@Test(priority=1,description = "User is on the Registration screen")
    public void AC01() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        Assert.assertTrue(activitiesPage.AddActivity.isDisplayed());
        List<WebElement> actvitycards = driver.findElements(By.xpath("//div[contains(@class,'empty-card-clue')]"));
        Assert.assertTrue(actvitycards.size()==3);
        String actual = activitiesPage.ActivityHeader.getText();
        Assert.assertEquals(actual,"Activities","header mismatch");
        String footerlink = activitiesPage.ActivityFooter.getText();
        Assert.assertTrue(activitiesPage.ActivityFooter.isDisplayed());
    }

    //@Test(priority=2,description = "User is on Activities page and clicks on the Search icon.")
    public void AC02() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        Assert.assertTrue(activitiesPage.AddActivity.isDisplayed());
        List<WebElement> actvitycards = driver.findElements(By.xpath("//div[contains(@class,'empty-card-clue')]"));
        activitiesPage.SearchIcon.isEnabled();
        activitiesPage.SearchIcon.click();
        activitiesPage.SearchText.isEnabled();
        activitiesPage.SearchText.sendKeys("Invalid search");
        String actual = activitiesPage.noElementFound.getText();
        Assert.assertEquals(actual,"No Result Found","Activity search is not working ");
        activitiesPage.closeSearch.click();
        Assert.assertTrue(actvitycards.size()==3);
        Assert.assertTrue(activitiesPage.viewProductivity.isDisplayed());
        activitiesPage.viewProductivity.click();
        Thread.sleep(5000);
        String reportHeader = activitiesPage.ReportHeader.getText();
        Assert.assertEquals(reportHeader,"Report","Header mismatch");
    }

   // @Test(priority=3,description = "User is on Activities page and clicks on the Search icon.")
    public void AC03() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.notification.click();
        Assert.assertTrue(activitiesPage.you.isDisplayed());
        Assert.assertTrue(activitiesPage.all.isDisplayed());
        Assert.assertTrue(activitiesPage.def.isDisplayed());
    }

    //@Test(priority=4,description = "User is on Activities page and clicks on the Search icon.")
    public void AC04() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.gtdProfile.click();
        activitiesPage.profile.isEnabled();
        Assert.assertTrue(activitiesPage.profile.isDisplayed());
        Assert.assertTrue(activitiesPage.desktopNotf.isDisplayed());
        Assert.assertTrue(activitiesPage.feedback.isDisplayed());
        Assert.assertTrue(activitiesPage.logout.isDisplayed());
        Assert.assertTrue(activitiesPage.title.isDisplayed());
        String actual = activitiesPage.title.getText();
        Assert.assertEquals(actual,"Owner - testttttt","logged in username mismatch");
    }

    //@Test(priority = 5,description = "User is on Activities page and clicks on the Search icon.")
    public void AC05() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.gtdProfile.click();
        activitiesPage.profile.isEnabled();
        Assert.assertTrue(activitiesPage.profile.isDisplayed());
        Assert.assertTrue(activitiesPage.desktopNotf.isDisplayed());
        Assert.assertTrue(activitiesPage.feedback.isDisplayed());
        Assert.assertTrue(activitiesPage.logout.isDisplayed());
        Assert.assertTrue(activitiesPage.title.isDisplayed());
        String actual = activitiesPage.title.getText();
        Assert.assertEquals(actual,"Owner - testttttt","logged in username mismatch");
    }

    //@Test(priority = 5,description = "User is on Activities page and clicks on the Search icon.")
    public void AC06() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.reportPage.click();
        Thread.sleep(5000);
        String reportHeader = activitiesPage.ReportHeader.getText();
        Assert.assertEquals(reportHeader,"Report","Report Header mismatch");
        activitiesPage.workloadPage.click();
        String workloadHeader = activitiesPage.WorkloadHeader.getText();
        Assert.assertEquals(workloadHeader,"Workload","workload Header mismatch");
        activitiesPage.projectsPage.click();
        String projectHeader = activitiesPage.projectsHeader.getText();
        Assert.assertEquals(projectHeader,"Projects","Projects Header mismatch");
        activitiesPage.archivePage.click();
        String archiveHeader = activitiesPage.archiveHeader.getText();
        Assert.assertEquals(archiveHeader,"Archive","Archive Header mismatch");
        activitiesPage.activitiesPage.click();
        String activitiesHeader = activitiesPage.ActivitiesHeader.getText();
        Assert.assertEquals(activitiesHeader,"Activities","Activites Header mismatch");
        //Assert.assertFalse(activitiesPage.reactTooltip.isDisplayed());
        Actions actions = new Actions(driver);
        actions.moveToElement(activitiesPage.ActivityFooter).perform();
        activitiesPage.forwardArrow.click();
        Thread.sleep(3000);
        Assert.assertTrue(activitiesPage.closedSection.isDisplayed());
        actions.moveToElement(activitiesPage.ActivityFooterClosed).perform();
        activitiesPage.forwardArrow.click();
        Assert.assertTrue(activitiesPage.Section.isDisplayed());
    }

    //@Test(priority = 6,description = "User is on Activities page and clicks on the Search icon.")
    public void AC07() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.AddActivity.isEnabled();
        activitiesPage.AddActivity.click();
        String actual = activitiesPage.newActivityHeader.getText();
        Assert.assertEquals(actual,"New Activity","Title mismatch");
        activitiesPage.closeActivity.click();
    }

    //@Test(priority = 7,description = "User is on Activities page and clicks on the Search icon.")
    public void AC08() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.AddActivity.isEnabled();
        activitiesPage.AddActivity.click();
        String actual = activitiesPage.newActivityHeader.getText();
        Assert.assertEquals(actual,"New Activity","Title mismatch");
        activitiesPage.closeActivity.click();
        Thread.sleep(5000);
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        activitiesPage.unsplash.click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("unsplash"),"not in unsplash website");
        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle);

    }

    //@Test(priority = 8,description = "User is on Activities page and clicks on the Search icon.")
    public void AC09() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.AddActivity.isEnabled();
        Thread.sleep(5000);
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        activitiesPage.activityfooter.click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        String actual = driver.getTitle();
        Assert.assertEquals(actual,"Accelerating Human Productivity | Get Things Done","not in get things done  website");
        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle);
    }

    //@Test(priority=10,description = "User is on Activities page and clicks on the Search icon.")
    public void AC10() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.notification.click();
        Assert.assertTrue(activitiesPage.you.isDisplayed());
        Assert.assertTrue(activitiesPage.all.isDisplayed());
        Assert.assertTrue(activitiesPage.def.isDisplayed());
        Assert.assertTrue(activitiesPage.notificationHeader.isDisplayed());
        Assert.assertTrue(activitiesPage.moreOption.isDisplayed());
        Thread.sleep(3000);
        activitiesPage.moreOption.click();
        Assert.assertTrue(activitiesPage.markAsRead.isDisplayed());
        Assert.assertTrue(activitiesPage.viewFlagged.isDisplayed());
     }

    //@Test(priority=11,description = "User is on Activities page and clicks on the Search icon.")
    public void AC11() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.notification.click();
        Assert.assertTrue(activitiesPage.you.isDisplayed());
        Assert.assertTrue(activitiesPage.all.isDisplayed());
        Assert.assertTrue(activitiesPage.def.isDisplayed());
        Assert.assertTrue(activitiesPage.notificationHeader.isDisplayed());
        Assert.assertTrue(activitiesPage.moreOption.isDisplayed());
        activitiesPage.searchNotification.isEnabled();
        activitiesPage.searchNotification.click();
        Thread.sleep(2000);
        activitiesPage.searchNotiText.sendKeys("invalid notification text");
        Thread.sleep(2000);
        Assert.assertTrue(activitiesPage.notificationHeader.isDisplayed());
        activitiesPage.notificationSearchClose.click();
        Assert.assertTrue(activitiesPage.notificationHeader.isDisplayed());
        activitiesPage.clickForMain.click();
        Thread.sleep(2000);
        Assert.assertTrue(activitiesPage.addCard.isDisplayed());
    }

    @Test(priority=12,description = "User is on Activities page and clicks on the Search icon.")
    public void AC12() throws InterruptedException {
        activitiesPage=loginPage.loginInToGTD("gtd40@mailinator.com","Test$123");
        testUtil.isElementVisible(activitiesPage.AddActivity);
        Thread.sleep(5000);
        activitiesPage.gtdProfile.click();
        activitiesPage.profile.isEnabled();
        activitiesPage.profile.click();


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
