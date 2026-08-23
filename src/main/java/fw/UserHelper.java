package fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public void fillRegistrationForm(String firstName,
                                     String lastName,
                                     String email,
                                     String password,
                                     String confirmPassword,
                                     String gender) {

        click(By.id(gender));
        type(By.id("FirstName"), firstName);
        type(By.id("LastName"), lastName);
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        type(By.id("ConfirmPassword"), confirmPassword);
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("Email"), email);
        type(By.id("Password"), password);
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".login-button"));
    }

    public String newEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        return "john" + i + "@dow.test";
    }
}