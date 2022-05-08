package selenium2022.TestNgP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium2022.Utilities.BrowserFactory;

public class TestNgClass {

    /*
    Unit testing -> it's a testing of the smallest functional part of the app.

    TestNg -> is a unit, integration, e2e,  ets.. testing framework.

    Before TestNg, there was  Junit, which only unit testing framework. Still, Junit is more popular.

     Why do  we use TestNg with selenium?
     we create test scripts as methods.    So in testing, test looks like this :
     @Test
     public void test() {            }

     TestNG has a report, xml runners, it supports Data Driven Testing, test priorities, test dependencies,
     parametrization of test, it's  a lot of annotations to configure test suite execution,  etc...

       How to add testNG ? it's just another library. We can add it manually, or add maven dependency.

    If assertion fails, it will stop the program.

     isDisplayed()    -> returns true or false,  if it's true it means  element is visible.
     If method returns false means element is not visible

   assertEquals() -> to check is 2 things are the same.
   assertTrue()  -> to check if something is true.

    If test fails, why driver.quit() doesn't work ?
      Because program stops, and doesn't reach driver.quit() LINE.

     */

    @Test
    public void test(){

        // to verify that expected and actual result is same
        // if no -  it will throw exception and stop the program, also you will see in the console what was expected
        //AND  what was actually

        Assert.assertEquals("apple", "apple", "words are correct");

    }

    @Test(description = "Verifying title of the practice website")
    public void verifyTitle() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

        String expectedTitle ="Practice";
        String actualTitle = driver.getTitle();

        Assert.assertEquals( actualTitle, expectedTitle, "Title is wrong");

        driver.quit();

    }

    // Let's verify that test Automation practice heading is displayed

    @Test( description ="Verify that heading is displayed")
    public void verifyingTitleIsDisplay(){         //span[text()='Test Automation Practice']
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

   WebElement heading = driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));

   // to make sure that element is visible to user , because element can be present, but no visible
        // we need to make sure element is visible
   Assert.assertTrue( heading.isDisplayed(), "Element is not visible" );

   driver.quit();

    }


}
