package com.example.TestCase;

import com.example.demo4.BaseClass;
import com.example.pages.ElementPage;
import com.example.pages.HomePage;
import com.example.pages.WebTablePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebTablePageTest extends BaseClass {
    private WebTablePage webTablePage;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        webTablePage = new WebTablePage();
        softAssert = new SoftAssert();
    }
    public void set() throws InterruptedException {
        HomePage homePage = new HomePage();
        ElementPage elementPage = new ElementPage();
        elementPage = homePage.ClickOnElement();
        webTablePage=elementPage.clickOnWebTable();
    }
    @Test
    public void validateWebTablePage() throws InterruptedException {
        set();
        String webTableText= webTablePage.verifyWebTableIsVisible();
        softAssert.assertEquals(webTableText,"Web Tables","Page is not visible");
        softAssert.assertAll();

    }
    @Test
    public void clickOnAddBtn() throws InterruptedException {
        set();
        webTablePage.clickOnAdd();
    }
    @Test
    public void fillForm() throws InterruptedException {
        clickOnAddBtn();
        webTablePage.fillForm();
    }
    @Test
    public void verifyFormIsPresent() throws InterruptedException {
        fillForm();
        boolean webTableTextFlag=webTablePage.verifyFormIsVisible();
        softAssert.assertTrue(webTableTextFlag);
        softAssert.assertAll();
    }
    @Test
    public void verifyDetailsArePresentOnTheForm() throws InterruptedException {
        fillForm();
        String firstname=webTablePage.verifyFirstnameIsFilled();
        softAssert.assertEquals(firstname,"Bertina","Firstname does not match input");

        String lastname = webTablePage.verifyLastnameIsFilled();
        softAssert.assertEquals(lastname,"Ayuure","Lastname does not match input");

        String email=webTablePage.verifyEmailIsFilled();
        softAssert.assertEquals(email,"bertina@gmail.com","email does not match input");

        String age = webTablePage.verifyAgeIsFilled();
        softAssert.assertEquals(age,"19","Salary does not match input");

        String salary = webTablePage.verifySalaryIsFilled();
        softAssert.assertEquals(salary,"1230");

        String department= webTablePage.verifyDepartmentIsFilled();
        softAssert.assertEquals(department,"IT support");

        softAssert.assertAll();
    }

    @Test
    public void verifyDetailsHasBeenAddedToTheTable() throws InterruptedException {
        verifyFormIsPresent();
        webTablePage.clickONSubmitBtn();
        webTablePage.getTable();
//
////        Thread.sleep(5000);
//        String html= "<div class=\"rt-tbody\" style=\"min-width: 600px;\"><div class=\"rt-tr-group\" role=\"rowgroup\"><div class=\"rt-tr -odd\" role=\"row\"><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">Cierra</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">Vega</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 40 0 auto; width: 40px; max-width: 40px;\">39</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">cierra@example.com</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\">10000</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">Insurance</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><div class=\"action-buttons\"><span class=\"mr-2\" data-toggle=\"tooltip\" title=\"Edit\" id=\"edit-record-1\"><svg stroke=\"currentColor\" fill=\"currentColor\" stroke-width=\"0\" viewBox=\"0 0 1024 1024\" height=\"1em\" width=\"1em\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M880 836H144c-17.7 0-32 14.3-32 32v36c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-36c0-17.7-14.3-32-32-32zm-622.3-84c2 0 4-.2 6-.5L431.9 722c2-.4 3.9-1.3 5.3-2.8l423.9-423.9a9.96 9.96 0 0 0 0-14.1L694.9 114.9c-1.9-1.9-4.4-2.9-7.1-2.9s-5.2 1-7.1 2.9L256.8 538.8c-1.5 1.5-2.4 3.3-2.8 5.3l-29.5 168.2a33.5 33.5 0 0 0 9.4 29.8c6.6 6.4 14.9 9.9 23.8 9.9z\"></path></svg></span> <span id=\"delete-record-1\" data-toggle=\"tooltip\" title=\"Delete\"><svg stroke=\"currentColor\" fill=\"currentColor\" stroke-width=\"0\" viewBox=\"0 0 1024 1024\" height=\"1em\" width=\"1em\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M864 256H736v-80c0-35.3-28.7-64-64-64H352c-35.3 0-64 28.7-64 64v80H160c-17.7 0-32 14.3-32 32v32c0 4.4 3.6 8 8 8h60.4l24.7 523c1.6 34.1 29.8 61 63.9 61h454c34.2 0 62.3-26.8 63.9-61l24.7-523H888c4.4 0 8-3.6 8-8v-32c0-17.7-14.3-32-32-32zm-200 0H360v-72h304v72z\"></path></svg></span></div></div></div></div><div class=\"rt-tr-group\" role=\"rowgroup\"><div class=\"rt-tr -even\" role=\"row\"><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">Alden</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">Cantrell</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 40 0 auto; width: 40px; max-width: 40px;\">45</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">alden@example.com</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\">12000</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">Compliance</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><div class=\"action-buttons\"><span class=\"mr-2\" data-toggle=\"tooltip\" title=\"Edit\" id=\"edit-record-2\"><svg stroke=\"currentColor\" fill=\"currentColor\" stroke-width=\"0\" viewBox=\"0 0 1024 1024\" height=\"1em\" width=\"1em\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M880 836H144c-17.7 0-32 14.3-32 32v36c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-36c0-17.7-14.3-32-32-32zm-622.3-84c2 0 4-.2 6-.5L431.9 722c2-.4 3.9-1.3 5.3-2.8l423.9-423.9a9.96 9.96 0 0 0 0-14.1L694.9 114.9c-1.9-1.9-4.4-2.9-7.1-2.9s-5.2 1-7.1 2.9L256.8 538.8c-1.5 1.5-2.4 3.3-2.8 5.3l-29.5 168.2a33.5 33.5 0 0 0 9.4 29.8c6.6 6.4 14.9 9.9 23.8 9.9z\"></path></svg></span> <span id=\"delete-record-2\" data-toggle=\"tooltip\" title=\"Delete\"><svg stroke=\"currentColor\" fill=\"currentColor\" stroke-width=\"0\" viewBox=\"0 0 1024 1024\" height=\"1em\" width=\"1em\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M864 256H736v-80c0-35.3-28.7-64-64-64H352c-35.3 0-64 28.7-64 64v80H160c-17.7 0-32 14.3-32 32v32c0 4.4 3.6 8 8 8h60.4l24.7 523c1.6 34.1 29.8 61 63.9 61h454c34.2 0 62.3-26.8 63.9-61l24.7-523H888c4.4 0 8-3.6 8-8v-32c0-17.7-14.3-32-32-32zm-200 0H360v-72h304v72z\"></path></svg></span></div></div></div></div><div class=\"rt-tr-group\" role=\"rowgroup\"><div class=\"rt-tr -odd\" role=\"row\"><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">Kierra</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">Gentry</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 40 0 auto; width: 40px; max-width: 40px;\">29</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">kierra@example.com</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\">2000</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\">Legal</div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><div class=\"action-buttons\"><span class=\"mr-2\" data-toggle=\"tooltip\" title=\"Edit\" id=\"edit-record-3\"><svg stroke=\"currentColor\" fill=\"currentColor\" stroke-width=\"0\" viewBox=\"0 0 1024 1024\" height=\"1em\" width=\"1em\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M880 836H144c-17.7 0-32 14.3-32 32v36c0 4.4 3.6 8 8 8h784c4.4 0 8-3.6 8-8v-36c0-17.7-14.3-32-32-32zm-622.3-84c2 0 4-.2 6-.5L431.9 722c2-.4 3.9-1.3 5.3-2.8l423.9-423.9a9.96 9.96 0 0 0 0-14.1L694.9 114.9c-1.9-1.9-4.4-2.9-7.1-2.9s-5.2 1-7.1 2.9L256.8 538.8c-1.5 1.5-2.4 3.3-2.8 5.3l-29.5 168.2a33.5 33.5 0 0 0 9.4 29.8c6.6 6.4 14.9 9.9 23.8 9.9z\"></path></svg></span> <span id=\"delete-record-3\" data-toggle=\"tooltip\" title=\"Delete\"><svg stroke=\"currentColor\" fill=\"currentColor\" stroke-width=\"0\" viewBox=\"0 0 1024 1024\" height=\"1em\" width=\"1em\" xmlns=\"http://www.w3.org/2000/svg\"><path d=\"M864 256H736v-80c0-35.3-28.7-64-64-64H352c-35.3 0-64 28.7-64 64v80H160c-17.7 0-32 14.3-32 32v32c0 4.4 3.6 8 8 8h60.4l24.7 523c1.6 34.1 29.8 61 63.9 61h454c34.2 0 62.3-26.8 63.9-61l24.7-523H888c4.4 0 8-3.6 8-8v-32c0-17.7-14.3-32-32-32zm-200 0H360v-72h304v72z\"></path></svg></span></div></div></div></div><div class=\"rt-tr-group\" role=\"rowgroup\"><div class=\"rt-tr -padRow -even\" role=\"row\"><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 40 0 auto; width: 40px; max-width: 40px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div></div></div><div class=\"rt-tr-group\" role=\"rowgroup\"><div class=\"rt-tr -padRow -odd\" role=\"row\"><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 40 0 auto; width: 40px; max-width: 40px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div></div></div><div class=\"rt-tr-group\" role=\"rowgroup\"><div class=\"rt-tr -padRow -even\" role=\"row\"><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 40 0 auto; width: 40px; max-width: 40px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div></div></div><div class=\"rt-tr-group\" role=\"rowgroup\"><div class=\"rt-tr -padRow -odd\" role=\"row\"><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 40 0 auto; width: 40px; max-width: 40px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div></div></div><div class=\"rt-tr-group\" role=\"rowgroup\"><div class=\"rt-tr -padRow -even\" role=\"row\"><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 40 0 auto; width: 40px; max-width: 40px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div></div></div><div class=\"rt-tr-group\" role=\"rowgroup\"><div class=\"rt-tr -padRow -odd\" role=\"row\"><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 40 0 auto; width: 40px; max-width: 40px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div></div></div><div class=\"rt-tr-group\" role=\"rowgroup\"><div class=\"rt-tr -padRow -even\" role=\"row\"><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 40 0 auto; width: 40px; max-width: 40px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 100 0 auto; width: 100px;\"><span>&nbsp;</span></div><div class=\"rt-td\" role=\"gridcell\" style=\"flex: 80 0 auto; width: 80px; max-width: 80px;\"><span>&nbsp;</span></div></div></div></div>";
//        Document doc = Jsoup.parse(html);
//
//        Elements rows = doc.select("div.rt-tr-group");
//
//        for(Element row : rows){
//            Elements cells = row.select("div.rt-td");
//
//            for(Element cell : cells){
//                String value = cell.text();
//                System.out.println(value);
//
//            }
//            System.out.println();
//        }
//        String data=webTablePage.getTable();
//       // System.out.println(data);
//
//        Document doc = Jsoup.parse(data);
//
//        // Find all rows in the table body
//        Elements rows = doc.select("div.rt-tr");
//
//        Element lastRowWithData = null;
//
//        // Iterate over the rows in reverse order
//        for (int i = rows.size() - 1; i >= 0; i--) {
//            Element row = rows.get(i);
//            System.out.println(row);
//
//            // Check if the row has any non-empty cells
//            if (row.select("div.rt-td").stream().anyMatch(cell -> !cell.text().trim().isEmpty())) {
//                lastRowWithData = row;
//                System.out.println(lastRowWithData);
//                break;
//            }
//        }
//
//        if (lastRowWithData != null) {
//            // Extract the data from the last row
//            Elements cells = lastRowWithData.select("div.rt-td");
//            for (Element cell : cells) {
//                System.out.println(cell.text().trim());
//            }
//        } else {
//            System.out.println("No data found in the table.");
//        }
    }
}


