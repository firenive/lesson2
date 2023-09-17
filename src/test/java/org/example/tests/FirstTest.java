package org.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {
    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(FirstTest.class);

    @BeforeSuite
    static void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test
    void test() {
        logger.info("Запуск теста");
        driver.get("https://otus.ru/");
        logger.info("Тест выполнен");
    }

    @AfterSuite
    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
