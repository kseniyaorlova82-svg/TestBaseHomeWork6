package de.demowebshop.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class TestBase {

    WebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp(Method method) {

        logger.info("Start test: {}", method.getName());

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.isSuccess()) {
            logger.info("PASSED: {}", result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: {}. Screenshot -> {}",
                    result.getMethod().getMethodName(),
                    takeScreenshot());
        }

        if (driver != null) {
            driver.quit();
        }

        logger.info("Stop test");
        logger.info("*****************************************");
    }

    public String takeScreenshot() {

        File screenshot =
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String fileName =
                "screenshots/screen-" + System.currentTimeMillis() + ".png";

        try {
            Files.createDirectories(Path.of("screenshots"));
            Files.copy(
                    screenshot.toPath(),
                    Path.of(fileName)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileName;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
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

    public String newEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        return "john" + i + "@dow.test";
    }
}