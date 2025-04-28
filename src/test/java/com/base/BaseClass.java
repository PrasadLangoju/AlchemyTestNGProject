package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {
     public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }

    public static void launchUrl(String url) {
        driver.get(url);
        driver.findElement(By.xpath("//button[text()='Decline']")).click();
        System.out.println("Cookies are Declined");
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }

    }
}
