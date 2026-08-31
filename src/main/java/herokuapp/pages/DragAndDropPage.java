package herokuapp.pages;

import herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement columnA;

    @FindBy(id = "column-b")
    WebElement columnB;

    public DragAndDropPage dragAtoB() {
        actions
                .dragAndDrop(columnA, columnB)
                .perform();

        wait.until(driver -> columnA.getText().contains("B"));
        wait.until(driver -> columnB.getText().contains("A"));

        return this;
    }

    public String getColumnAText() {
        return columnA.getText();
    }

    public String getColumnBText() {
        return columnB.getText();
    }
}
