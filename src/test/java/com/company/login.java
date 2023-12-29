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


public class login {
    WebDriver driver;
    

    public void setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");

        // Initialize the ChromeDriver
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

    public void loginTest(){

        // Navigate to Facebook login page
              driver.get("https://www.facebook.com");
               String pageTitle = driver.getTitle();       //get the title of the webpage
		System.out.println("The title of this page is ===> " +pageTitle);
		Assert.assertEquals("Facebook", pageTitle); 
        // Locate the username and password fields and the login button
                driver.findElement(By.id("email")).sendKeys("anishaprabhu019.com");
		driver.findElement(By.id("pass")).sendKeys("123456789");
		driver.findElement(By.xpath("//*[@name='login']")).click();
		System.out.println("Login");
	        System.out.println("successfull");
        
    

        // Click on the login button
       // loginButton.click();
    }
    public void teardown(){
        // Wait for a few seconds to see the result before closing the browser
        driver.quit();
        }

        
}
