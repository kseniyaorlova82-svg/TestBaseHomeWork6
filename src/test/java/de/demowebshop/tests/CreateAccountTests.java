package de.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {

        click(By.cssSelector(".ico-register"));

        click(By.id("gender-female"));

        type(By.id("FirstName"), "Oksana");

        type(By.id("LastName"), "Hanzii");

        type(By.id("Email"), "oksana.hanzii.82@gmail.com");

        type(By.id("Password"), "Aa123456!");

        type(By.id("ConfirmPassword"), "Aa123456!");

        click(By.id("register-button"));

        Assert.assertTrue(
                isElementPresent(By.cssSelector(".result"))
        );
    }

    @Test
    public void existedUserRegisterNegativeTest() {

        click(By.cssSelector(".ico-register"));

        click(By.id("gender-female"));

        type(By.id("FirstName"), "Oksana");

        type(By.id("LastName"), "Hanzii");

        type(By.id("Email"), "oksana.hanzii.82@gmail.com");

        type(By.id("Password"), "Aa123456!");

        type(By.id("ConfirmPassword"), "Aa123456!");

        click(By.id("register-button"));

        Assert.assertTrue(
                isElementPresent(By.cssSelector(".validation-summary-errors"))
        );
    }
}
