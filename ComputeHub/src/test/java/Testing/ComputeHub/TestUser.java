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
	public String hostUrl = "http://localhost:5173/";
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    	
    	driver = new ChromeDriver();
    	driver.get(hostUrl);
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
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Password salah", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC2() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("paddy.h21@mhs.istts.ac.id");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Email is not registered", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC3() throws InterruptedException {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    		
		Thread.sleep(1000);
		Assert.assertEquals(hostUrl+"admin/", driver.getCurrentUrl());
	}
	
	@Test
	public void TC4() throws InterruptedException {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    		
		Thread.sleep(1000);
		Assert.assertEquals(hostUrl, driver.getCurrentUrl());
	}
	
	@Test
	public void TC5() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement toRegister = driver.findElement(By.id("register_now"));
		toRegister.click();
		
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Reddy");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("reddyalexandro746@gmail.com");
		
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("");
		
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("081234567890");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		WebElement confirm = driver.findElement(By.id("confirm"));
		confirm.sendKeys("123456");
		
		WebElement btnRegister = driver.findElement(By.id("register"));
		btnRegister.click();
		
		// Field address dikosongi
		WebElement errorAddress = driver.findElement(By.id("error_address"));
        Assert.assertEquals("Address is required", errorAddress.getText());
	}
	
	@Test
	public void TC6() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement toRegister = driver.findElement(By.id("register_now"));
		toRegister.click();
		
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Re");
		
		WebElement btnRegister = driver.findElement(By.id("register"));
		btnRegister.click();
		
		WebElement errorName = driver.findElement(By.id("error_name"));
        Assert.assertEquals("Name must be at least 3 characters", errorName.getText());
	}
	
	@Test
	public void TC7() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement toRegister = driver.findElement(By.id("register_now"));
		toRegister.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("reddyalexandro746gmailcom");
		
		WebElement btnRegister = driver.findElement(By.id("register"));
		btnRegister.click();
		
		WebElement errorEmail = driver.findElement(By.id("error_email"));
        Assert.assertEquals("Email is not a valid email", errorEmail.getText());
	}
	
	@Test
	public void TC8() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement toRegister = driver.findElement(By.id("register_now"));
		toRegister.click();
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("1234");
		
		WebElement btnRegister = driver.findElement(By.id("register"));
		btnRegister.click();
		
		WebElement errorPassword = driver.findElement(By.id("error_password"));
        Assert.assertEquals("Password must be at least 6 characters", errorPassword.getText());
	}
	
	@Test
	public void TC9() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement toRegister = driver.findElement(By.id("register_now"));
		toRegister.click();
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		WebElement confirm = driver.findElement(By.id("confirm"));
		confirm.sendKeys("654321");
		
		WebElement btnRegister = driver.findElement(By.id("register"));
		btnRegister.click();
		
		WebElement errorConfirm = driver.findElement(By.id("error_confirm"));
        Assert.assertEquals("Confirmation Password doesn't match with password", errorConfirm.getText());
	}
	
	@Test
	public void TC10() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement toRegister = driver.findElement(By.id("register_now"));
		toRegister.click();
		
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Ryan");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("Ngagel Jaya");
		
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("081234567890");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		WebElement confirm = driver.findElement(By.id("confirm"));
		confirm.sendKeys("123456");
		
		WebElement btnRegister = driver.findElement(By.id("register"));
		btnRegister.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Email is already used / banned", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	// Register User - Exclude biar tidak register ulang"
	@Test(enabled = false)
	public void TC11() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement toRegister = driver.findElement(By.id("register_now"));
		toRegister.click();
		
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Reddy");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("reddyalexandro746@gmail.com");
		
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("Ngagel Jaya Tengah");
		
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("081234567890");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		WebElement confirm = driver.findElement(By.id("confirm"));
		confirm.sendKeys("123456");
		
		WebElement btnRegister = driver.findElement(By.id("register"));
		btnRegister.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("User created successfully", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
}
