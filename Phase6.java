package com.bootcamp;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Phase6 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dynamicLoadingTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@href='/dynamic_loading/1']")).click();
        Thread.sleep(2000);

        // Click the start button
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

        // Wait for the "Hello World!" text to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finishElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        // Assert that the text is "Hello World!"
        String actualText = finishElement.getText();
        Assert.assertEquals(actualText, "Hello World!");
        System.out.println("Assertion successful. Found text: " + actualText);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
