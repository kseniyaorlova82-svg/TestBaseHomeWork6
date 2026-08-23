package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(
                "kseniya.orlova.82@gmail.com",
                "T18287daha!"
        );
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addItemToCartTest() {

        app.getItem().addSecondItemToCart();

        app.getItem().openShoppingCart();

        Assert.assertEquals(
                app.getItem().getItemName(),
                "14.1-inch Laptop"
        );
    }
}
