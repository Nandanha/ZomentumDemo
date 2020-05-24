package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage extends TestBase {

    @FindBy(xpath="//h1[contains(text(),'Find the right partners to')]")
    public WebElement pageload;

    public static String pagetitle="CRM Vendor";

    public VendorsPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyVendorsPageTitle(){
        return driver.getTitle();
    }

}