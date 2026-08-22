package de.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginForm("kseniya.orlova.82@gmail.com", "T18287daha!");
        clickOnLoginButton();
    }

    @Test
    public void addItemToCartTest() {
        driver.findElements(By.cssSelector(".product-box-add-to-cart-button"))
                .get(1)
                .click();

        click(By.cssSelector("[href='/cart']"));

        Assert.assertEquals(
                driver.findElement(By.cssSelector(".product-name")).getText(),
                "14.1-inch Laptop"
        );
    }
}
