package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactpage {

	
	public CreatingNewContactpage(WebDriver driver)
	{
			PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;

	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public void createLastName(String LastName ){
		lastNameEdt.sendKeys(LastName);
		SaveBtn.click();
	}
}
