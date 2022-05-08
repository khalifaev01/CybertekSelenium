package selenium2022.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium2022.Utilities.BrowserFactory;
import selenium2022.Utilities.BrowserUtils;

public class Xpath {

    /*
    How do you handle dynamic elements ?  xpath is the best way to handle the situation when the element is not consistent

    xpath : is more powerful but small
       it's a type of locators that used in Selenium to find elements. xpath was originally created for XML documents,
      but it also supports HTML documents.

 Xpath can be used for: Locating elements with partially static attribute values.
               Locating elements without attribute or without unique attributes.

     Types of XPATH :   absolute vs relative
      Absolute ->  starts with the root element.  / slash
    /html/body/everything from top to button[1 or 2]/

     Relative -> are starts with //  .   syntax:    //*[attributeName='value']
     can stat from anywhere. It must start with // and then you can use tag name, attributes, text, to create a locator:

     Ex:  //tagName[@attribute='value']                     ==>  //div[@class='errortext']

        * -> any tag name      ex: "// * [@type='Password']"        Ex: //*[text()='Text']  -> equals to exact text

    What if we don't have exact value, only beginning part   ?

       syntax : //tag[starts-with(@attribute, 'value')]

     then we can use starts-with   EX: //[starts-with(@onclick, 'BX']


      How about partial text :
        we can use contains. contains will help us find element based on partial text/value regardless of location
            //*[contains(text(),'incorrect')]


(//button)[3] -> nth element of matching           ==> //button[3] -> 3rd child


*/









    public static void main(String[] args) {

       WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");

        // click login without entering username and password ,     to invoke warning message
        driver.findElement(By.className("login-btn")).click();

        // absolute example:

    //   WebElement warningMessage = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div/div[2]"));
     //   System.out.println( warningMessage.getText());

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com");

      //   driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("userUser");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");

        // click on login button
       driver.findElement(By.xpath("//input[starts-with(@value, 'Log')]")).click();

        BrowserUtils.wait(3);

        driver.quit();







    }
}
