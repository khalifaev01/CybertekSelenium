package selenium2022.DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium2022.Utilities.BrowserFactory;

import java.util.List;

public class CheckBoxes {

    // command + option + L -> to organize code

    private WebDriver driver;                              // private only will be used in this class

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    @Test
    public void test1(){
     List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));

     int index = 1;
     for(WebElement checkbox : checkboxes ){
       if(checkbox.isEnabled() && !checkbox.isSelected() ){
           checkbox.click();
           System.out.println("Checkbox clicked: "+ index );
       }else{
           System.out.println("Checkbox was not clicked: " + index );
       }
       index++;
     }
    }




    @AfterMethod
    public void tearDown() {
       driver.quit();
    }
}
