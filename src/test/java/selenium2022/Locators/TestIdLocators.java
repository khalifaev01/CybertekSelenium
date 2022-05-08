package selenium2022.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium2022.Utilities.BrowserFactory;

public class TestIdLocators {
    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button = driver.findElement(By.id("disappearing_button"));
         button.click();

         WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());

      //  driver.quit();

    }
}
