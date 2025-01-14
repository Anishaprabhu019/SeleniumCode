package com.company;

import org.junit.Assert;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.BeforeTest;  
import org.testng.annotations.Test; 
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    WebDriver driver;
    @BeforeTest
    public void setup(){
		System.setProperty("webdriver.chrome.driver","/opt/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
                options.addArguments("--headless");
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("start-maximized"); // open Browser in maximized mode
                options.addArguments("disable-infobars"); // disabling infobars
                options.addArguments("--disable-extensions"); // disabling extensions
                options.addArguments("--disable-gpu"); // applicable to windows os only
                options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                 driver = new ChromeDriver(options); //initialise the WebDriver

    }

	@Test
	public void loginTest(){   
               driver.get("https://www.facebook.com");
               
        // Locate the username and password fields and the login button
                driver.findElement(By.id("email")).sendKeys("anishaprabhu019.com");
		driver.findElement(By.id("pass")).sendKeys("123456789");
		driver.findElement(By.xpath("//*[@name='login']")).click();
		System.out.println("Login");
	        System.out.println("successfull");
        
    

        // Click on the login button
        //loginButton.click();
    }
    public void teardown(){
        // Wait for a few seconds to see the result before closing the browser
        driver.quit();
        }
}
        
