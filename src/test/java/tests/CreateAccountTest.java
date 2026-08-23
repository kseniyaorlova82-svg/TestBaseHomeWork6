package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {

        app.getUser().clickOnRegisterLink();

        app.getUser().fillRegistrationForm(
                "John",
                "Dow",
                app.getUser().newEmail(),
                "johndowtest1",
                "johndowtest1",
                "gender-male"
        );

        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().isLogOutPresent());
    }
}