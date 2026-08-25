package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HomePage;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @Test

    public void newWindowTest() {
        new HomePage(driver)
                .getMultipleWindows()
                .clickOnNewTabButton()
                .switchToNewTab(1)
                .verifyToTabTitle("New Window");
    }
}
