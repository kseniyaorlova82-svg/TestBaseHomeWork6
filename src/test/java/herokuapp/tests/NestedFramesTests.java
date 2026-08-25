package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import org.testng.annotations.Test;

public class NestedFramesTests extends TestBase {

    @Test

    public void nestedFramesTest() {
    new HomePage(driver)
           .getNestedFrames()
           .verifyNestedFrames();

    }
}
