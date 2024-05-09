package com.example.TestCase;

import com.example.demo4.BaseClass;
import com.example.pages.ElementPage;
import com.example.pages.HomePage;
import com.example.pages.TextBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TextBoxPageTest extends BaseClass {
    private  TextBoxPage textBoxPage;
    private SoftAssert softAssert;
    @BeforeMethod
    public void setup(){
        textBoxPage = new TextBoxPage();
        softAssert = new SoftAssert();

    }
    public void set() throws InterruptedException {
        HomePage homePage = new HomePage();
        ElementPage elementPage= new ElementPage();
        elementPage= homePage.ClickOnElement();
        textBoxPage=elementPage.clickOnTextBox();


    }
    @Test(priority = 1)
    public void verifyTextLogoIsPresent() throws InterruptedException {
        set();
        boolean flag=textBoxPage.validateTextBoxPage();
        softAssert.assertTrue(flag,"Logo is not visible");
        softAssert.assertAll();

    }
    @Test(priority = 2)
    public void verifyTextBoxTextIsPresent() throws InterruptedException {
        set();
        String actualText=textBoxPage.ValidateTextBoxText();
        String expectedText="Text Box";
        Thread.sleep(4000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualText,expectedText,"Text do not match");
        softAssert.assertAll();


    }
    @Test(priority = 3)
    public void fillForm() throws InterruptedException {
        HomePage homePage = new HomePage();
        ElementPage elementPage= new ElementPage();
        elementPage= homePage.ClickOnElement();
        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage=elementPage.clickOnTextBox();

        textBoxPage.fillFullNameField();
        textBoxPage.fillEmailField();
        textBoxPage.fillCurrentAddressField();
        textBoxPage.fillPermanentAddressField();
        textBoxPage.clickOnSubmit();
        SoftAssert softAssert= new SoftAssert();

        boolean visible=textBoxPage.isVisible();
        softAssert.assertTrue(visible);

        boolean flag=textBoxPage.verifyFormContainsFullName();
        softAssert.assertTrue(flag, "full name is not visible");


        boolean emailFlag = textBoxPage.verifyFormContainsEmail();
        softAssert.assertTrue(emailFlag,"Email is not visible");


        boolean currentAddressFlag= textBoxPage.verifyFormContainsCurrentAddress();
        softAssert.assertTrue(currentAddressFlag,"Current Address is not present");

        boolean permanentAddress = textBoxPage.verifyFormContainsPermanentAddress();
        softAssert.assertTrue(permanentAddress,"Permanent Address is not visible");

        softAssert.assertAll();

    }


}
