package selenium2022.TestNgP;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium2022.Utilities.BrowserFactory;

public class TestNGReview {

    private WebDriver driver;

    // whatever is common among tests, can go into @BeforeMethod and @AfterMethod
    @BeforeMethod
    public void setup(){
        System.out.println("Before method!");
        driver = BrowserFactory.getDriver("chrome");
    }

// priority will change the order of test execution
    // by default tests are running in alphabetic order
    // lower priority = earlier execution
// lower priority number -> higher priority of execution

    @Test(description = "Verify title of google.com", priority =2)
    public void test1(){
        System.out.println("Test 1");
        driver.get("http://google.com/");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

      Assert.assertEquals(expectedTitle, actualTitle,"Title is not correct");

        // -> if assertion failed line below will not be reachable
       // ->  if assertion passed, Line below will execute
        System.out.println("Test Passed");
    }

    @Test(description = "Verify title of apple.com", priority =1)
    public void verifyAppletTitle(){
        System.out.println("Test 2");
        driver.get("https://www.apple.com/");

        String expectedTitle = "Apple";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle,"Title is not correct");
    }

    // data provider can supply test with a test data. Also, it allows to do Data Driver Testing.
    // What is this? It's same test runs multiple times with different test data set
    @DataProvider(name ="testData")
    public static Object [] [] testData(){
   return new Object[][]{{"https://www.apple.com/","Apple"},
                     { "http://google.com/","Google"}
                     };
    }

    @Test(dataProvider = "testData")
    public void testWithDataProvider(String url, String title){

        driver.get(url);
        Assert.assertEquals(driver.getTitle(), title);
    }




    @AfterMethod
    public void tearDown(){
        System.out.println("After method!");
        driver.quit();
    }
}
