package selenium2022.WaitsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium2022.Utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitPractice {
     /*
    Synchronization -> Waits in selenium  : Implicit, Explicit, Fluent

    if selenium is coming before element appear - you will get NoSuchElementException.

    Synchronization is one of the biggest issues im Selenium WebDriver. Selenium doesn't adjust automatically.
    To overcome these issues we used to use Thread.sleep(2000)

     What's the problem with  this solution?
     Thread.sleep(2000) will stop your test script, no matter element is available or no for fixed amount of time.

     Thread.sleep(2000)  let's say we put on pause our test for 20 seconds.  Even though element was available after
     3 seconds, still your script will be on hold for 20 seconds. We are increasing execution time, thus we are loosing money.

     ImplicitWait -> will help to wait for appearance of element, within given time-frame.
     let's say you specify implicitWait time 10 seconds, and if element was found faster, let's say in 2 seconds, your
     test will continue running and will   not wait for extra 8 seconds. If after 10 seconds, element was not found,
     you will get NoSuchElementException.

     ImplicitWait should be  specified only once, at the beginning.
     it will apply automatically before every findElement() method call, but not findElements().

    Thread.sleep(2000)  -> always and only 10 seconds wait
    implicitWait(10, TimeUnit.SECONDS)  --> UP TO 10 seconds
     */

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test1(){
        // to wait within 10 seconds, until element is present    // we apply it once, and it always works
        // put this line into @BeforeMethod,  And it will work for all tests
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Dynamic Loading")).click();

        // partialLinkText we match only part of the link text
        // partialLinkText it's like contains text
        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.tagName("button")).click();



      //this is for  "Hello World!"
    WebElement finishElement = driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
