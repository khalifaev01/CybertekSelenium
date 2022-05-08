package selenium2022.Locators;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium2022.Utilities.BrowserFactory;

public class LocatorsReview {

    ////*[text()='Blue']/ -> to  go to the parent element
    //*[text()='Blue']/preceding-sibling::  -> go to input, that is on top
    // //input[@type='radio']/following-sibling::      -> label - go to label

    // /preceding-sibling::tagName / *
    // /following-sibling::tagName / *


    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Verify checkboxes")
    public void test1() {
        driver.findElement(By.linkText("Checkboxes")).click();

        //  [type='checkbox']  since there are two elements with same locators
        // And I need only first one , I can use in css, :nth-of-type(index) 7th, 8th   etc..
        // any tag or tag + attribute :nth-of-type(index)
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
        // How to verify if checkbox is not clicked ?
        Assert.assertFalse( checkbox1.isSelected(), "Checkbox 1 was selected" );            // assert that checkbox is not selected

      //  [index] -> to specify index of the element, if there are multiple element with this xpath

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));           // input or *

        Assert.assertTrue( checkbox2.isSelected(), "Checkbox 2 was not selected" );
        // cssSelector is preferable, because of speed.
        // assertion is like if statement
    }

    @Test(description = "Radio buttons test")
    public void test2(){
      driver.findElement(By.linkText("Radio Buttons")).click();
      WebElement blueButton = driver.findElement(By.xpath("//*[text()='Blue']/preceding-sibling::input[@type='radio']"));
        Assert.assertTrue( blueButton.isSelected(),  "Blue button is not selected");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
