package com.bootcamp;

import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Phase3 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownElement() throws InterruptedException {
        // Navigate to the dropdown page
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText("Option 1");
        Thread.sleep(2000); // Wait to observe the selection

        // Select another option by visible text
        dropdown.selectByVisibleText("Option 2");

        Thread.sleep(2000); // Wait to observe the selection

        driver.get("https://the-internet.herokuapp.com");
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}