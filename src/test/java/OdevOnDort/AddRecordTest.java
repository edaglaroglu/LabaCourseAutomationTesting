package OdevOnDort;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class AddRecordTest {

    public static void main(String[] args) throws InterruptedException {

        //Ready Chrome
        WebDriverManager.chromedriver().setup();
        //Create object
        WebDriver driver = new ChromeDriver();
        //Go to URL
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();


        //Test: Add record
        WebElement addButton = driver.findElement(By.cssSelector("#addNewRecordButton"));
        addButton.click();
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));

        List<WebElement> formFields =
                driver.findElements(By.cssSelector("form > div > div:nth-of-type(2) input"));

        //System.out.println(formFields.size());

        for (WebElement formField : formFields) {
            String placeHolder = formField.getAttribute("placeholder");

            switch (placeHolder){
                case "First Name":
                    formField.sendKeys("Duygu Elif");
                    break;
                case "Last Name":
                    formField.sendKeys("Dağlaroğlu");
                    break;
                case "name@example.com":
                    formField.sendKeys("elif@elif.com");
                    break;
                case "Age":
                    formField.sendKeys("50");
                    break;
                case "Salary":
                    formField.sendKeys("50000");
                    break;
                case "Department":
                    formField.sendKeys("HR");
                    break;
            }
        }

        submitButton.click();

        //Edit Form
        WebElement editIcon = driver.findElement(By.cssSelector("#edit-record-4"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", editIcon);
        editIcon.click();
        Thread.sleep(1000);

        List<WebElement> editFields =
                driver.findElements(By.cssSelector("form > div > div:nth-of-type(2) input"));

        for (WebElement formField : editFields) {
            String placeHolder = formField.getAttribute("placeholder");

            switch (placeHolder){
                case "First Name":
                    formField.clear();
                    formField.sendKeys("Elif");
                    break;
                case "Last Name":
                    formField.clear();
                    formField.sendKeys("Can");
                    break;
                case "name@example.com":
                    formField.clear();
                    formField.sendKeys("elif@gmail.com");
                    break;
                case "Age":
                    formField.clear();
                    formField.sendKeys("60");
                    break;
                case "Salary":
                    formField.clear();
                    formField.sendKeys("60000");
                    break;
                case "Department":
                    formField.clear();
                    formField.sendKeys("IT");
                    break;
            }
        }

        String actualSurname = driver.findElement(By.cssSelector("#lastName")).getAttribute("value");
        Assert.assertEquals(actualSurname, "Can");

        WebElement editSubmitButton = driver.findElement(By.cssSelector("#submit"));
        editSubmitButton.click();



        driver.quit();


    }
}
