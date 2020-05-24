package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class IntegrationPage  extends TestBase {
    @FindBy(xpath="//h1[contains(text(),'We play well with all your favorite tools')]")
    public WebElement pageload;

    public static String pagetitle="An MSP sales solution that Integrates With the Tools You Use | Zomentum";

    public IntegrationPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyIntegrationPageTitle(){
        return driver.getTitle();
    }

}
