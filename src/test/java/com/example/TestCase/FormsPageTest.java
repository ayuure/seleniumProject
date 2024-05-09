package com.example.TestCase;

import com.example.demo4.BaseClass;
import com.example.pages.ElementPage;
import com.example.pages.FormsPage;
import com.example.pages.HomePage;
import com.example.pages.LinksPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FormsPageTest extends BaseClass {
    private FormsPage formsPage;
    private SoftAssert softAssert;
    public void setup(){
        formsPage = new FormsPage();
        softAssert = new SoftAssert();
    }
    public void set() throws InterruptedException {
        setup();
        HomePage homePage = new HomePage();
        formsPage= homePage.clickOnForms();
    }
    @Test
    public void verifyFormsPage() throws InterruptedException {
        set();
        softAssert.assertEquals(  formsPage.verifyFormsPage(), "Forms", "Page is not visible");
        softAssert.assertAll();
    }


    }


