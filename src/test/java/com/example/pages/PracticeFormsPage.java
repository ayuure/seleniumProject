package com.example.pages;

import com.example.demo4.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

// page_url = about:blank

import java.util.Scanner;

public class PracticeFormsPage extends BaseClass {
    Scanner input = new Scanner(System.in);
    @FindBy(css = "div[class='practice-form-wrapper'] h5")
    private WebElement headerFormPage;
    @FindBy(id = "firstName")
    private WebElement firstname;
    @FindBy(id = "lastName")
    private WebElement lastname;
    @FindBy(id = "userEmail")
    private WebElement email;
   @FindAll({
           @FindBy(css = "label[for='gender-radio-1']"),
           @FindBy(css = "label[for='gender-radio-2']"),
           @FindBy(css = "label[for='gender-radio-3']")
   })
   private List<WebElement> genders;
    @FindBy(id = "userNumber")
    private WebElement number;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;
    @FindBy(className = "react-datepicker__month-select")
    private WebElement month;
    @FindBy(className = "react-datepicker__year-select")
    private WebElement year;

    @FindBy(className = "react-datepicker__day--001")
    private WebElement day;

    @FindBy(id = "subjectsInput")
    private WebElement subject;

    @FindAll({
            @FindBy(css="label[for='hobbies-checkbox-1']"),
            @FindBy(css="label[for='hobbies-checkbox-2']"),
            @FindBy(css="label[for='hobbies-checkbox-3']")
    })
    private List<WebElement> hobbies;
    @FindBy(id = "uploadPicture")
    private WebElement chooseFile;
    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "react-select-3-input")
    private WebElement dropDownArrow;
    @FindAll({
            @FindBy(id = "react-select-3-option-0"),
            @FindBy(id="react-select-3-option-1"),
            @FindBy(id = "react-select-3-option-2"),
            @FindBy(id = "react-select-3-option-3")
    })
    private List<WebElement> states;
@FindBy(id = "react-select-4-input")
private WebElement city;

@FindBy(id = "react-select-4-option-0")
private WebElement option;

    public PracticeFormsPage() {
        PageFactory.initElements(driver, this);
    }
    public boolean verifyPracticePage() throws InterruptedException {
        Thread.sleep(3000);
        return headerFormPage.isDisplayed();
    }


    public void fillForm() throws InterruptedException {
        firstname.sendKeys("bertina");
        lastname.sendKeys("ayuure");
        email.sendKeys("be@gmail.com");



        //Generate random numbers
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        Thread.sleep(3000);
        genders.get(randomNumber).click();

        number.sendKeys("0234567890");

        dateOfBirth.click();
        Thread.sleep(3000);
        month.click();
        Thread.sleep(3000);
        Select select = new Select(month);

        randomNumber = random.nextInt(12);
        Thread.sleep(3000);
        select.selectByIndex(randomNumber);
        Thread.sleep(3000);

         select= new Select(year);
         select.selectByVisibleText("2000");
         Thread.sleep(3000);
         day.click();
         Thread.sleep(3000);

         subject.sendKeys("Science");
         Thread.sleep(3000);
//       subject.sendKeys(Keys.ARROW_DOWN);
         subject.sendKeys(Keys.ENTER);

         Thread.sleep(3000);
         randomNumber = random.nextInt(3);
         Thread.sleep(3000);
         hobbies.get(randomNumber).click();
        System.out.println("Enter file path");
        uploadImage(driver);

        // uploadImageLogic();



         currentAddress.sendKeys("Anaji");
         JavascriptExecutor js = (JavascriptExecutor) driver;
//
//           js.executeScript("arguments[0].click()",dropDownArrow);
        driver.manage().window().setSize(new Dimension(472, 756));
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Actions actions = new Actions(driver);
        actions.moveToElement(dropDownArrow).click().perform();
        states.get(0).click();

//        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        actions.moveToElement(city).click().perform();
//        driver.findElement(By.id("react-select-4-option-0")).click();
        option.click();
//        driver.manage().window().maximize();

//         dropDownArrow.click();
         Thread.sleep(3000);

        //randomNumber = random.nextInt(2);
       // js.executeScript("arguments[0].click()",states.get(1));

    }

    //upload image from machine with a specified file path
    private void uploadImage(WebDriver driver){
        Scanner input = new Scanner(System.in);
        String imageFilePath = input.nextLine();
        chooseFile.sendKeys(imageFilePath);



        input.close();
    }
//    private void uploadImageLogic(){
//
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("pick 1 to automatically upload an image file or 2 to tpe file path ");
//
//        // Create a separate thread to handle the timeout logic
//        Thread timeoutThread = new Thread(() -> {
//            try {
//                System.out.println("Ernest");
//                Thread.sleep(10000);
//
//                System.out.println("Bryace");
//                // Wait for 30 seconds
//            } catch (InterruptedException e) {
//                // Interrupted, do nothing
//            } finally {
//                System.out.println("here");
//                if (!scanner.hasNext()) {
//                    // No input received, select 1 automatically
//                    System.out.println("No input received. Selecting 1 automatically.");
//                    processUserInput(1);
//                    chooseFile.sendKeys("src/test/java/com/example/images/snap.PNG");
//                }
//                else {
//                    System.out.println("This is an else");
//                    System.out.println(scanner.nextInt());
//                }
//            }
//        });
//
//        timeoutThread.start();
//
//        // Wait for user input
//        if (scanner.hasNextInt()) {
//            int userInput = scanner.nextInt();
//            processUserInput(userInput);
//        }
//
//        // Stop the timeout thread if it's still running
//        timeoutThread.interrupt();
//    }
//
//    private void processUserInput(int userInput) {
//        // Process the user input here
//        Scanner input = new Scanner(System.in);
//        String imageFilePath = input.nextLine();
//        chooseFile.sendKeys(imageFilePath);
//    }

}

