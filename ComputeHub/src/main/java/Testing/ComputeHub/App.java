package Testing.ComputeHub;

import org.openqa.selenium.WebDriver;
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
    	driver.get("http://www.google.com");
    	
    	Thread.sleep(1000);
    	driver.quit();
    }
}
