package selenium2022.WaitsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium2022.Utilities.BrowserFactory;

import java.time.Duration;
import java.util.function.Function;


public class ExplicitWaitPractice {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test() {

        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1")).click();

        // click on start button
        driver.findElement(By.tagName("button")).click();
        // enter username
        // explicit wait
        // we find element first, but the problem is element can be present but not visible

        WebElement userNameInput = driver.findElement(By.id("username"));
        // we create object of WebDriverWait to apply explicit wait
        // we must provide WebDriver object and period of time, within this period of time selenium will check every 500 milliseconds
        // if condition is true, if condition has met, no need to wait longer
        // your script will continue executing

        WebDriverWait wait = new WebDriverWait(driver, 10);
        // how to apply condition,  | ExpectedConditions. condition
        // if wait time will expire, your test will fail ( due to exception)
        wait.until(ExpectedConditions.visibilityOf(userNameInput));

        userNameInput.sendKeys("tomsmith");

        WebElement passwordInput = driver.findElement(By.id("pwd"));

        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys("SuperSecretPassword");

        // this is a WebElement that represents submit button
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        // wait, within 10 seconds, until that button is available for click()
        wait.until(ExpectedConditions.elementToBeClickable(submit));

        submit.click();

        WebElement message = driver.findElement(By.tagName("h4"));

        wait.until(ExpectedConditions.visibilityOf(message));

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();

        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void test2() {

        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();

        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin"));
        // wait until overlay screen disappear, otherwise we will have issue to click or enter the text
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

        WebElement userNameInput = driver.findElement(By.id("username"));

        wait.until(ExpectedConditions.visibilityOf(userNameInput));

        userNameInput.sendKeys("tomsmith");

        WebElement passwordInput = driver.findElement(By.id("pwd"));

        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys("SuperSecretPassword");

        // this is a WebElement that represents submit button
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        // wait, within 10 seconds, until that button is available for click()
        wait.until(ExpectedConditions.elementToBeClickable(submit));

        submit.click();

        WebElement message = driver.findElement(By.tagName("h4"));

        wait.until(ExpectedConditions.visibilityOf(message));

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(description = "Fluent wait example")
    public void test3() {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();

        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(ElementNotVisibleException.class);
       WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
           @Override
           public WebElement apply(WebDriver driver) {
               return driver.findElement(By.id("finish"));
           }
       }
       );

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
