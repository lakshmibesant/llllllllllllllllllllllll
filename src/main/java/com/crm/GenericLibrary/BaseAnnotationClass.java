package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.vtiger.comcast.pomrepositorylib.Homepage;
import com.vtiger.comcast.pomrepositorylib.Loginpage;


public class BaseAnnotationClass {

	public FileUtility Flib=new FileUtility();
	public ExcelUtility Elib=new ExcelUtility();
	public JavaUtility Jlib=new JavaUtility ();
	public WebdriverUtility Wlib=new WebdriverUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBS()
	{
		System.out.println(">>>>>>>>Connecting to Database>>>>>>>>>>");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void configBC(/*String Browser*/) throws Throwable
	{
		/*Read common data */
		
		String Browser = Flib.readDatafromPropertyfile("browser");
		String Url = Flib.readDatafromPropertyfile("url");
		
		

		if(Browser.equals("chrome")){
			driver=new ChromeDriver();}
			else if(Browser.equals("firefox")){
					driver=new FirefoxDriver();}
			else {
				driver=new InternetExplorerDriver();}
		
		    driver.get(Url);
		    sDriver=driver;
	}	
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws Throwable
		{
		String Username = Flib.readDatafromPropertyfile("username");
		String Password = Flib.readDatafromPropertyfile("password");
		Wlib.waitForPageLoad(driver);
		Loginpage lp=new Loginpage(driver);
		lp.loginToApp(Username, Password);
		}
	
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void configAM()
	{
		Homepage hp=new Homepage(driver);
		hp.logOut(driver);
	
	}
	
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void configAC()
	{
		driver.close();
	}
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void configAS()
	{
		System.out.println("<<<<<<<<<<<<<<Disconnect Database>>>>>>>>>>>>>>");
	}
	
}
