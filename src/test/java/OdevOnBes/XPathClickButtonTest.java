package OdevOnBes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class XPathClickButtonTest {

    public static void main(String[] args) throws InterruptedException {
        //Ready Chrome
        WebDriverManager.chromedriver().setup();
        //Create object
        WebDriver driver = new ChromeDriver();
        // Go to URL
        driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();

        //Test: Click Buttons
        WebElement buttonsButton = driver.findElement(By.xpath("//*[text()='Buttons']"));
        buttonsButton.click();
        Thread.sleep(1000);

        WebElement clickMeButton = driver.findElement(By.xpath("//button[normalize-space()='Click Me']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", clickMeButton);
        clickMeButton.click();
        Thread.sleep(1000);

        WebElement clickMsg = driver.findElement(By.xpath("//*[@id='dynamicClickMessage']"));

        Assert.assertEquals(clickMsg.getText(), "You have done a dynamic click");
        Assert.assertTrue(clickMsg.isDisplayed());

        driver.quit();
    }
}
