package com.example.pages;

import com.example.demo4.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = about:blank
public class ButtonPage extends BaseClass {
    @FindBy (className = "main-header")
    private WebElement buttonsLogo;
    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickBtn;
    @FindBy (id ="doubleClickMessage")
    private WebElement dbClickMessage;
    @FindBy(id = "rightClickBtn")
    private WebElement rightClickBtn;
    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMessage;
    @FindBy(xpath = "(//button[normalize-space()='Click Me'])[1]")
    private WebElement clickMeButton;
    @FindBy (id = "dynamicClickMessage")
    private WebElement dynamicMessage;

    private Actions action;
    public void dependencies(){
        action = new Actions(driver);
    }


    public ButtonPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyLogoPage() throws InterruptedException {
        Thread.sleep(3000);
        String text=buttonsLogo.getText();
        return text;
    }
    public void clickOnTheDoubleClickButton(){
        dependencies();
        action.doubleClick(doubleClickBtn).build().perform();


    }
    public boolean dbClickPerformed(){
        boolean isVisible =dbClickMessage.isDisplayed();
        return isVisible;
    }
    public void rightClick(){
        dependencies();
        action.contextClick(rightClickBtn).build().perform();

    }
    public boolean verifyThatRightClickIsPerformed(){
        boolean isVisible = rightClickMessage.isDisplayed();
        return isVisible;
    }
    public void dynamicClick(){
    clickMeButton.click();
    }
    public boolean verifyDynamicClick(){
        boolean isVisible= dynamicMessage.isDisplayed();
        return isVisible;
    }
}