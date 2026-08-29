package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.BrokenImagesPage;
import org.testng.annotations.Test;

public class BrokenImagesTests extends TestBase {

@Test
public void brokenImagesTest() {
driver.get("https://the-internet.herokuapp.com/broken_images");

new BrokenImagesPage(driver)
   .checkBrokenImages();
    }
}