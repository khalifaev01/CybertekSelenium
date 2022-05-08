package selenium2022.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium2022.Utilities.BrowserFactory;
import selenium2022.Utilities.BrowserUtils;

public class TestNameLocator {
    public static void main(String[] args)  {

/*
     name-> Finds the input element with matching name attribute

      tagName :
        <a href ="autocomplete"> Autocomplete</a>
              a -> tag ,              href -> attribute,               /autocomplete -> value of href attribute

   <a> stands for hyperlink. it's clickable text. Once you click on this text, it will bring you to the different page.


    we can find element,  if it's  a link, based on Link text.
    LinkText -> Find the link element with matching visible text.
    it works only if tag name is <a>


 */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");


        driver.findElement(By.name("full_name")).sendKeys("Test User");

        driver.findElement(By.name("email")).sendKeys("test@gmail.com");

        driver.findElement(By.name("wooden_spoon")).click();


        WebElement sub_header =driver.findElement(By.tagName("h3"));
        System.out.println( sub_header.getText() );


        driver.findElement(By.linkText("Autocomplete")).click();


         BrowserUtils.wait(5);

         //   Thread.sleep(300);

           driver.quit();



    }
}
