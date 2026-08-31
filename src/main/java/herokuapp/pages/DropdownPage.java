package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

public DropdownPage(WebDriver driver) {
   super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropdownPage selectOption(String option) {
        new Select(dropdown).selectByVisibleText(option);
        return this;
    }

    public String getSelectedOption() {
        return new Select(dropdown)
                .getFirstSelectedOption()
                .getText();
    }
}
