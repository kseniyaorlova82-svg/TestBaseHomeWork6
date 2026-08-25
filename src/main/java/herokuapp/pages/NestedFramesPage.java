package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "frame-top")
    WebElement frameTop;

    @FindBy(name = "frame-left")
    WebElement frameLeft;

    @FindBy(name = "frame-middle")
    WebElement frameMiddle;

    @FindBy(name = "frame-right")
    WebElement frameRight;

    @FindBy(name = "frame-bottom")
    WebElement frameBottom;

    @FindBy(css = "body")
    WebElement body;

    public NestedFramesPage verifyNestedFrames() {

        driver.switchTo().frame(frameTop);

        driver.switchTo().frame(frameLeft);
        softly.assertThat(isContainsText("LEFT", body)).isTrue();

        driver.switchTo().parentFrame();

        driver.switchTo().frame(frameMiddle);
        softly.assertThat(isContainsText("MIDDLE", body)).isTrue();

        driver.switchTo().parentFrame();

        driver.switchTo().frame(frameRight);
        softly.assertThat(isContainsText("RIGHT", body)).isTrue();

        driver.switchTo().defaultContent();

        driver.switchTo().frame(frameBottom);
        softly.assertThat(isContainsText("BOTTOM", body)).isTrue();

        softly.assertAll();

        return this;
    }
}
