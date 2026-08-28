package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.DragAndDropPage;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {

    @Test
    public void dragAndDropTest() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        new DragAndDropPage(driver)
                .dragAtoB()
                .verifyDragAndDrop();
    }
}