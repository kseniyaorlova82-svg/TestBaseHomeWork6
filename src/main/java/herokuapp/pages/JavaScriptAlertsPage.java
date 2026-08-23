package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JavaScriptAlertsPage extends BasePage {

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement jsAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement jsConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement jsPromptButton;

    @FindBy(id = "result")
    WebElement result;


    public JavaScriptAlertsPage clickJsAlert() {
        click(jsAlertButton);
        driver.switchTo().alert().accept();
        return this;
    }

    public JavaScriptAlertsPage clickJsConfirm(String result) {
        click(jsConfirmButton);

        if (result != null && result.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }

        return this;
    }

    public JavaScriptAlertsPage clickJsPrompt(String text) {
        click(jsPromptButton);
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
        return this;
    }
    public JavaScriptAlertsPage verifyResult(String text) {
        Assert.assertTrue(isContainsText(text, result));
        return this;
    }
}