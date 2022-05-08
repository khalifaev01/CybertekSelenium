package selenium2022.Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
           driver.manage().window().maximize();
           driver.get("https://www.google.com");

           driver.getTitle();

        //   driver.findElement(By.name("q")).sendKeys("java books" + Keys.ENTER);

        // we want to navigate, to a different page    // within the same browser
        // URL can be passed as an object or as a string
        driver.navigate().to("https://www.amazon.com");

        // if I want to come back, to the previous page
        driver.navigate().back();

        // if I want to know URL of current website
        String url = driver.getCurrentUrl();
        System.out.println( url );

        driver.close();

        // .get("URL")  -> to open a website
      // what's the difference between   quit()  and close() methods ?
        // -> close() will close only current tab,  And  quit() will close entire browser


















    }
}
