package com.example.pages;

import com.example.demo4.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = about:blank
public class FormsPage extends BaseClass {
    @FindBy(className = "main-header")
    private WebElement formsLogo;
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-0']")
    private WebElement practiceForms;

    public FormsPage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyFormsPage(){
        String text=formsLogo.getText();
        return text;
    }
    public PracticeFormsPage clickOnPracticeForm() throws InterruptedException {
        Thread.sleep(3000);
        practiceForms.click();
        return new PracticeFormsPage();
    }

    }

