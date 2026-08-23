package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {

        app.getUser().clickOnRegisterLink();

        app.getUser().fillRegistrationForm(
                "Oksana",
                "Hanzii",
                app.getUser().newEmail(),
                "T18287daha!",
                "T18287daha!",
                "gender-male"
        );

        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().isLogOutPresent());
    }
}