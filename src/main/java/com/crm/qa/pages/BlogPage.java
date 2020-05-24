package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage extends TestBase {

    @FindBy(xpath="//h4[contains(text(),'New')]")
    public WebElement pageload;

    public static String pagetitle="Zomentum's Blog | Blogs on MSP Sales, Efficiency & More!";

    public BlogPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyBlogPageTitle(){
        System.out.println("blog page title:"+driver.getTitle());
        return driver.getTitle();
    }

}
