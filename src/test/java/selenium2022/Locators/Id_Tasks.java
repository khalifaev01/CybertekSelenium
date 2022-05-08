package selenium2022.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium2022.Utilities.BrowserFactory;

public class Id_Tasks {
    public static void main(String[] args) {

        /*
         id -> it's the fastest way to find elements, ID must be unique.
    The only case when we cannot use id, is when id is dynamic.
            It's basically when id is different for every refresh or once in a while .

         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedTitle= driver.getTitle();



        WebElement button = driver.findElement(By.id("form_submit"));
        // to click on the element
        button.click();
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test Passed");
        } else  {
            System.out.println("Test Failed");
            System.out.println("Expected title" + expectedTitle);
            System.out.println( "Actual title" + actualTitle);
        }

      //  BrowserUtils.wait(5);
       // driver.close();











    }
}
