package selenium2022.WaitsPractice;

public class WaitsAll {

    /*
    Synchronization -> Waits in selenium  : Implicit, Explicit, Fluent

    if selenium is coming before element appear - you will get NoSuchElementException.

    Synchronization is one of the biggest issues im Selenium WebDriver. Selenium doesn't adjust automatically.
    To overcome these issues we used to use Thread.sleep(2000)

     What's the problem with  this solution?
     Thread.sleep(2000) will stop your test script, no matter element is available or no for fixed amount of time.

     Thread.sleep(2000)  let's say we put on pause our test for 20 seconds.  Even though element was available after
     3 seconds, still your script will be on hold for 20 seconds. We are increasing execution time, thus we are loosing money.

     ImplicitWait -> will help to wait for appearance of element, within given time-frame.
     let's say you specify implicitWait time 10 seconds, and if element was found faster, let's say in 2 seconds, your
     test will continue running and will   not wait for extra 8 seconds. If after 10 seconds, element was not found,
     you will get NoSuchElementException.

     ImplicitWait should be  specified only once, at the beginning.
     it will apply automatically before every findElement() method call, but not findElements().

    Thread.sleep(2000)  -> always and only 10 seconds wait
    implicitWait(10, TimeUnits.SECONDS)  --> UP TO 10 seconds


    explicitWait() --> it works in similar way as an implicit wait,
                         but explicit wait targets specific element with a specific condition.

       implicitWait resolves only one problem : presence of element
        explicitWait resolves more problems : presence of element, visibility, click-ability, staleness of element. etc...

        Wait until page is loaded handled automatically by selenium, but other condition - no .

        Page is fully loaded, but element can delay, or be invisible, or not intractable.

        Element can be visible but not clickable. And implicitWait not help you with this problem.
        That's why we can use explicitWait.

       FluentWait -> it works like explicitWait except one difference, you  can change polling time.
       ExplicitWait waits checks condition every 500 milliseconds. With a FluentWait, you can change this polling time.
       I would say that FluentWait it's like custom explicitWait.

     */
}
