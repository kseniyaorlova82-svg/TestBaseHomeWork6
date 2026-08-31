package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HorizontalSliderPage extends BasePage {
    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[type='range']")
    WebElement slider;

    @FindBy(id = "range")
    WebElement sliderValue;

    public HorizontalSliderPage moveSlider(Keys direction, int steps) {
        for (int i = 0; i < steps; i++) {
            slider.sendKeys(direction);
        }
        return this;
    }

    public String getSliderValue() {
        return sliderValue.getText();
    }
}
