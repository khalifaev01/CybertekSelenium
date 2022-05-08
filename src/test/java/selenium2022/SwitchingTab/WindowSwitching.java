package selenium2022.SwitchingTab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium2022.Utilities.BrowserFactory;
import selenium2022.Utilities.BrowserUtils;

import java.util.Set;

public class WindowSwitching {

    // driver.switchTo().window(windowHandle); -> in this way we can switch to another window.
    // window handle -> it's like window id

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }


   @Test(description = "Verify that title is still Practice")
    public void test1() {
     driver.findElement(By.linkText("New tab")).click();

     // After 3 second another website will be open in another window,  selenium doesn't switch automatically to the new window
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());

         Assert.assertEquals( driver.getTitle(), "New tab will be opened in 3 seconds!", "Title is wrong!");
    }

    @Test(description = "Verify that user successfully changed the window")
    public void test2() {
       driver.findElement(By.linkText("New tab")).click();

       // record id of original window, that we opened initially
       String oldWindow = driver.getWindowHandle();

       BrowserUtils.wait(4);

       // in selenium every window has an id. That us id calls window handle,
        // to read window handle we use method getWindowHandle()
        //after new window was opened, we can get list of all window id's or windowHandles()

        // List -> it's a data structure,
        //Set -> it's also data structure, but it's not allow duplicates , also it's not easy to access anything from there
        // that's why we need to loop through the set, to read data from there, Set can store only unique values

      Set<String> windowHandles = driver.getWindowHandles();
      // getWindowHandles() ->  return collection of window id's that are currently opened by WebDriver.

      for( String windowHandle : windowHandles ) {
          // if it's not an old window
          if( !windowHandle.equals( oldWindow ) ){
              // switch to that window
              driver.switchTo().window(windowHandle);
          }
      }

      // let's verify that title of new window is a Fresh tab
        System.out.println( driver.getTitle());
    Assert.assertEquals( driver.getTitle(), "Fresh tab", "Title is wrong!");

    // come back to original page
        // we can build a function, that will jump, in between windows  ,   based on page title

        String pageTitle = "Practice";

        for( String windowHandle : windowHandles ){
            // keep jumping from one window to window
            driver.switchTo().window(windowHandle);
            // once we found page title, of the window that we need
            if( driver.getTitle().equals(pageTitle)){
                // just exit,      stop jumping
                break;
            }
        }
        System.out.println( driver.getTitle() );
    }








    @AfterMethod
    public void teardown(){
       driver.quit();
    }

}
