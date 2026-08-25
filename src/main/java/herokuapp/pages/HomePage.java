package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "JavaScript Alerts")
    WebElement javaScriptAlertsLink;

    @FindBy(linkText = "Multiple Windows")
    WebElement multipleWindowsLink;

    @FindBy(linkText = "Nested Frames")
    WebElement nestedFramesLink;

    public JavaScriptAlertsPage getJavaScriptAlerts() {
        click(javaScriptAlertsLink);
        return new JavaScriptAlertsPage(driver);
    }

    public WindowsPage getMultipleWindows() {
        click(multipleWindowsLink);
        return new WindowsPage(driver);
    }

    public NestedFramesPage getNestedFrames() {
        click(nestedFramesLink);
        return new NestedFramesPage(driver);
    }
}
