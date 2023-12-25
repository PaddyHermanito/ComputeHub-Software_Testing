package Testing.ComputeHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    	
    	WebDriver driver=new ChromeDriver();
    	driver.get("http://localhost:5173/");
    	driver.manage().window().maximize();
    	
    	WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.click();
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    	
//    	Thread.sleep(1000);
    	driver.quit();
    	System.out.println("Done");
    }
}
