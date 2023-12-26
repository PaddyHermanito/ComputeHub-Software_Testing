package Testing.ComputeHub;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main( String[] args ) throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    	
    	WebDriver driver=new ChromeDriver();
    	driver.get("http://localhost:5173/");
    	driver.manage().window().maximize();
//    	WebDriverWait wait = new WebDriverWait(driver, 10); // Timeout set to 10 seconds
    	
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
//        System.out.println("Alert Text: " + alertText);
     // Terima (klik OK) pada alert
        alert.accept();
        
     // Switch back to the default content
        driver.switchTo().defaultContent();
        
        email.clear();
        email.sendKeys("paddy.h21@mhs.istts.ac.id");
        loginButton.click();
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alert = wait.until(ExpectedConditions.alertIsPresent());
//        Thread.sleep(500);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        alert = driver.switchTo().alert();

        // Ambil teks dari alert
        alertText = alert.getText();
//        System.out.println("Alert Text: " + alertText);
     // Terima (klik OK) pada alert
        alert.accept();
        //TC3, admin
        email.clear();
        email.sendKeys("admin@gmail.com");
        pass.clear();
        pass.sendKeys("admin1");
        loginButton.click();
        Thread.sleep(500);
//        WebElement logout=driver.findElement(By.id("logout"));
        WebElement logout=wait.until(ExpectedConditions.elementToBeClickable(By.id("logout")));
        logout.click();
//        Thread.sleep(1000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
        loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
        email.clear();
        email.sendKeys("ryanko.4903@gmail.com");
        pass.clear();
        pass.sendKeys("123456");
        loginButton.click();
        
        
//        WebElement cari = driver.findElement(By.id("searchItem"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cari = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchItem")));
        
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

//        Point position = driver.manage().window().getPosition();
//        driver.manage().window().setPosition(new Point(0,0));
        WebElement kaki = driver.findElement(By.tagName("footer"));
        WebElement kategori = driver.findElement(By.id("category"));
        WebElement bestDeal = driver.findElement(By.id("best_deal"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bestDeal).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(kaki, 0, -600).perform();
//        actions.moveToElement(kategori).perform();
    	cari.click();
    	cari.sendKeys("rtx");
    	WebElement cariBtn = driver.findElement(By.id("searchButton"));
    	cariBtn.click();
        Thread.sleep(1000);
    	driver.quit();
    	System.out.println("Done");
    }
}
