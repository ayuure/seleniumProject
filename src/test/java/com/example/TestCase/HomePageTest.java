package com.example.TestCase;

import com.example.demo4.BaseClass;
import com.example.pages.ElementPage;
import com.example.pages.HomePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.lang.model.element.Element;

public class HomePageTest extends BaseClass {


    @Test(priority = 1)
    public void validateHomePage() throws InterruptedException{
        HomePage homePage = new HomePage();
        homePage.verifyHomePage();
    }
    @Test(priority = 2)
    public void clickElement() throws InterruptedException {
        HomePage homePage = new HomePage();
        ElementPage elementPage= new ElementPage();
        elementPage = homePage.ClickOnElement();
    }


}
