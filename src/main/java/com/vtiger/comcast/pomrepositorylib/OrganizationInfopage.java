package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrganizationInfopage
{
	WebDriver driver;//global driver variable
	public OrganizationInfopage(WebDriver driver)
	{
			PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Succesfullmsg;
	
	
	
	public WebElement getSuccesfullmsg() {
		return Succesfullmsg;
	}
	
	
	

}
