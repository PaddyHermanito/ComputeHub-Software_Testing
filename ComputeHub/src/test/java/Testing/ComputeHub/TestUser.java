package Testing.ComputeHub;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUser {
	public WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    	
    	driver = new ChromeDriver();
    	driver.get("http://localhost:5173/");
    	driver.manage().window().maximize();
	}
	
	@Test
	public void TC1() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123asdf");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//    	Thread.sleep(500);
//    	wait.until(ExpectedConditions.alertIsPresent());
    	// Switch ke alert
        alert = driver.switchTo().alert();

        // Ambil teks dari alert
        String alertText = alert.getText();
        Assert.assertEquals("Password salah", alertText);
        // Terima (klik OK) pada alert
        alert.accept();
        
        // Switch back to the default content
        driver.switchTo().defaultContent();
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException{
		Thread.sleep(3000);
		driver.close();
	}
}
