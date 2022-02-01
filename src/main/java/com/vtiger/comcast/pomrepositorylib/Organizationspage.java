package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationspage 
{
	WebDriver driver;//global driver variable
	public Organizationspage(WebDriver driver)
	{
			PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgImg;
	

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	

}
