package com.example.pages;

import com.example.demo4.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

// page_url = about:blank
public class LinksPage extends BaseClass {
    @FindBy(className = "main-header")
    private WebElement logo;
    @FindBy(id = "simpleLink")
    private WebElement home;



    @FindBy(className = "banner-image")
    private WebElement banner;

    public LinksPage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyPage() throws InterruptedException {
        Thread.sleep(3000);
        String text =logo.getText();
        return text;
    }
    public void clickOnHomeLink(){
        home.click();
        ArrayList<String>tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

    }
    public boolean verifyHomePage(){
        boolean isDisplayed=banner.isDisplayed();
        return isDisplayed;

    }

}