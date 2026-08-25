package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Click Here']")

    WebElement clickHere;

    public WindowsPage clickOnNewTabButton() {
        click(clickHere);
        return this;

    }

    public WindowsPage switchToNewTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;

    }

    @FindBy(tagName = "h3")
    WebElement newWindowTitle;

    public WindowsPage verifyToTabTitle(String title) {
        Assert.assertTrue(isContainsText(title, newWindowTitle));
        return this;

    }
}
