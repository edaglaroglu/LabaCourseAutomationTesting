package OdevOnBes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class XPAthAddRecordTest {

    public static void main(String[] args) throws InterruptedException {
        //Ready Chrome
        WebDriverManager.chromedriver().setup();
        //Create object
        WebDriver driver = new ChromeDriver();
        // Go to URL
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        WebElement addButton = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        addButton.click();
        Thread.sleep(2000);

        //fill out form field
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Elif");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Dağ");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("elif@gmail.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("50");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("50000");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("HR");
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        //Edit form field
        WebElement editIconButton = driver.findElement(By.xpath("//div[text()='elif@gmail.com']/ancestor::div[@role='row']//span[starts-with(@id,'edit-record')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", editIconButton);
        editIconButton.click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='firstName']")).clear();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Duygu");

        driver.findElement(By.xpath("//input[@id='lastName']")).clear();
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("G");

        driver.findElement(By.xpath("//input[@id='userEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("duygu@c.com");

        driver.findElement(By.xpath("//input[@id='age']")).clear();
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("55");

        driver.findElement(By.xpath("//input[@id='salary']")).clear();
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("5500");

        driver.findElement(By.xpath("//input[@id='department']")).clear();
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("IT");

        driver.findElement(By.xpath("//button[@id='submit']")).click();

        String actualEmail = driver.findElement(By.xpath("//div[text()='duygu@c.com']")).getText();
        Assert.assertEquals(actualEmail, "duygu@gmail.com");

        Thread.sleep(2000);

        driver.quit();

    }

}
