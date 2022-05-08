package selenium2022.Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScript {
    public static void main(String[] args) {

        // Exit 0 means all good
      //   WebDriver helps us to talk with a browser and send commands.
        // We have to Setup WebDriver
        WebDriverManager.chromedriver().setup();

        // We need to create an object of appropriate class
        WebDriver driver = new ChromeDriver();

        // .get() - method -> allows us to open some website
        driver.get("https://www.google.com");

        // to read the page title, there is a method .getTitle();

        // Verify that title of the page
       String actualResult = driver.getTitle();
       String expectedResult ="Google";

      if(actualResult.equals(expectedResult)){
          System.out.println("test Passed");
      } else{
          System.out.println("test Failed");
      }











        // to close browser
        driver.close();



    }
}
