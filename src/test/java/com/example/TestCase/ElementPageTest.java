package com.example.TestCase;

import com.example.demo4.BaseClass;
import com.example.pages.ElementPage;
import com.example.pages.HomePage;
import com.example.pages.TextBoxPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ElementPageTest extends BaseClass {
    @Test(priority = 1)
    public void validateElementPage() throws InterruptedException {
        HomePage homePage = new HomePage();
        ElementPage elementPage= new ElementPage();
        elementPage= homePage.ClickOnElement();
       boolean isVisible= elementPage.validateElementPage();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(isVisible, "element page is not visible");
        soft.assertAll();

    }
    @Test(priority = 2)
    public void verifyElementTextIsPresent() throws InterruptedException {
        HomePage homePage = new HomePage();
        ElementPage elementPage= new ElementPage();
        elementPage= homePage.ClickOnElement();
        String actualText=elementPage.validateElementText();
        String expectedText ="Elements";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualText,expectedText,"Text do not match");
        softAssert.assertAll();

    }
    @ Test(priority = 3)
    public void clickOnTexBox() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.ClickOnElement();
        TextBoxPage textBoxPage = new TextBoxPage();
        ElementPage elementPage= new ElementPage();
        textBoxPage= elementPage.clickOnTextBox();

    }
}
