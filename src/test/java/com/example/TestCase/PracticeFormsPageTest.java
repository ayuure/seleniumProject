package com.example.TestCase;

import com.example.demo4.BaseClass;
import com.example.pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeFormsPageTest extends BaseClass {
    private PracticeFormsPage practiceFormsPage;
    private SoftAssert softAssert;
    public void setup(){
        practiceFormsPage = new PracticeFormsPage();
        softAssert = new SoftAssert();

    }
    public void set() throws InterruptedException {
        setup();
        HomePage homePage = new HomePage();
        homePage.clickOnForms();
        FormsPage  formsPage = new FormsPage();
        practiceFormsPage =formsPage.clickOnPracticeForm();

    }
    @Test
    public void verifyPracticeFormPage() throws InterruptedException {
        set();
        softAssert.assertTrue(practiceFormsPage.verifyPracticePage(),"Page is not displayed");
        softAssert.assertAll();

    }
    @Test
    public void fillForm() throws InterruptedException {
        set();
        practiceFormsPage.fillForm();
    }
   // @Test


}
