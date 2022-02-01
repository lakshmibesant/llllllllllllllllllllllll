package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	
	public Homepage(WebDriver driver)
	{
			PageFactory.initElements(driver, this);	
	}
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactLink;
	
	public WebElement getContactLink() {
		return ContactLink;
	}
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getAdministratorLink() {
		return AdministratorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void logOut(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(AdministratorImg).perform();
		signOutLink.click();
	}
	
	
	
}
