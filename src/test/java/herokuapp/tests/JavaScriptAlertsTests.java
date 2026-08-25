package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.JavaScriptAlertsPage;
import org.testng.annotations.Test;

public class JavaScriptAlertsTests extends TestBase {

    @Test
    public void jsAlertTest() {
        new JavaScriptAlertsPage(driver)
                .clickJsAlert()
                .verifyResult("You successfully clicked an alert");
    }

    @Test
    public void jsConfirmTest() {
        new JavaScriptAlertsPage(driver)
                .clickJsConfirm("Ok")
                .verifyResult("You clicked: Ok");
    }

    @Test
    public void jsPromptTest() {
        new JavaScriptAlertsPage(driver)
                .clickJsPrompt("Hello")
                .verifyResult("You entered: Hello");
    }
}