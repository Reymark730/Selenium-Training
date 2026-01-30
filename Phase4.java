package com.bootcamp;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Phase4 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkboxsElements() throws InterruptedException {
        // Navigate to the dropdown page
        driver.get("https://the-internet.herokuapp.com/checkboxes");

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

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}