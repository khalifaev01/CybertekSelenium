package selenium2022.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium2022.Utilities.BrowserFactory;

public class TestClassLoc {

    /*
    class -> refers to the attribute on the DOM element.  often is use.
    Stands for group of elements, and put them on the list.
     */

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // h3 it's a class name or value of  class attribute
      //  if class has text with a space, that means it's classes
     WebElement heading = driver.findElement(By.className("h3"));
        System.out.println( heading.getText() );













    }










}
