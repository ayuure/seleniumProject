package com.example.TestCase;

import com.example.demo4.BaseClass;
import com.example.pages.ElementPage;
import com.example.pages.HomePage;
import com.example.pages.LinksPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LinksPageTest extends BaseClass {
    private LinksPage linksPage;
    private SoftAssert softAssert;
    public void setup(){
        linksPage = new LinksPage();
        softAssert = new SoftAssert();
    }
    public void set() throws InterruptedException {
        setup();
        HomePage homePage = new HomePage();
        ElementPage elementPage = new ElementPage();
        elementPage = homePage.ClickOnElement();
        linksPage = elementPage.clickOnLinks();
    }

    @Test
    public void verifyLinksPage() throws InterruptedException {
        set();
        softAssert.assertEquals(linksPage.verifyPage(), "Links");
    }
    @Test
    public void verifyClickOnHome() throws InterruptedException {
        set();
        linksPage.clickOnHomeLink();
        Thread.sleep(3000);
        softAssert.assertTrue(linksPage.verifyHomePage(), "Page did not switch");
        softAssert.assertAll();
    }

}
