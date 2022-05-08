package selenium2022.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium2022.Utilities.BrowserFactory;
import selenium2022.Utilities.BrowserUtils;

import java.util.List;

public class CSSSelector {

    /*
    CSS Selector -> Cascading style sheets,
     it's simply for designing the web pages. using css you can  control the color of the text, the style of font... 
     CSS can handle the look and feel part of webpage .


    Syntax : [Attribute='value']    || tagName[attribute='value']
    Syntax : xpath :   //tagName[@attribute='value']

 In css we can specify id like this :        #id  =====   for class name in css we use .  dot .className       || [class='h3']
      CSS  is more readable, CSS is faster,
    Xpath has ability to transverse around the page where css cannot.
    Xpath xan traverse up and down the document tree. CSS can traverse only down to DOM.

   [clas='value'] [name='value2']    ---> to specify 2nd attribute
   ^ starts-with  --> starting point of the attribute
   [id$='end_of_value']  $ means attribute ends with value

     * -> contains,       ^ -> starts-with,                $ -> ends-with
      How about contains ?
         we just put * after attribute
     [ attribute * ='value'] -> value can be partial, same like  contains(@attribute,'value') in xpath

  How we can move from parent to child element in css selector ?           "space"   or   ">"

   What's the difference between space and > ?
   space in between means any child ( can be grand, or grand, grand child ) > means only direct child.


     */

    public static void main(String[] args) {

    WebDriver driver = BrowserFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/multiple_buttons");

    // find all the buttons and click on them
   List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));

     for (WebElement button : buttons ){
         button.click();
         BrowserUtils.wait(1);

         // get message after click
         WebElement message = driver.findElement(By.cssSelector("#result"));

         // print a text of that message
         System.out.println( message.getText() );
     }

     WebElement header = driver.findElement(By.cssSelector(".container > h3"));
        System.out.println( header.getText() );

        WebElement p = driver.findElement(By.cssSelector("[class='container'] > p"));
        System.out.println( p.getText() );

     driver.quit();

    }
}
