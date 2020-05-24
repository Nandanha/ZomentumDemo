package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingPage extends TestBase {

    @FindBy(xpath="//h1[contains(text(),'Everything You Need in a Single Plan!')]")
    public WebElement pageload;

    public static String pagetitle="Pricing For MSP Sales Software | Zomentum";

    public PricingPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyPricingPageTitle(){
        return driver.getTitle();
    }

}