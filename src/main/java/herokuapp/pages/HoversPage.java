package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HoversPage extends BasePage {

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".figure:nth-of-type(1) img")
    WebElement firstImage;

    @FindBy(css = ".figure:nth-of-type(1) .figcaption")
    WebElement firstUserInfo;

    public HoversPage hoverOnFirstImage() {
        actions.moveToElement(firstImage).perform();
        return this;
    }

    public HoversPage verifyUserInfo(String text) {
        Assert.assertTrue(firstUserInfo.getText().contains(text));
        return this;
    }
}
