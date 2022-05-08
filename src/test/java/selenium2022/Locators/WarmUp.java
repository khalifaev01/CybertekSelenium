package selenium2022.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium2022.Utilities.BrowserFactory;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://cybertekschool.com");

        // how to find all links ?              every link as a tag name <a>

        List<WebElement> links = driver.findElements(By.xpath("//a"));

        System.out.println("Number of links : " + links.size() );

          //  if I want to print text of all links, one by  one     &&  if links are appeared there

        for( WebElement link : links ) {
            if (!link.getText().isEmpty()) {
                System.out.println(link.getText());
            }
        }


        driver.quit();







    }
}
