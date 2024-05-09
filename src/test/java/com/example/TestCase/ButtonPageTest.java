package com.example.TestCase;

import com.example.demo4.BaseClass;
import com.example.pages.ButtonPage;
import com.example.pages.ElementPage;
import com.example.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class ButtonPageTest extends BaseClass {
    private ButtonPage buttonPage;
    private SoftAssert softAssert;
    public void setup(){
        buttonPage = new ButtonPage();
        softAssert = new SoftAssert();

    }
    public void set() throws InterruptedException {
        setup();
        HomePage homePage = new HomePage();
        ElementPage elementPage = new ElementPage();
        elementPage = homePage.ClickOnElement();
        buttonPage =elementPage.clickOnButton();
    }
    @Test
    public void verifyButtonPage() throws InterruptedException {
        set();
        String buttonText = buttonPage.verifyLogoPage();
        softAssert.assertEquals(buttonText,"Buttons", "Text does not match");
        softAssert.assertAll();
    }
    @Test
    public void dbClick() throws InterruptedException {
        set();
        buttonPage.clickOnTheDoubleClickButton();
        softAssert.assertTrue(buttonPage.dbClickPerformed(), "Double click was not performed");
        softAssert.assertAll();
    }
    @Test
    public void rightClick() throws InterruptedException {
        set();
        buttonPage.rightClick();
        softAssert.assertTrue(buttonPage.verifyThatRightClickIsPerformed(), "right click did not happen");
        softAssert.assertAll();
    }
    @Test void dynamicClick() throws InterruptedException {
        set();
        buttonPage.dynamicClick();
        softAssert.assertEquals(buttonPage.verifyDynamicClick(), "Click did not happen");
    }
}
