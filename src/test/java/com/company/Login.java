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


public class Facebooklogin {

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
	public static void main(String[] args) throws InterruptedException {
	    // TODO Auto-generated method stub

	    driver.manage().window().maximize();
	    driver.get("https://www.facebook.com/");
	    Thread.sleep(2000);
	    WebElement username = driver.findElement(By.id("email"));
	    WebElement password = driver.findElement(By.id("pass"));
	    WebElement Login = driver.findElement(By.id("u_0_v"));
	    username.sendKeys("rajattiwari92@gmail.com");
	    password.sendKeys("tiwari@2");
	    Login.click();
	    Thread.sleep(3000);
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    WebElement navigationclick = driver.findElement(By.id("logoutMenu"));
	    WebElement logout = driver.findElement(By.xpath("//div[@id='u_d_1']/div/div/div/div/div/ul/li[12]/a/span/span"));
	    navigationclick.click();
	    if(logout.isEnabled() && logout.isDisplayed()) {
	        logout.click();
	    }
	    else {
	        System.out.println("Element not found");
	    }

	}

	}

