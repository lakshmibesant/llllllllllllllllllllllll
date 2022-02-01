package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	
	
	public ContactPage(WebDriver driver)
		{
		PageFactory.initElements(driver, this);	
		}

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLookup;
	
	
	public WebElement getCreatecontactlookup() {
		return createContactLookup;
	}
}