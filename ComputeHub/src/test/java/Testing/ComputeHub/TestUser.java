package Testing.ComputeHub;

import java.time.Duration;
import java.util.List;
import java.util.Random;

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
	public String hostUrl = "http://computehub.vercel.app/";
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    	
    	driver = new ChromeDriver();
    	driver.get(hostUrl);
    	driver.manage().window().maximize();
	}
	
	@Test
	public void TC01() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123asdf");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    	
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Password salah", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC02() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("paddy.h21@mhs.istts.ac.id");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    	
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Email is not registered", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC03() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    	
		WebElement navbar = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Master Item")));
		
		Assert.assertEquals(hostUrl+"admin/", driver.getCurrentUrl());
	}
	
	@Test
	public void TC04() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
    		
		WebElement best_deal = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("best_deal")));
		
		Assert.assertEquals(hostUrl, driver.getCurrentUrl());
	}
	
	@Test
	public void TC05() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
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
		
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Email is already used / banned", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	// Register User - Exclude biar tidak register ulang"
	@Test(enabled = false)
//	@Test
	public void TC11() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
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
		
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("User created successfully", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC12() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();

		WebElement best_deal = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("best_deal")));
        Actions actions = new Actions(driver);
        actions.moveToElement(best_deal).perform();
		
		List<WebElement> itemBestDeals = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='MuiButtonBase-root MuiCardActionArea-root css-1oitmrd-MuiButtonBase-root-MuiCardActionArea-root']")));
		itemBestDeals.get(0).click();
	}
	
	@Test
	public void TC13() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
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
	public void TC15() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
        WebElement shop = wait.until(ExpectedConditions.elementToBeClickable(By.id("shop")));
        shop.click();
        
        List<WebElement> items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='MuiCardContent-root h-48 bg-abu-gelap css-46bh2p-MuiCardContent-root']//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom line-clamp-2 css-i9mztq-MuiTypography-root']")));
        
        WebElement min = wait.until(ExpectedConditions.elementToBeClickable(By.id("min")));
        min.clear();
        Thread.sleep(250);
    	min.sendKeys("1000000");
    	WebElement max = driver.findElement(By.id("max"));
    	max.clear();
        Thread.sleep(250);
    	max.sendKeys("10000000");

    	items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='MuiCardContent-root h-48 bg-abu-gelap css-46bh2p-MuiCardContent-root']//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom line-clamp-2 css-i9mztq-MuiTypography-root']")));
	}
	
	@Test
	public void TC16() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
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
        Thread.sleep(250);
    	min.sendKeys("1000000");
    	WebElement max = driver.findElement(By.id("max"));
    	max.clear();
    	Thread.sleep(250);
    	max.sendKeys("10000000");

    	items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='MuiCardContent-root h-48 bg-abu-gelap css-46bh2p-MuiCardContent-root']//div[@class='MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom line-clamp-2 css-i9mztq-MuiTypography-root']")));
	}
	
	@Test
	public void TC17() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement chat = wait.until(ExpectedConditions.elementToBeClickable(By.id("chat")));
		chat.click();
		
		WebElement textChat = wait.until(ExpectedConditions.elementToBeClickable(By.id("textChat")));
    	textChat.sendKeys("halo software testing");
    	WebElement sendChat = driver.findElement(By.id("sendChat"));
    	Thread.sleep(1000);
    	sendChat.click();
    	Thread.sleep(1000);
	}
	
	@Test
	public void TC18() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();

		WebElement best_deal = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("best_deal")));
        Actions actions = new Actions(driver);
        actions.moveToElement(best_deal).perform();
		
		List<WebElement> itemBestDeals = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='MuiButtonBase-root MuiCardActionArea-root css-1oitmrd-MuiButtonBase-root-MuiCardActionArea-root']")));
		Random rand = new Random();
		itemBestDeals.get(rand.nextInt(itemBestDeals.size())).click();
		
		WebElement addcart = wait.until(ExpectedConditions.elementToBeClickable(By.id("addcart")));
    	addcart.click();
    	
    	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Added to cart", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
        
        List<WebElement> listCart = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='bg-abu-super-gelap rounded-2xl px-10 py-8 mb-5 text-white flex relative']")));
	}
	
	@Test
	public void TC19() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();

		WebElement best_deal = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("best_deal")));
        Actions actions = new Actions(driver);
        actions.moveToElement(best_deal).perform();
		
		List<WebElement> itemBestDeals = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='MuiButtonBase-root MuiCardActionArea-root css-1oitmrd-MuiButtonBase-root-MuiCardActionArea-root']")));
		Random rand = new Random();
		itemBestDeals.get(rand.nextInt(itemBestDeals.size())).click();
		
		WebElement plus = wait.until(ExpectedConditions.elementToBeClickable(By.id("+")));
		WebElement bnykStok = driver.findElement(By.id("info-stok"));
		String[] realStok = (bnykStok.getText()).split(" : ");
		// Melebihi stok 10
        for (int i = 0; i < Integer.parseInt(realStok[1])+10; i++) {
			plus.click();
		}
        Thread.sleep(1000);
		
		WebElement addcart = wait.until(ExpectedConditions.elementToBeClickable(By.id("addcart")));
    	addcart.click();
    	
    	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Added to cart", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
        
        List<WebElement> listCart = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='bg-abu-super-gelap rounded-2xl px-10 py-8 mb-5 text-white flex relative']")));
	}
	
	@Test
	public void TC20() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement build = wait.until(ExpectedConditions.elementToBeClickable(By.id("build")));
		build.click();
		
		String[] tipeItem = {"Processor", "Motherboard", "VGA", "RAM", "PSU", "SSD", "HDD", "Casing", "Cooling", "Monitor", "Keyboard", "Mouse"};
		for (String tipe : tipeItem) {
			WebElement select = driver.findElement(By.id(tipe));
			select.click();
			WebElement isiSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select__menu css-1nmdiq5-menu']")));
			isiSelect.click();
		}
		WebElement addtocart = driver.findElement(By.id("addCart"));
		addtocart.click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Added to cart", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
        
        List<WebElement> listCart = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='bg-abu-super-gelap rounded-2xl px-10 py-8 mb-5 text-white flex relative']")));
	}
	
	@Test
	public void TC21() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.id("user")));
        user.click();
        WebElement userProfile = wait.until(ExpectedConditions.elementToBeClickable(By.id("userProfile")));
        userProfile.click();
        WebElement history = wait.until(ExpectedConditions.elementToBeClickable(By.id("history")));
        history.click();
        WebElement Rejected = wait.until(ExpectedConditions.elementToBeClickable(By.id("Rejected")));
        Rejected.click();
        
        List<WebElement> listHistory = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("list-history")));
	}
	
	@Test
	public void TC22() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("ryanko.4903@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.id("user")));
        user.click();
        WebElement userProfile = wait.until(ExpectedConditions.elementToBeClickable(By.id("userProfile")));
        userProfile.click();
        WebElement history = wait.until(ExpectedConditions.elementToBeClickable(By.id("history")));
        history.click();
        WebElement Rejected = wait.until(ExpectedConditions.elementToBeClickable(By.id("Pending")));
        Rejected.click();
        
        List<WebElement> listHistory = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("detail-history")));
        listHistory.get(0).click();
        WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.id("cancel")));
        cancel.click();
        
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Transaction saved successfully", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
}
