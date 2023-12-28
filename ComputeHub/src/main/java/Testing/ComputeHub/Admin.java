package Testing.ComputeHub;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    	
    	WebDriver driver=new ChromeDriver();
    	driver.get("http://localhost:5173/");
    	driver.manage().window().maximize();
    	
    	WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123asdf");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	// Switch ke alert
        alert = driver.switchTo().alert();

        // Ambil teks dari alert
        String alertText = alert.getText();
//        System.out.println("Alert Text: " + alertText);
     // Terima (klik OK) pada alert
        alert.accept();
     // Switch back to the default content
        driver.switchTo().defaultContent();
        email.clear();
        email.sendKeys("paddy.h21@mhs.istts.ac.id");
        loginButton.click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        // Ambil teks dari alert
        alertText = alert.getText();
//        System.out.println("Alert Text: " + alertText);
     // Terima (klik OK) pada alert
        alert.accept();
     // Switch back to the default content
        driver.switchTo().defaultContent();
        email.clear();
        email.sendKeys("admin@gmail.com");
        pass.clear();
        pass.sendKeys("admin1");
        loginButton.click();
        
        WebElement customer = wait.until(ExpectedConditions.elementToBeClickable(By.id("customer")));
        customer.click();
        
        
        Thread.sleep(2000);
    	driver.quit();
    	System.out.println("Done");
	}

}
