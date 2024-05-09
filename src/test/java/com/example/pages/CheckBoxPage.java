package com.example.pages;

import com.example.demo4.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage extends BaseClass {

    @FindBy(className = "main-header")
    private WebElement checkBoxLogo;
    @FindBy(css = "[class='rct-checkbox']>svg")
    private WebElement check;
    @FindBy(id = "result")
    private static WebElement result;
    public CheckBoxPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean verifyCheckBoxPage() throws InterruptedException {
        Thread.sleep(4000);
        String checkBoxText= checkBoxLogo.getText();
        return checkBoxText.contains("Check Box");
    }
    public void clickOnCheck() throws InterruptedException {
        Thread.sleep(4000);
        check.click();
    }
    public static boolean verifyCheckButtonHasBeenClicked() throws InterruptedException {
        Thread.sleep(4000);
        boolean isDisplayed =result.isDisplayed();
       return  isDisplayed;

    }

}
