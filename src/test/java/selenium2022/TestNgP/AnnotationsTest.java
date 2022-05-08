package selenium2022.TestNgP;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class: Runs only Once Before all tests & before method !");
    }

    @BeforeMethod
    public void setup(){
        // some code that will be running before every test, like: test1, test2, test3
        // we can use method with @BeforeMethod annotation  & and it runs automatically before every test
        System.out.println("Before Method !");
    }

    @AfterMethod
    public void tearDown() {
        // runs automatically after every test
        System.out.println("After Method !");
    }
    @Test
    public void test1() {
        System.out.println("Test 1!");
        Assert.assertTrue(5 == 5 );
    }

    @Test
    public void test2() {
        System.out.println("Test 2!");
    }

    @Test
    public void test3() {
        System.out.println("Test 3!");
    }

}
