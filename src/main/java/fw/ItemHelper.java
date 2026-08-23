package fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends BaseHelper {

    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public void addSecondItemToCart() {
        driver.findElements(By.cssSelector(".product-box-add-to-cart-button"))
                .get(1)
                .click();
    }

    public void openShoppingCart() {
        click(By.cssSelector("[href='/cart']"));
    }

    public String getItemName() {
        return driver.findElement(By.cssSelector(".product-name")).getText();
    }
}
