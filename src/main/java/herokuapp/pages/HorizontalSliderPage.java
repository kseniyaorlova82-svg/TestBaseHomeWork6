package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HorizontalSliderPage extends BasePage {

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='range']")
    WebElement slider;

    public HorizontalSliderPage moveSlider() {
        slider.sendKeys(Keys.END);
        return this;
    }

    @FindBy(id = "range")
    WebElement sliderValue;

    public HorizontalSliderPage verifySliderValue(String number) {
        Assert.assertEquals(sliderValue.getText(), number);
        return this;
    }
}