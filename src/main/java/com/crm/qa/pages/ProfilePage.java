package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends TestBase {

    @FindBy(xpath = "//div[@class='first-name cmn-label']/input")
    public WebElement profName;

    @FindBy(xpath = "(//div[@class='email cmn-label']/input)[1]")
    public  WebElement profUsername;

    @FindBy(xpath = "(//div[@class='email cmn-label']/input)[2]")
    public  WebElement profEmail;

    @FindBy(xpath = "//button[@class='change-pass button-active button-inactive']")
    public WebElement changePwd;

    @FindBy(xpath = "//button[@class='change-pass randonmize_button button-active button-inactive']")
    public WebElement changeBgImage;

    @FindBy(xpath = "//button[@class='active']")
    public WebElement saveChanges;

    @FindBy(xpath = "//input[@name='old_password']")
    public WebElement oldPwd;

    @FindBy(xpath = "//input[@name='confirm_password']")
    public WebElement confirmPwd;

    @FindBy(xpath = "//input[@name='new_password']")
    public WebElement newPwd;

    @FindBy(xpath = "//div[@class='header-text']")
    public WebElement ChangePwdHeader;

    @FindBy(xpath = "//button[@id='confirm_top_button']")
    public WebElement done;

    @FindBy(xpath = "//p[@class='validaton-fail password-err']")
    public WebElement pwdErrorMessage;

    @FindBy(xpath = "//span[@class='back-from-profile']")
    public WebElement backbutton;

    @FindBy(xpath = "//div[@class='fb-profile']/a/img")
    public  WebElement feebackInProfile;

    @FindBy(xpath = "//div[@class='update_img']/following-sibling::input")
    public WebElement updateProfilePic;
}