package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MyDataProviders;

public class CreateAccountTest extends TestBase {

    @Test(
            dataProvider = "userDataFromCsv",
            dataProviderClass = MyDataProviders.class
    )
    public void newUserRegisterPositiveTest(
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword,
            String gender
    ) {

        app.getUser().clickOnRegisterLink();

        app.getUser().fillRegistrationForm(
                firstName,
                lastName,
                email,
                password,
                confirmPassword,
                gender
        );

        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().isLogOutPresent());
    }
}