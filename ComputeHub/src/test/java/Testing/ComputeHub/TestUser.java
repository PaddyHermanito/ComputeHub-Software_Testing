package Testing.ComputeHub;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	public void TC01() {
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
	public void TC02() {
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
	public void TC03() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement navbar = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Master Item")));
		
		Assert.assertEquals(hostUrl+"admin/", driver.getCurrentUrl());
	}
	
	@Test
	public void TC04() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement best_deal = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("best_deal")));
		
		Assert.assertEquals(hostUrl, driver.getCurrentUrl());
	}
	
	@Test
	public void TC05() {
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
		
		// Field address dikosongkan
		WebElement errorAddress = driver.findElement(By.id("error_address"));
        Assert.assertEquals("Address is required", errorAddress.getText());
	}
	
	@Test
	public void TC06() {
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
	public void TC07() {
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
	public void TC08() {
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
	public void TC09() {
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
	
	@Test
	public void TC12() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement best_deal = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("best_deal")));
        Actions actions = new Actions(driver);
        actions.moveToElement(best_deal).perform();
		
		List<WebElement> itemBestDeals = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='MuiButtonBase-root MuiCardActionArea-root css-1oitmrd-MuiButtonBase-root-MuiCardActionArea-root']")));
		itemBestDeals.get(0).click();
	}
	
	@Test
	public void TC13() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cari = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchItem")));
        cari.click();
    	cari.sendKeys("rtx");
    	WebElement cariBtn = driver.findElement(By.id("searchButton"));
    	cariBtn.click();
    	
    	List<WebElement> items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='MuiCardContent-root h-48 bg-abu-gelap css-46bh2p-MuiCardContent-root']//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom line-clamp-2 css-i9mztq-MuiTypography-root']")));
    	Boolean test = true;
    	for (WebElement i : items) {
			if (!i.getText().toLowerCase().contains("rtx")) {
				test = false;
				break;
			}
		}
    	Assert.assertTrue(test);
	}
	
	@Test
	public void TC14() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shop = wait.until(ExpectedConditions.elementToBeClickable(By.id("shop")));
        shop.click();
        
        WebElement comboCategory = driver.findElement(By.id("filter-category"));
        comboCategory.click();
        WebElement isiCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select__menu css-1nmdiq5-menu']")));
        isiCategory.click();
        comboCategory.click();
        WebElement inputCategory = driver.findElement(By.xpath("//input[@class='select__input' and @type='text']"));
        inputCategory.sendKeys("Monitor");
        isiCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select__menu css-1nmdiq5-menu']")));
        isiCategory.click();
        
        List<WebElement> items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='MuiCardContent-root h-48 bg-abu-gelap css-46bh2p-MuiCardContent-root']//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom line-clamp-2 css-i9mztq-MuiTypography-root']")));
	}
	
	@Test
	public void TC15() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shop = wait.until(ExpectedConditions.elementToBeClickable(By.id("shop")));
        shop.click();
        
        List<WebElement> items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='MuiCardContent-root h-48 bg-abu-gelap css-46bh2p-MuiCardContent-root']//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom line-clamp-2 css-i9mztq-MuiTypography-root']")));
        
        WebElement min = wait.until(ExpectedConditions.elementToBeClickable(By.id("min")));
    	min.clear();
    	min.sendKeys("1000000");
    	WebElement max = driver.findElement(By.id("max"));
    	max.click();
    	max.clear();
    	max.sendKeys("10000000");

    	items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='MuiCardContent-root h-48 bg-abu-gelap css-46bh2p-MuiCardContent-root']//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom line-clamp-2 css-i9mztq-MuiTypography-root']")));
	}
	
	@Test
	public void TC16() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shop = wait.until(ExpectedConditions.elementToBeClickable(By.id("shop")));
        shop.click();
        
        WebElement comboCategory = driver.findElement(By.id("filter-category"));
        comboCategory.click();
        WebElement isiCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select__menu css-1nmdiq5-menu']")));
        isiCategory.click();
        comboCategory.click();
        WebElement inputCategory = driver.findElement(By.xpath("//input[@class='select__input' and @type='text']"));
        inputCategory.sendKeys("Monitor");
        isiCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select__menu css-1nmdiq5-menu']")));
        isiCategory.click();
                
        List<WebElement> items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='MuiCardContent-root h-48 bg-abu-gelap css-46bh2p-MuiCardContent-root']//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom line-clamp-2 css-i9mztq-MuiTypography-root']")));
        
        WebElement min = wait.until(ExpectedConditions.elementToBeClickable(By.id("min")));
    	min.clear();
    	min.sendKeys("1000000");
    	WebElement max = driver.findElement(By.id("max"));
    	max.click();
    	max.clear();
    	max.sendKeys("10000000");

    	items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='MuiCardContent-root h-48 bg-abu-gelap css-46bh2p-MuiCardContent-root']//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom line-clamp-2 css-i9mztq-MuiTypography-root']")));
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
}
