package herokuapp.tests;

import herokuapp.core.TestBase;
import herokuapp.pages.HoversPage;
import org.testng.annotations.Test;

public class HoversTests extends TestBase {

    @Test
    public void hoversTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");

        new HoversPage(driver)
                .hoverOnFirstImage()
                .verifyUserInfo("name: user1");

        Thread.sleep(3000);
    }
}
