package com.bootcamp;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Phase5 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void alertsElements() throws InterruptedException {
        // Navigate to the javascript alerts page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click for JS Alert and accept it
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        System.out.println("JS Alert handled.");

        // Click for JS Confirm and accept it
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        System.out.println("JS Confirm handled.");

        // Click for JS Prompt, enter text, and accept it
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("I am a JS prompt");
        promptAlert.accept();
        System.out.println("JS Prompt handled.");

        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}