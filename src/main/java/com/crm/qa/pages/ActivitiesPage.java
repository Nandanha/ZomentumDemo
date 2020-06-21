package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

public class ActivitiesPage extends TestBase {

    @FindBy(xpath = "//div[@class='af-circular-icon add-icon']")
    public WebElement AddActivity;

    @FindBy(xpath = "//div[contains(@class,'empty-card-clue')]")
    public WebElement addCard;

    @FindBy(xpath = "//h1[text()='Activities']")
    public WebElement ActivityHeader;

    @FindBy(xpath = "//div[@class='navBar-logo']//a[@href = 'https://getthingsdone.io']")
    public WebElement ActivityFooter;

    @FindBy(xpath = "//div[@class='navBar-closedLogo']//a[@href = 'https://getthingsdone.io']")
    public WebElement ActivityFooterClosed;

    @FindBy(xpath = "//div[@class='general-page-search-icon']/img")
    public WebElement SearchIcon;

    @FindBy(xpath = "//div[@class='general-page-search-box-parent']/input")
    public WebElement SearchText;

    @FindBy(xpath = "//span[text()='No Result Found']")
    public WebElement noElementFound;

    @FindBy(xpath = "//img[contains(@class,'close-search')]")
    public WebElement closeSearch;

    @FindBy(xpath = "//div[@title='View your Productivity']//a")
    public WebElement viewProductivity;

    @FindBy(xpath = "//div[@class='timesheet-search-message report-message ng-binding ng-scope']")
    public WebElement timesheetMsg;

    @FindBy(xpath = "//h1[text()='Report']")
    public WebElement ReportHeader;

    @FindBy(xpath = "//section[@class='page-right-section report']")
    public WebElement ReportSection;

    @FindBy(xpath = "//button[@class='comm-filter-btn apply']")
    public WebElement applybtn;

    @FindBy(xpath = "//img[@id='notify-toggle']")
    public WebElement notification;

    @FindBy(xpath = "//a[@value='you']")
    public WebElement you;

    @FindBy(xpath = "//a[@value='all']")
    public WebElement all;

    @FindBy(xpath = "//li[@class='active']//a[@value='you']")
    public WebElement def;

    @FindBy(xpath = "//div[@class='gtd-profile']")
    public WebElement gtdProfile;

    @FindBy(xpath = "//a[@class='profile_tiem']")
    public WebElement profile;

    @FindBy(xpath = "//a[text()='Allow desktop notifications']")
    public WebElement desktopNotf;

    @FindBy(xpath = "//a[text()='Feedback']")
    public WebElement feedback;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logout;

    @FindBy(xpath = "//p[@title='gtd40@mailinator.com']")
    public WebElement title;

    @FindBy(xpath = "//span[@class='navBar-title' and contains(text(),'Activities')]")
    public WebElement activitiesPage;

    @FindBy(xpath = "//span[@class='navBar-title' and contains(text(),'Report')]")
    public WebElement reportPage;

    @FindBy(xpath = "//span[@class='navBar-title' and contains(text(),'Workload')]")
    public WebElement workloadPage;

    @FindBy(xpath = "//span[@class='navBar-title' and contains(text(),'Projects')]")
    public WebElement projectsPage;

    @FindBy(xpath = "//span[@class='navBar-title' and contains(text(),'Archive')]")
    public WebElement archivePage;

    @FindBy(xpath = "//div[@class='navBar-options-footer']")
    public WebElement activityfooter;

    @FindBy(xpath = "//h1[text()='Activities']")
    public WebElement ActivitiesHeader;

    @FindBy(xpath = "//h1[text()='Workload']")
    public WebElement WorkloadHeader;

    @FindBy(xpath = "//h1[text()='Projects']")
    public WebElement projectsHeader;

    @FindBy(xpath = "//h1[text()='Archive']")
    public WebElement archiveHeader;

    @FindBy(xpath = "//div[@class='forward-arrow']/img")
    public WebElement forwardArrow;

    @FindBy(xpath = "//div[@data-id='tooltip']")
    public WebElement reactTooltip;

    @FindBy(xpath = "//section[@class='navBar-container closed-navBar']")
    public WebElement closedSection;

    @FindBy(xpath = "//section[@class='navBar-container']")
    public WebElement Section;

    @FindBy(xpath = "//div[@class='header-text']")
    public WebElement newActivityHeader;

    @FindBy(xpath = "//button[@aria-label='Close']/span/img")
    public WebElement closeActivity;

    @FindBy(xpath = "(//div[@class='unslpash-credits clients-credits']/a)[2]")
    public WebElement unsplash;

    @FindBy(xpath = "//div[@class='notification-search-icon on-search']/img")
    public WebElement searchNotification;

    @FindBy(xpath = "//input[@class='notification-search-input']")
    public WebElement searchNotiText;

    @FindBy(xpath = "//div[@id ='notifi-options-holder']/img")
    public WebElement moreOption;

    @FindBy(xpath = "//div[@id ='notifi-options-ddown-holder']/div[1]")
    public WebElement markAsRead;

    @FindBy(xpath = "//div[@id ='notifi-options-ddown-holder']/div[2]")
    public WebElement viewFlagged;

    @FindBy(xpath = "//div[@class='system-notify-header']")
    public WebElement notificationHeader;

    @FindBy(xpath = "//div[@class='notification-search-close']/img")
    public WebElement notificationSearchClose;

    @FindBy(xpath = "//div[@id='activity-container-scroll-div']")
    public WebElement clickForMain;

    public ProfilePage navigateToProfileSettings()
    {
        gtdProfile.isEnabled();
        gtdProfile.click();
        profile.isEnabled();
        profile.click();
        return PageFactory.initElements(driver, ProfilePage.class);
    }


}
