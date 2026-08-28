package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.DropdownPage;
import org.testng.annotations.Test;

public class DropdownTests extends TestBase {

    @Test
    public void dropdownTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        new DropdownPage(driver)
                .selectOption("Option 1")
                .verifySelectedOption("Option 1");
    }
}
