package com.crm.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImpClass implements ITestListener
{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{
		String FailedTestName = result.getMethod().getMethodName();
		System.out.println("========execute>>>>>I am Listening=============>");
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseAnnotationClass.sDriver);
		File srcfile = edriver.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./screenshots/"+FailedTestName+".png");
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	

	
	

}
