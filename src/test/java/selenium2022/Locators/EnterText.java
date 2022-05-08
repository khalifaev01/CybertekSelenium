package selenium2022.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium2022.Utilities.BrowserFactory;

public class EnterText {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        driver.findElement(By.name("email")).sendKeys("random@email.com");
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Test Passed");
        } else{
            System.out.println("Test Failed");
        }












    }
}
