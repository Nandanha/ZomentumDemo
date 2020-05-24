package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetADemoPage extends TestBase {
    @FindBy(xpath="//div[contains(text(),'See Zomentum in action!')]")
    public WebElement pageload;

    public static String pagetitle="Get Started with Zomentum";

    public GetADemoPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyGetaDemoPageTitle(){
        return driver.getTitle();
    }

}