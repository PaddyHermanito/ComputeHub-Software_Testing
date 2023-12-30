package Testing.ComputeHub;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        
        WebElement Master_Item = wait.until(ExpectedConditions.elementToBeClickable(By.id("Master Item")));
        Master_Item.click();
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        WebElement actions0=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("actions0"))).findElement(By.id("edit0"));        
//        WebElement actions0=driver.findElement(By.id("actions0"));
//        WebElement edit0=actions0.findElement(By.id("edit0"));
        actions.moveToElement(actions0).perform();
//        WebElement edit0 = wait.until(ExpectedConditions.elementToBeClickable(By.id("edit0")));
//        WebElement edit0 = actions0.findElement(By.id("edit0"));
//        actions.moveToElement(edit0);
//        edit0.click();
        actions0.click();
        WebElement stock = wait.until(ExpectedConditions.elementToBeClickable(By.id("stock")));
        stock.sendKeys("1");
        WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(By.id("ok")));
        ok.click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        // Ambil teks dari alert
        alertText = alert.getText();
//        System.out.println("Alert Text: " + alertText);
     // Terima (klik OK) pada alert
        alert.accept();
     // Switch back to the default content
        driver.switchTo().defaultContent();
        actions0=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("actions0"))).findElement(By.id("edit0"));     
        actions.moveToElement(actions0).perform();
        WebElement Report = wait.until(ExpectedConditions.elementToBeClickable(By.id("Report")));
        Report.click();
        WebElement pending = wait.until(ExpectedConditions.elementToBeClickable(By.id("Pending")));
        pending.click();
        WebElement AllTrans = wait.until(ExpectedConditions.elementToBeClickable(By.id("All Transaction")));
        AllTrans.click();
        WebElement searchinv= wait.until(ExpectedConditions.elementToBeClickable(By.id("searchinv")));
        searchinv.sendKeys("INV20231207011");
        searchinv.clear();
        WebElement dateStart = wait.until(ExpectedConditions.elementToBeClickable(By.id("dateStart")));
        dateStart.click();
        actions.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
//        dateStart.clear();
        dateStart.sendKeys("08122023");
        
        //skip ke tc15
        WebElement chat = wait.until(ExpectedConditions.elementToBeClickable(By.id("Chat")));
        chat.click();
        WebElement user0 = wait.until(ExpectedConditions.elementToBeClickable(By.id("user0")));
        user0.click();
        WebElement textChat = wait.until(ExpectedConditions.elementToBeClickable(By.id("textChat")));
        textChat.sendKeys("ya");
        WebElement sendChat = wait.until(ExpectedConditions.elementToBeClickable(By.id("sendChat")));
        sendChat.click();
        WebElement searchUser = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchUser")));
        searchUser.sendKeys("ryan kohans");
        
        WebElement Promo = wait.until(ExpectedConditions.elementToBeClickable(By.id("Promo")));
        Promo.click();
        WebElement filter_promo = wait.until(ExpectedConditions.elementToBeClickable(By.id("filter-promo")));
//        WebElement filter_promo = driver.findElement(By.id("filter-promo"));
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
        
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();

        // Ambil teks dari alert
        alertText = alert.getText();
//        System.out.println("Alert Text: " + alertText);
     // Terima (klik OK) pada alert
        alert.accept();
        
        
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout")));
        logout.click();
        
        Thread.sleep(2000);
    	driver.quit();
    	System.out.println("Done");
	}

}
