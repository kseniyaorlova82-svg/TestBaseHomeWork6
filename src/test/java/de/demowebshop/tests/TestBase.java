package de.demowebshop.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }
    public void type(By locator, String text){
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public void fillRegistrationForm(String firstName, String lastName, String email,
                                     String password, String confirmPassword, String gender) {
        click(By.id(gender));
        type(By.id("FirstName"), firstName);
        type(By.id("LastName"), lastName);
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        type(By.id("ConfirmPassword"), confirmPassword);
    }
    public String newEmail(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        return "john" + i +"@dow.test";
    }
    //  public String generateEmail() {
    // return "stupachenko30" + System.currentTimeMillis() + "@gmail.com";

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }
    public boolean isElementPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }
    public boolean isLogOutPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }
}