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

public class TestAdmin {
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		
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
		pass.sendKeys("admin1");
		
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
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement customer = wait.until(ExpectedConditions.elementToBeClickable(By.id("customer")));
        customer.click();
        
        List<WebElement> listCustomer = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@class='MuiTableBody-root css-apqrd9-MuiTableBody-root']//tr[@class='MuiTableRow-root css-ixytsk-MuiTableRow-root']")));
	}
	
	// Delete User - Exclude biar tidak delete terus-terusan
//	@Test(enabled = false)
	@Test
	public void TC05() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement customer = wait.until(ExpectedConditions.elementToBeClickable(By.id("customer")));
        customer.click();
        
        List<WebElement> listCustomer = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("delete-user")));
        listCustomer.get(listCustomer.size()-1).click();
        
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("User deleted successfully", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	// Update User - Exclude biar tidak update terus-terusan
//	@Test(enabled = false)
	@Test
	public void TC06() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement customer = wait.until(ExpectedConditions.elementToBeClickable(By.id("customer")));
        customer.click();
        
        List<WebElement> listCustomer = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("edit-user")));
        listCustomer.get(listCustomer.size()-1).click();
        
        WebElement inputName = wait.until(ExpectedConditions.elementToBeClickable(By.id("edit_name")));
        WebElement inputAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("edit_address")));
        WebElement inputPhone = wait.until(ExpectedConditions.elementToBeClickable(By.id("edit_phone")));
        WebElement btnOk = wait.until(ExpectedConditions.elementToBeClickable(By.id("edit_ok")));
        
        String nameBefore = inputName.getText();
        String addressBefore = inputAddress.getText();
        String phoneBefore = inputPhone.getText();
        
        inputName.clear();
        inputName.sendKeys("Sakul");
        inputAddress.clear();
        inputAddress.sendKeys("Ngagel Jaya Tengah");
        inputPhone.clear();
        inputPhone.sendKeys("081234567890");
        btnOk.click();
        
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("User updated successfully", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
        
        Assert.assertNotEquals("Sakul", nameBefore);
        Assert.assertNotEquals("Ngagel Jaya Tengah", addressBefore);
        Assert.assertNotEquals("081234567890", phoneBefore);
	}
	
	// Delete Item - Exclude biar tidak delete terus-terusan
