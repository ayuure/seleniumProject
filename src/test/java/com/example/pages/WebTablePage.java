package com.example.pages;

import com.example.demo4.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.regex.Pattern;

import java.util.List;

public class WebTablePage extends BaseClass {
    @FindBy(className = "main-header")
    private WebElement webTableLogo;
    @FindBy (id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(className = "modal-content")
    private WebElement content;
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(id ="userEmail" )
    private WebElement email;
    @FindBy(id = "age")
    private WebElement ageField;
    @FindBy(id ="salary" )
    private WebElement salaryField;
    @FindBy(id = "department")
    private WebElement departmentField;
    @FindBy(id="submit")
    private WebElement submitBtn;
    @FindBy(className = "rt-tbody")
    private WebElement table;
    public WebTablePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyWebTableIsVisible() throws InterruptedException {
        Thread.sleep(5000);
       String text= webTableLogo.getText();
       return text;

    }

    public void clickOnAdd(){
        addElement.click();

    }
    public boolean verifyFormIsVisible(){
        content.isDisplayed();
        return true;
    }
    public void fillForm() throws InterruptedException {
        Thread.sleep(5000);
        firstNameField.sendKeys("Bertina");
        lastNameField.sendKeys("Ayuure");
        email.sendKeys("bertina@gmail.com");
        ageField.sendKeys("19");
        salaryField.sendKeys("1230");
        departmentField.sendKeys("IT support");
        Thread.sleep(5000);


    }
    public String verifyFirstnameIsFilled() {
       String firstnameValue= firstNameField.getAttribute("value");
       return firstnameValue;

    }
    public  String verifyLastnameIsFilled(){
        String lastnameValue = lastNameField.getAttribute("value");
        return lastnameValue;
    }
    public String verifyAgeIsFilled(){
        String ageValue = ageField.getAttribute("value");
        return ageValue;
    }
    public String verifyEmailIsFilled(){
        String emailValue = email.getAttribute("value");
        return emailValue;
    }
    public String verifySalaryIsFilled(){
        String salaryValue = salaryField.getAttribute("value");
        return salaryValue;
    }
    public String verifyDepartmentIsFilled(){
        String departmentValue = departmentField.getAttribute("value");
        return departmentValue;
    }
    public void clickONSubmitBtn(){
        submitBtn.click();

    }
    public void getTable() throws InterruptedException{
        Thread.sleep(5000);

       List<WebElement> rows=table.findElements(By.className("rt-tr-group"));
        WebElement lastRowWithData = null;

        for (int i = rows.size() - 1; i >= 0; i--) {
         WebElement row = rows.get(i);
            //System.out.println(row);
          // Check if the row has any non-empty cells

          if (!row.findElement(By.className("rt-tr")).getText().isEmpty()) {
               lastRowWithData = row;
              System.out.println(lastRowWithData.getText());
              System.out.println("FIRST");
              break;
           }
       }


      if (lastRowWithData != null) {

          // Extract the data from the last row
          List<WebElement> cells = lastRowWithData.findElements(By.className("rt-td"));
          System.out.println(cells.size());
          for (WebElement  cell : cells) {

              Thread.sleep(5000);
              System.out.println("Inside the loop");
              System.out.println(cell.isDisplayed());
              String text=cell.getText();
              System.out.println(text);
           }
       } else {
          System.out.println("THIRD");
           System.out.println("No data found in the table.");
       }



    }
        }










