package vtiger_contact;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Portal_userbox_enabled {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		
		String browser=pObj.getProperty("browser");
		String url=pObj.getProperty("url");
		String username=pObj.getProperty("username");
		String password=pObj.getProperty("password");
		
		WebDriver driver=null;
		
		if(browser.equals("chrome")){
				driver=new ChromeDriver();
		}else if(browser.equals("firefox")){
			driver=new FirefoxDriver();
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement ele = driver.findElement(By.xpath("//a[.='Contacts']"));
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("erroda");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Thread.sleep(2000);
		for (int i = 0; i < 5; i++) {
			js.executeScript("window.scrollBy(0,700)");
			driver.findElement(By.xpath("//input[@name='portal']")).click();
			WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			act.moveToElement(ele1).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();

			
			
		}
		
		
	}

}
