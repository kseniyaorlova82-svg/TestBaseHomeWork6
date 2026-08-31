package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HorizontalSliderPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestBase {

    @Test
    public void horizontalSliderTest() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        HorizontalSliderPage sliderPage = new HorizontalSliderPage(driver);

        sliderPage.moveSlider(Keys.END, 1);

        Assert.assertEquals(
                sliderPage.getSliderValue(),
                "5"
        );

        sliderPage.moveSlider(Keys.ARROW_LEFT, 3);

        Assert.assertEquals(
                sliderPage.getSliderValue(),
                "3.5"
        );

        sliderPage.moveSlider(Keys.ARROW_RIGHT, 3);

        Assert.assertEquals(
                sliderPage.getSliderValue(),
                "5"
        );
    } 
}
