package com.bootcamp;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Phase1 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void getPageInfo() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");

        String pageTitle = driver.getTitle();
        System.err.println("Page Title: " + pageTitle);
        Assert.assertEquals(pageTitle, "The Internet");

        String pageUrl = driver.getCurrentUrl();
        System.err.println("Page URL: " + pageUrl);
        Assert.assertEquals(pageUrl, "https://the-internet.herokuapp.com/login");

        String pageSource = driver.getPageSource();
        System.out.println("Page Source length: " + pageSource);
        Assert.assertTrue(pageSource.contains("</body>"), "Page Source Does Not Match");

        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}