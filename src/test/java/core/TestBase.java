package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {

    protected ApplicationManager app;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp(Method method) {
        logger.info("Start test: {}", method.getName());

        app = new ApplicationManager();
        app.init();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.isSuccess()) {
            logger.info("PASSED: {}", result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: {}", result.getMethod().getMethodName());
        }

        if (app != null) {
            app.stop();
        }

        logger.info("Stop test");
        logger.info("*****************************************");
    }
}