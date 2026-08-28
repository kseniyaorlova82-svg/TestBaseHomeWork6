package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HorizontalSliderPage;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestBase {

    @Test
    public void horizontalSliderTest() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        new HorizontalSliderPage(driver)
                .moveSlider()
                .verifySliderValue("5");

    }
}
