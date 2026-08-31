package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DropdownTests extends TestBase {

    @DataProvider
    public Object[][] dropdownOptions(){
        return new Object[][]{
                {"Option 1"},
                {"Option 2"}
        };
    }

    @Test(dataProvider = "dropdownOptions")
    public void dropdownTest(String option) {
        driver.get("https://the-internet.herokuapp.com/dropdown");

    DropdownPage dropdownPage = new DropdownPage(driver);

    dropdownPage.selectOption(option);

    Assert.assertEquals(
       dropdownPage.getSelectedOption(),
       option
       );
    }
}
