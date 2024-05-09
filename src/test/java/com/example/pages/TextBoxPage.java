package com.example.pages;

import com.example.demo4.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseClass {
    @FindBy (id = "userName")
    private WebElement fullName;
    @FindBy (id="userEmail")
    private WebElement userEmail;
    @FindBy (id = "currentAddress")
    private WebElement currentAddress;
    @FindBy (id = "permanentAddress")
    private WebElement permanentAddress;
    @FindBy (css = "button[id='submit']")
    private WebElement submitBtn;
    @FindBy(css=".main-header")
    private WebElement textBoxLogo;
    @FindBy(css ="[class='border col-md-12 col-sm-12']>p[class='mb-1'][id='name']")
    private WebElement name;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(css = "[class='border col-md-12 col-sm-12']>[class='mb-1'][id='currentAddress']")
    private WebElement cAddress;
    @FindBy(css = "[class='border col-md-12 col-sm-12']>p[class='mb-1'][id='permanentAddress']")
    private WebElement pAddress;

    public TextBoxPage() {
        PageFactory.initElements(driver,this);
    }
    public boolean validateTextBoxPage(){
        textBoxLogo.isDisplayed();
        return true;
    }
    public String ValidateTextBoxText(){
        String text= textBoxLogo.getText();
        return text;
    }


    public void fillFullNameField(){
        fullName.sendKeys("Bertina Ayuure");
    }
    public void fillEmailField(){
        userEmail.sendKeys("betina@gmail.com");
    }
    public void fillCurrentAddressField(){
        currentAddress.sendKeys("Anaji");
    }
    public void fillPermanentAddressField(){
        permanentAddress.sendKeys("Canada");
    }
    public void clickOnSubmit() throws InterruptedException {

        Thread.sleep(4000);
        scrollIntoView(submitBtn);
        Actions actions = new Actions(driver);
        actions.moveToElement(submitBtn).click().perform();
    }
    private void scrollIntoView(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public boolean isVisible(){
        name.isDisplayed();
        return true;
    }
    public boolean verifyFormContainsFullName() throws InterruptedException {
        Thread.sleep(5000);
        String nameText = name.getText();
        return nameText.contains("Bertina Ayuure");
    }
    public boolean verifyFormContainsEmail() {
        String emailText = email.getText();
        return emailText.contains("betina@gmail.com");
    }
    public boolean verifyFormContainsCurrentAddress()  {
        String currentAddressText = cAddress.getText();
        return currentAddressText.contains("Anaji");
    }
    public boolean verifyFormContainsPermanentAddress(){
        String permanentAddressText = pAddress.getText();
        System.out.println(permanentAddressText);
        return permanentAddressText.contains("Canada");

    }




}
