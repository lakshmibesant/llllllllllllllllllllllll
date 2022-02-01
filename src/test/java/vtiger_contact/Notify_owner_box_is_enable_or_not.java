package vtiger_contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Notify_owner_box_is_enable_or_not {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		driver.findElement(By.xpath("(//input[@name='notify_owner'])")).click();
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		
		
		
			
					
					
					
				}
				
		
		
		
		
		
		

	}


