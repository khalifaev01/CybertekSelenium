package selenium2022.Utilities;

public class BrowserUtils {

    // it will be used to pause our test Execution
    // just provide number of seconds as a parameter
    public static void wait( int seconds ) {

        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
