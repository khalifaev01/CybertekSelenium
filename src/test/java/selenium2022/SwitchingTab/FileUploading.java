package selenium2022.SwitchingTab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium2022.Utilities.BrowserFactory;
import selenium2022.Utilities.BrowserUtils;

public class FileUploading {

    // How to upload file in Selenium ?
   // .sendKeys("path/to/the/file.txt")       <-    hold option button + left click


    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }

    @Test(description ="Verify that file was uploaded")
    public void test1(){
        driver.findElement(By.linkText("File Upload")).click();
        // provide path to the file
        driver.findElement(By.id("file-upload")).sendKeys("/Users/najmuddinkhalifaev/Desktop/Class.txt");

        driver.findElement(By.id("file-submit")).click();

        BrowserUtils.wait(4);

        String expectedFile = "Class.txt";
        String actualFile = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(expectedFile, actualFile, "File Failed to Upload");
    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

