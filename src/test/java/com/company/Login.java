import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {\
    WebDriver driver;
    

    public void setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");

        // Initialize the ChromeDriver
        Chromedriver options = new ChromeDriver();
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

        // Locate the username and password fields and the login button
        driver.findElement(By.id("email")).sendKeys("anishaprabhu019.com");
		driver.findElement(By.id("pass")).sendKeys("123456789");
		driver.findElement(By.xpath("//*[@name='login']")).click();
		System.out.println("Login");
        
    

        // Click on the login button
        loginButton.click();

        // Wait for a few seconds to see the result before closing the browser
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
