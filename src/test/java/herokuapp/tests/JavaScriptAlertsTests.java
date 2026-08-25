package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import org.testng.annotations.Test;

public class JavaScriptAlertsTests extends TestBase {

    @Test
    public void jsAlertTest() {
        new HomePage(driver)

                .getJavaScriptAlerts()
                .clickJsAlert()
                .verifyResult("You successfully clicked an alert");
    }

    @Test
    public void jsConfirmTest() {
        new HomePage(driver)
                .getJavaScriptAlerts()
                .clickJsConfirm("Ok")
                .verifyResult("You clicked: Ok");
    }

    @Test
    public void jsPromptTest() {
        new HomePage(driver)
                .getJavaScriptAlerts()
                .clickJsPrompt("Hello")
                .verifyResult("You entered: Hello");
    }
}