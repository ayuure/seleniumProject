package com.example.TestCase;

import com.example.demo4.BaseClass;
import com.example.pages.ElementPage;
import com.example.pages.HomePage;
import com.example.pages.CheckBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckBoxPageTest extends BaseClass {
    private CheckBoxPage checkBoxPage;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        checkBoxPage = new CheckBoxPage();
        softAssert = new SoftAssert();
    }

    public void set() throws InterruptedException {
        HomePage homePage = new HomePage();
        ElementPage elementPage = new ElementPage();
        elementPage = homePage.ClickOnElement();
       checkBoxPage= elementPage.clickOnCheckBox();
    }

    @Test(priority = 1)
    public void validateCheckBoxPage() throws InterruptedException {
        set();

        boolean checkBoxFlag = checkBoxPage.verifyCheckBoxPage();
        softAssert.assertTrue(checkBoxFlag, "Page is not visible");

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void clickOnCheck() throws InterruptedException {
        set();

        checkBoxPage.clickOnCheck();

        boolean isSelected = CheckBoxPage.verifyCheckButtonHasBeenClicked();

        softAssert.assertTrue(isSelected ,"Page is not visible");

        softAssert.assertAll();


    }
}