//	@Test(enabled=false)
	@Test
	public void TC07() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement masterItem = wait.until(ExpectedConditions.elementToBeClickable(By.id("Master Item")));
		masterItem.click();
		
		Actions actions = new Actions(driver);
		driver.switchTo().defaultContent();
		List<WebElement> listItem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("delete-item")));
		actions.moveToElement(listItem.get(0)).perform();
		listItem.get(0).click();
				
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Item deleted successfully", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC08() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement masterItem = wait.until(ExpectedConditions.elementToBeClickable(By.id("Master Item")));
		masterItem.click();
		
		Actions actions = new Actions(driver);
		driver.switchTo().defaultContent();
		WebElement edit0 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("edit0")));
		actions.moveToElement(edit0).perform();
		edit0.click();
		
		WebElement stock = wait.until(ExpectedConditions.elementToBeClickable(By.id("stock")));
		stock.sendKeys(Keys.ARROW_UP);
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(By.id("ok")));
        ok.click();
        
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Item saved successfully", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC09() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();

		WebElement Report = wait.until(ExpectedConditions.elementToBeClickable(By.id("Report")));
        Report.click();
        
        WebElement pending = wait.until(ExpectedConditions.elementToBeClickable(By.id("Pending")));
        pending.click();
        
        List<WebElement> listTrans = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("status-transaction")));
        Boolean test = true;
    	for (WebElement i : listTrans) {
			if (!i.getText().equals("Pending")) {
				test = false;
				break;
			}
		}
    	Assert.assertTrue(test);
	}
	
	@Test
	public void TC10() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();

		WebElement Report = wait.until(ExpectedConditions.elementToBeClickable(By.id("Report")));
        Report.click();
        
        WebElement searchinv= wait.until(ExpectedConditions.elementToBeClickable(By.id("searchinv")));
        searchinv.sendKeys("INV20231207011");
        
        WebElement invoice = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("invoice-transaction")));
        Assert.assertEquals("INV20231207011", invoice.getText());
	}
	
	@Test
	public void TC11() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();

		WebElement Report = wait.until(ExpectedConditions.elementToBeClickable(By.id("Report")));
        Report.click();
		
		WebElement dateStart = wait.until(ExpectedConditions.elementToBeClickable(By.id("dateStart")));
        dateStart.click();

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
        dateStart.sendKeys("11122023");
        
        List<WebElement> listTrans = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("date-transaction")));
        
        Boolean test = true;
        for (WebElement i : listTrans) {
			Integer tgl = Integer.parseInt(i.getText().split(" ")[0]);
			if (tgl < 11) {
				test = false;
				break;
			}
		}
    	Assert.assertTrue(test);
	}
	
	@Test
	public void TC12() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement confirmation = wait.until(ExpectedConditions.elementToBeClickable(By.id("Confirmation")));
		confirmation.click();
		
		List<WebElement> reject = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("reject-trans")));
		reject.get(0).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Transaction rejected", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC13() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement confirmation = wait.until(ExpectedConditions.elementToBeClickable(By.id("Confirmation")));
		confirmation.click();
		
		List<WebElement> reject = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("confirm-trans")));
		reject.get(0).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Transaction confirmed", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC14() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement chat = wait.until(ExpectedConditions.elementToBeClickable(By.id("Chat")));
        chat.click();
        WebElement user0 = wait.until(ExpectedConditions.elementToBeClickable(By.id("user0")));
        user0.click();
        WebElement textChat = wait.until(ExpectedConditions.elementToBeClickable(By.id("textChat")));
        textChat.sendKeys("ya");
        WebElement sendChat = wait.until(ExpectedConditions.elementToBeClickable(By.id("sendChat")));
        Thread.sleep(1000);
    	sendChat.click();
    	Thread.sleep(1000);
	}
	
	@Test
	public void TC15() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement chat = wait.until(ExpectedConditions.elementToBeClickable(By.id("Chat")));
        chat.click();
		
		WebElement searchUser = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchUser")));
        searchUser.sendKeys("ryan kohans");
        
        WebElement theUser = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name-customer")));
        Assert.assertEquals("ryan kohans", theUser.getText().toLowerCase());
	}
	
	@Test
	public void TC16() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement Promo = wait.until(ExpectedConditions.elementToBeClickable(By.id("Promo")));
        Promo.click();
        WebElement filter_promo = wait.until(ExpectedConditions.elementToBeClickable(By.id("filter-promo")));
        filter_promo.click();
        WebElement inputPromo = driver.findElement(By.xpath("//input[@class='select__input' and @type='text']"));
        inputPromo.sendKeys("logitech");
        WebElement menu_promo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select__menu css-1nmdiq5-menu']")));
        menu_promo.click();
        WebElement promo_name = wait.until(ExpectedConditions.elementToBeClickable(By.name("promo_name")));
        promo_name.sendKeys("promo baru");
        WebElement promo_price = wait.until(ExpectedConditions.elementToBeClickable(By.name("promo_price")));
        promo_price.sendKeys("150000");
        WebElement addpromo=wait.until(ExpectedConditions.elementToBeClickable(By.name("addpromo")));
        addpromo.click();
        
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("Promo has been added", alertText);
        alert.accept();
        
        driver.switchTo().defaultContent();
	}
	
	@Test
	public void TC17() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();
		
		WebElement Promo = wait.until(ExpectedConditions.elementToBeClickable(By.id("Promo")));
        Promo.click();
        
        int idx = -1;
        List<WebElement> listName = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("promo-name")));
        for (int i = 0; i < listName.size(); i++) {
			if (listName.get(i).getText().equals("promo baru")) {
				idx = i;
				break;
			}
		}
        if (idx != -1) {
        	List<WebElement> listBtn = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("promo-delete")));
    		listBtn.get(idx).click();
            
    		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert = driver.switchTo().alert();

            String alertText = alert.getText();
            Assert.assertEquals("Promo has been deleted", alertText);
            alert.accept();
            
            driver.switchTo().defaultContent();
        }
	}
	
	@Test
	public void TC18() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
		login.click();
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		email.sendKeys("admin@gmail.com");
		
		WebElement pass= driver.findElement(By.id("pass"));
		pass.sendKeys("admin1");
		
		WebElement loginButton = driver.findElement(By.id("login"));
		loginButton.click();

		Thread.sleep(1000);
			
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout")));
        logout.click();
        
        Assert.assertEquals(hostUrl+"login", driver.getCurrentUrl());
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
}
