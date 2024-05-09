package com.example.pages;

import com.example.demo4.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ElementPage extends BaseClass {
    @FindBy(css ="body > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1)" )
    private WebElement textBox;
    @FindBy (css = "div[class='element-list collapse show'] li[id='item-1'] span[class='text']")
    private WebElement checkBox;
    @FindBy(css=".main-header")
    private WebElement elementLogo;
    @FindBy(css = "body > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(4)")
    private WebElement webTable;

    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-4']")
    private WebElement buttons;
    @FindBy(xpath = "(//li[@id='item-5'])[1]")
    private WebElement links;
    public ElementPage(){
        PageFactory.initElements(driver, this);
    }
    @Test
    public boolean validateElementPage(){
        elementLogo.isDisplayed();
        return true;

    }
    public String validateElementText(){
       String elementText= elementLogo.getText();
       return elementText;
    }

    public TextBoxPage clickOnTextBox(){
        textBox.click();
        return new TextBoxPage();
    }

    public CheckBoxPage clickOnCheckBox(){
        checkBox.click();
        return new CheckBoxPage();
    }

    public ButtonPage clickOnButton(){
        buttons.click();
        return new ButtonPage();
    }
    public WebTablePage clickOnWebTable(){
        webTable.click();
        return new WebTablePage();

    }
    private void scrollIntoView(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public LinksPage clickOnLinks() throws InterruptedException {
        scrollIntoView(links);
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(links).click().perform();
        return new LinksPage();

    }

}
