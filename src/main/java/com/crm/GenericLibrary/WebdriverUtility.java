package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;


/**
 * 
 * @author Lakshmi Raj
 *
 */

public class WebdriverUtility 
{
	/**
	 * this method used to maximize window 
	 */
		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		
		
		
		
		
		/**
		 * this method will wait for 20 sec until the page get loaded
		 * @param driver
		 */
		
		public void waitForPageLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		}
		
		
		
		/**
		 * this method will wait till the element become clickable 
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeClickable(WebDriver driver,WebElement element)
		{
			
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
			
		
		
		
		/**
		 * this method will wait till element is found and perfrom click action
		 * @param element
		 * @throws InterruptedException
		 */
		public void waitAndClick(WebElement element) throws InterruptedException
		{
			int count=0;
			while(count<20)
			{
				try{
					element.click();
					break;
		
				}
				catch(Throwable e){
					Thread.sleep(1000);
					count++;
					
				}
			}
		}
		
		
		/**
		 * this method is used to handle dropdown using index
		 * @param ele
		 * @param index
		 */
		public void select(WebElement ele,int index)
		{
			Select s=new Select(ele);
			s.selectByIndex(index);
		}
		
		
		
		/**
		 * this method is used to handle dropdown using value
		 * @param ele
		 * @param value
		 */
		public void select(WebElement ele,String value)
		{
			Select s=new Select(ele);
			s.selectByValue(value);
		}
		
		
		
		/**
		 * this method is used to handle dropdown using visible Text
		 * @param text
		 * @param ele
		 */
		public void select(String text,WebElement ele)
		{
			Select s=new Select(ele);
			s.selectByVisibleText(text);
		}
		
		
		
		/**
		 * this method is used to perform double click 
		 * @param driver
		 */
		public void doubleClick(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.doubleClick().perform();
			
		}
		
		
		/**
		 * this method is used to perform mousehover
		 * @param driver
		 * @param ele
		 */
		public void mouseOverAction(WebDriver driver,WebElement ele)
		{
			Actions act=new Actions(driver);
			act.moveToElement(ele).perform();
			
		}
		
		/**
		 * this method is used to perfrom right click
		 * @param driver
		 */
		public void rightClick(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.contextClick().perform();
			
		}
		
		
		
		/**
		 * this method is used to perform drag and drop
		 * @param driver
		 * @param src
		 * @param dest
		 */
		public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest)
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(src,dest).perform();
		}
		
		/**
		 * this method is used to accept the alert popup
		 * @param driver
		 */
		public void  acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		
		/**
		 * this method is used to dismiss the alert popup
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * method is to take screenshot of failed testcases
		 * @param driver
		 * @param screenshotname
		 * @throws Throwable
		 */
		public void getScreenShot(WebDriver driver,String screenshotname )throws Throwable
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File temp =ts.getScreenshotAs(OutputType.FILE);
			File hdd =new File("./screenshot/"+screenshotname+".png");
			Files.copy(temp,hdd);

		}
		
		/**
		 * switch to window depending upon the partial window title
		 * @param driver
		 * @param partialWinTitle
		 */
		public void switchToWindow(WebDriver driver,String partialWinTitle )
		{
			Set<String> window=driver.getWindowHandles();
			Iterator<String> it=window.iterator();
			while(it.hasNext())
			{
				String winId=it.next();
				String currentWindowTitle=driver.switchTo().window(winId).getTitle();
				if(currentWindowTitle.contains(partialWinTitle))
				{
					break;
				}
			}
				
			}
		
		/**
		 * method is for scroll action in a webpage
		 * @param driver
		 * @param ele
		 */
		public void scrollToWebelement(WebDriver driver,WebElement ele)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			int y=ele.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")", ele);
		}
		
		
		/**
		 * method is used to switch to frame using index
		 * @param driver
		 * @param index
		 */
		public void switchToFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
			
		}
		
		/**
		 * method is used to switch to frame using element
		 * @param driver
		 * @param ele
		 */
		public void switchToFrame(WebDriver driver,WebElement ele)
				{
					driver.switchTo().frame(ele);
				}
		
		/**
		 * method is used to switch to frame using id or name 
		 * @param driver
		 * @param idOrName
		 */
		public void switchToFrame(WebDriver driver,String idOrName)
			{
			
					driver.switchTo().frame(idOrName);
					
			}
		public void switchToDefaultFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
			
		}
		
		public void switchToFrame(WebDriver driver)
				{
			driver.switchTo().parentFrame();
			
				}
		
		
		/**
	     * this method is to get press virtualKey on OS	
	     * @throws AWTException
	     */
	    
	    public void pressVirtulEnterKey() throws AWTException
	    {
	    	Robot r=new Robot();
	    	r.keyPress(KeyEvent.VK_ENTER);
	    	r.keyRelease(KeyEvent.VK_ENTER);
	    	
		}

}





