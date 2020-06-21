package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegistrationPage extends TestBase {
    @FindBy(xpath="//span[contains(text(),'Register')]//parent::button")
    public WebElement registerBtn;

    @FindBy(xpath="//input[@name='name']")
    public WebElement nameField;

    @FindBy(xpath="//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath="//input[@name='email']")
    public WebElement emailField;

    @FindBy(xpath="//p[contains(text(),'Register with Google ')]")
    public WebElement registerWithGoogle;

    @FindBy(xpath="//input[@name='email']//following-sibling::img")
    public WebElement emailInfo;

    @FindBy(xpath="//input[@name='password']//following-sibling::div")
    public WebElement passwordInfo;

    @FindBy(xpath="//a[@class='for-register']")
    public WebElement login;

    @FindBy(xpath = "//p[@class='for-pass']")
    public WebElement AlreadyOnGTD;

    @FindBy(xpath = "//a[@class='app-store-img-holder apple']")
    public WebElement appleStore;

    @FindBy(xpath = "//a[@class='app-store-img-holder']")
    public WebElement googlePlay;

    @FindBy(xpath = "//div[@class='new-logo']/img")
    public WebElement GTDLogo;

    @FindBy(xpath = "//input[@name='email']//following-sibling::p")
    public WebElement emailError;

    @FindBy(xpath = "//input[@name='name']//following-sibling::p")
    public WebElement userError;

    @FindBy(xpath = "//input[@name='password']//following-sibling::p")
    public WebElement passwordError;

    @FindBy(xpath = "//div[@class='info-detail']/p")
    public WebElement emailinfoTooltip;

    @FindBy(xpath = "//span[contains(text(),'Login')]//parent::button")
    public WebElement loginbtn;

    @FindBy(xpath = "//p[@class='title-verify']")
    public WebElement registrationLink;

    @FindBy(xpath = "//p[@class='title-sucess']")
    public WebElement registrationSuccess;

    @FindBy(xpath = "(//input[contains(@class,'finish-profile-input')])[1]")
    public WebElement registrationName;

    @FindBy(xpath = "(//input[contains(@class,'finish-profile-input')])[2]")
    public WebElement registrationOrg;

    /*
    @FindBy(xpath = "//input[@id='input-0']")
    public WebElement registrationCountry;

     */

    @FindBy(xpath = " //input[@id='country']")
    public WebElement registrationCountry;

    @FindBy(xpath = "//span[contains(text(),'Continue')]//parent::button")
    public WebElement continueReg;

    @FindBy(xpath = "//p[@class='join-title']")
    public WebElement joinWorkspace;

    public static String pagetitle="Get Things Done";

    @FindBy(xpath = "//div[@class='join-container-footer']//a[contains(text(),'Find your workspace')]")
    public WebElement findYourWorkspace;

    @FindBy(xpath = "//div[@class='join-container-footer']//a[contains(text(),'Create new workspace')]")
    public WebElement createNewWorkspace;

    @FindBy(xpath = "//span[@class='back-button-profile']")
    public WebElement backbutton;

    @FindBy(xpath = "//p[@class='join-title']")
    public WebElement fwpPage;

    @FindBy(xpath="//img[contains(@class,'cancel-icon-join')]")
    public WebElement closeSearch;

    @FindBy(xpath="//div[@class='join-right-side']/button")
    public WebElement requestToJoin;

    @FindBy(xpath="//div[@class='join-user-details']/p")
    public WebElement searchlist;

    @FindBy(id="joinSearch")
    public WebElement searchInput; ;

    @FindBy(xpath="//p[@class='join-no-title']")
    public WebElement noWorkSpaceFound;

    @FindBy(xpath="//div[@class='workspace-name']/input")
    public WebElement workspaceName;

    @FindBy(xpath = "//h1[@class='create-title']")
    public WebElement workspaceTitle;

    @FindBy(xpath = "//div[@class='proceed-btn']/button")
    public WebElement proceedbtn;

    @FindBy(xpath = "//p[contains(@class,'join-title')]")
    public WebElement adduserpage;

    @FindBy(xpath = "//div[@class='adduser-superadmins']//div[@class='user-add']/img")
    public WebElement addowner;

    @FindBy(xpath = "//div[@class='adduser-members']//div[@class='user-add']/img")
    public WebElement addmember;

    @FindBy(xpath = "//div[@class='adduser-members']//div[@class='edit-board-search-holder']/input")
    public WebElement searchMember;

    @FindBy(xpath = "//div[@class='adduser-superadmins']//div[@class='edit-board-search-holder']/input")
    public WebElement searchowner;

    @FindBy(xpath = "//div[@class='user-add-action']")
    public WebElement addAction;

    @FindBy(xpath = "//button[contains(@class,'active-proceed')]")
    public WebElement proceedToActivity;

    @FindBy(xpath = "//a[@class='forgot-password-login']")
    public WebElement forgotpwdLink;

    @FindBy(xpath = "//span[contains(text(),'Submit')]//parent::button")
    public WebElement submitbtn;

    @FindBy(xpath = "//input[@name='retypePassword']")
    public WebElement retypePwd;

    @FindBy(xpath = "//button//span[text()='Resend link']")
    public WebElement Resendbtn;

    //div[@class='fp-main-heading']
    @FindBy(xpath = "//div[@class='fp-main-heading']")
    public WebElement passwordSuccessfully;

    @FindBy(xpath = "//div[@class='ytp-title-beacon']/following-sibling::a")
    public WebElement prodDemo;

    @FindBy(xpath = "//div/p[@class='download-register']")
    public WebElement visitListOfFeatures;

    @FindBy(xpath = "//button[contains(@class,'ytp-large-play-button')]")
    public WebElement thumbnail;

    @FindBy(xpath = "//a[text()='website']")
    public WebElement getThingsDone;

    @FindBy(xpath = "//a/span[text()='Terms of Service']")
    public WebElement termsOfService;

    @FindBy(xpath = "//a/span[text()='Privacy Policy']")
    public WebElement privacyPolicy;

    @FindBy(xpath = "//div[@class='workspace-name']/input")
    public WebElement projectName;

    @FindBy(xpath = "//div[@class='upload-image']/input")
    public WebElement projectLogo;

    @FindBy(xpath = "//div[@class='img-profile']/following-sibling::input")
    public WebElement profileImage;


    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyRegistrationPageTitle(){
        return driver.getTitle();
    }

    public String getTextOf(WebElement element)
    {
        String message = element.getText();
        return message;
    }

    public LoginPage clickOnLogin()
    {
        login.isEnabled();
        login.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }


    public boolean isElementVisible(WebElement element)
    {
        boolean flag = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            if (wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()) {
                flag = true;
            }
        }catch(Exception e) {
            System.out.println("Element not found");
            return flag = false;

        }
        return flag;
    }

}