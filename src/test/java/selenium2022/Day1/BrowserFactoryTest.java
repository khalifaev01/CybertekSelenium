package selenium2022.Day1;

import org.openqa.selenium.WebDriver;
import selenium2022.Utilities.BrowserFactory;

public class BrowserFactoryTest  {

    public static void main(String[] args) {


        // we can get WebDriver like this
        // get.Driver() method will return WebDriver object And we can use reference variable to work with that object
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com");

        // how we can print a source code of page
        System.out.println( driver.getPageSource() );

        // to finish test execution
        driver.quit();




    }
}
