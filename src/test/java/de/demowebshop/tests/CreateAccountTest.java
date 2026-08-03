package de.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends de.demowebshop.tests.TestBase {
    @Test
    public void newUserRegisterPositiveTest(){
        //verify that user in the main page()
        clickOnRegisterLink();
        fillRegistrationForm("John", "Dow", newEmail(),
                "johndowtest1", "johndowtest1", "gender-male");

        clickOnRegisterButton();
        Assert.assertTrue(isLogOutPresent());
    }
}
