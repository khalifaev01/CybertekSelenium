package selenium2022.SwitchingTab;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium2022.Utilities.BrowserFactory;
import selenium2022.Utilities.BrowserUtils;

public class PopUpPractice {

    /*
    to click ok -> driver.switchTo().alert().accept();
    to  click cancel -> driver.switchTo().alert().dismiss();
    To enter some text -> driver.switchTo().alert().sendKeys("Cyber");
     */


    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }

    @Test(description = "Click on button 1 and click OK in pop up message")
    public void test1() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        BrowserUtils.wait(4);

        // to deal with popup, we can create object of Alert
        Alert alert = driver.switchTo().alert();
        alert.accept();            // to click ok

        BrowserUtils.wait(4);
    }

    @Test(description = "Click on button 2 and click on  Cancel in pop up message")
    public void test2() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[2]")).click();

        BrowserUtils.wait(4);

        Alert alert = driver.switchTo().alert();
        // print text of popup message
        System.out.println(alert.getText());

        alert.dismiss();    // to click cancel
        BrowserUtils.wait(2);
        // to print text of  result
        System.out.println(driver.findElement(By.id("result")).getText());
    }

    @Test(description ="Click on  button 3, enter some text and then click OK")
    public void test3() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        BrowserUtils.wait(3);

        driver.switchTo().alert().sendKeys("Java is fun!");
        driver.switchTo().alert().accept();

        BrowserUtils.wait(4);
        // to print text of  result
        System.out.println(driver.findElement(By.id("result")).getText());

        BrowserUtils.wait(4);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
