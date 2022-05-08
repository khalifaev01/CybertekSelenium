package selenium2022.DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium2022.Utilities.BrowserFactory;

import java.util.List;

public class RadioButtons {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        // to go to Radio Buttons' page
        // linkText works only with <a> element   && it's only between <TEXT>
        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test( description = "Verify that blue button is selected")
    public void test1(){

     WebElement blueButton = driver.findElement(By.id("blue"));
     // let's verify that radio button is selected
        // if button is selected it will return true
        Assert.assertTrue(blueButton.isSelected() );
    }

    @Test(description = "Verify that red button is not selected")
    public void test2() {
        WebElement redButton = driver.findElement(By.id("red"));
        // isSelected() returns true if button already clicked
        Assert.assertFalse( redButton.isSelected() );
    }

    @Test( description = "Verify that green button is not clickable")
    public void test3() {

       WebElement greenButton = driver.findElement(By.id("green"));
      // isEnabled returns true if button is available for interaction
      Assert.assertFalse( greenButton.isEnabled() );
    }

    @Test( description = "Click on all radio buttons")
   public void test4() {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        // let's click only if button is not clicked and is available for clicking
        for( WebElement radioButton : radioButtons){
            if( radioButton.isEnabled() && !radioButton.isSelected()){
                radioButton.click();
                System.out.println("Button clicked" + radioButton.getAttribute("id"));
            } else{
                System.out.println("Button was not clicked : " + radioButton.getAttribute("id"));
            }
        }
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
