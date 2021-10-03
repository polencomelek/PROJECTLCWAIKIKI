package org.example;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class BaseTest {

 public WebDriver driver;

    @Before
    public void Start(){


        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver; // Kaydırma işlemi için kullandık.

    }

    @After
    public void tearDown(){

      // driver.close();
       //driver.quit();
    }


}
