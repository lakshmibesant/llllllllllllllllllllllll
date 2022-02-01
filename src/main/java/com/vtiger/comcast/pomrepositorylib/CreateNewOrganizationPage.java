package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class CreateNewOrganizationPage extends WebdriverUtility
{
	WebDriver driver;//global driver variable
	public CreateNewOrganizationPage(WebDriver driver)
	{
			PageFactory.initElements(driver, this);	
	}
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDD;
	
	
	public WebElement getIndustryDD() {
		return industryDD;
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	public void createOrg(String orgname){
		OrgNameEdt.sendKeys(orgname);
		SaveBtn.click();
		
	}
	
	public void createOrg(String orgname,String industry){
			OrgNameEdt.sendKeys(orgname);
			select(industry,industryDD);
			SaveBtn.click();
	} 
	
	
	

}
