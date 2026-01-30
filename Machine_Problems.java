package com.bootcamp;

import io.github.bonigarcia.wdm.*;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Machine_Problems {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    //Phase1
    public void getPageInfo() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com");

        String pageTitle = driver.getTitle();
        System.err.println("Page Title: " + pageTitle);
        Assert.assertEquals(pageTitle, "The Internet");

        String pageUrl = driver.getCurrentUrl();
        System.err.println("Page URL: " + pageUrl);
        Assert.assertEquals(pageUrl, "https://the-internet.herokuapp.com/");
        Thread.sleep(2000);
    
    //Phase2
    
        driver.get("https://the-internet.herokuapp.com/login");
        Thread.sleep(1000);

        // locate username input field
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("tomsmith");
        Thread.sleep(1000);

        // locate password input field
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("SuperSecretPassword!");
        Thread.sleep(1000);

        // locate login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        Thread.sleep(2000);
    
    //Phase3
    
        // Navigate to the dropdown page
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        Thread.sleep(2000);

        // Select an option by visible text
        dropdown.selectByVisibleText("Option 1");
        Thread.sleep(2000); // Wait to observe the selection

        // Select another option by visible text
        dropdown.selectByVisibleText("Option 2");

        Thread.sleep(2000); // Wait to observe the selection

        driver.get("https://the-internet.herokuapp.com");
        Thread.sleep(2000);

    
    //Phase4
    
        // Navigate to the dropdown page
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);

        // Locate "checkbox 1" (the first checkbox)
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        // Check if checkbox 1 is not selected and then click it
        if (!checkbox1.isSelected()) {
            checkbox1.click();
            System.out.println("Checkbox 1 is now selected.");
        } else {
            System.out.println("Checkbox 1 is already selected.");
        }

        Thread.sleep(2000); // Wait to observe the selection

        driver.get("https://the-internet.herokuapp.com");
        Thread.sleep(2000);

    
    //Phase5
    
        // Navigate to the javascript alerts page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);

        // Click for JS Alert and accept it
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        System.out.println("JS Alert handled.");
        Thread.sleep(2000);

        // Click for JS Confirm and accept it
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        System.out.println("JS Confirm handled.");
        Thread.sleep(2000);

        // Click for JS Prompt, enter text, and accept it
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("I am a JS prompt");
        promptAlert.accept();
        System.out.println("JS Prompt handled.");

        Thread.sleep(2000);
    
    //Phase6
    
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