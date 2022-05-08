package selenium2022.Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import selenium2022.Utilities.BrowserFactory;
import selenium2022.Utilities.BrowserUtils;

import java.net.URL;

public class NavigationPractice {
    public static void main(String[] args) {

 /*
        driver.get("url")  -> to open URL, open some web page
        driver.navigate().to(URL) -> load a new web page in the current browser windows
        driver.navigate().back() -> move in the browser history to the previous URL
        driver.navigate().forward() -> Move forward in the browser history, Does nothing if we are on the latest page viewed
        driver.navigate().refresh() -> Load a new web page in the current browser windows
  */

        // create w WebDriver object, to work with a browser

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // this is out custom method
     //   since method is static we can use class name to call the method
            //    as parameter we provide number of seconds
        BrowserUtils.wait(3);

        System.out.println(driver.getTitle() );

        driver.navigate().to("http://amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.quit();                                             // shutdown the browser

      //  driver.get("https://www.google.com");
      // You cannot call driver after quit() otherwise you will get an exception :




    }
}
