package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {      //Rule 1 :Create a seperate class for everypage in a application

	public Loginpage(WebDriver driver) //Rule 2:execute all the elements and initialize the elements pageFactory.initelements[initialization]
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")  //Rule 3:Identify all the elements using @findby/@findbys/@findAll(Declaration)
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindAll({@FindBy(id="submitButton") , @FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginBtn;
	//Rule 4:Declare all the elements as private and provide getters method for Utilization

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp(String username ,String password)
	{
		/*Step 1:Login */
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
		
		
	}
	
}
