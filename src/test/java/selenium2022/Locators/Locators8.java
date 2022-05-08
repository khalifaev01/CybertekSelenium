package selenium2022.Locators;

public class Locators8 {


   /* input -> tag, type -> attribute, id -> attribute

    Based on the properties / attributes, tags and text we can choose locator strategy.
    Locators: it's a thing that helps selenium to find elements and letter work with that element.
    In selenium  have a WebElement interface
    WebElement represents any kind of element on the page.
    purple -> tag
    orange -> attribute
    blue -> value of attribute
    black -> text

    For finding elements we have 8 locators
    id, name, tagName, className, xpath, cssSelector, LinkText, partialLinkText
    id -> it's the fastest way to find elements, ID must be unique.
    The only case when we cannot use id, is when id is dynamic.
            It's basically when id is different for every refresh or once in a while .

    How we understand that is dynamic?
    You find id , then you've used for finding element> First run, script passed.
    Second time NoSuchElementException.
          if you see that element is not there, based on  this id, that means it changed id value.
    NoSuchElementException -> means that based  on locator, selenium couldn't find any elements.




    */

}
