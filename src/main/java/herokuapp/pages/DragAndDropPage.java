package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement columnA;

    @FindBy(id = "column-b")
    WebElement columnB;

    public DragAndDropPage dragAtoB() {
        new Actions(driver)
                .dragAndDrop(columnA, columnB)
                .perform();
        return this;
    }

    public DragAndDropPage verifyDragAndDrop() {
        Assert.assertTrue(columnA.getText().contains("B"));
        return this;
    }
}
