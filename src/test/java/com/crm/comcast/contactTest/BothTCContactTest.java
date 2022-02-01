package com.crm.comcast.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositorylib.ContactInfopage;
import com.vtiger.comcast.pomrepositorylib.ContactPage;
import com.vtiger.comcast.pomrepositorylib.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepositorylib.CreatingNewContactpage;
import com.vtiger.comcast.pomrepositorylib.Homepage;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfopage;
import com.vtiger.comcast.pomrepositorylib.Organizationspage;

public class BothTCContactTest extends BaseAnnotationClass 
{
	
	@Test(groups="smokeTest")
	public void CreateContactTest() throws Throwable
	{
		/*read data from excel*/
			String lastName = Elib.getDataFromExcel("contact",1,2);
		
		/*Navigate to Contact*/
			Homepage hp=new Homepage(driver);
			hp.getContactLink().click();
	
		/*clicking on create new contactlookup*/
			ContactPage cp=new ContactPage(driver);
			cp.getCreatecontactlookup().click();
	
		/*naviagte to create contact lookup*/
			CreatingNewContactpage cncp= new CreatingNewContactpage(driver);
			cncp.createLastName(lastName);
			
		/*verification*/
			ContactInfopage cip=new ContactInfopage(driver);
			String actmsg = cip.getSuccesfullmsg().getText();
			System.out.println(actmsg);
			Assert.assertTrue(actmsg.contains(lastName));
	}


	
	@Test(groups="regressionTest")
	public void CreateOrgWithIndsDDTest() throws Throwable
	{
		String orgName = Elib.getDataFromExcel("contact",4,2)+"_"+Jlib.getRandamNumber();
		String lastname = Elib.getDataFromExcel("contact", 4, 3);
		
		
		
		/*Navigate to Organization*/
		Homepage hp=new Homepage(driver);
		hp.getOrganizationsLink().click();
		Thread.sleep(4000);
		
	/*naviagte to create organization*/
		Organizationspage op=new Organizationspage(driver);
		op.getCreateOrgImg().click();
		
	/*Creating new organization page */
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
	/*verification header of Organization*/
		OrganizationInfopage oip=new OrganizationInfopage(driver);
		Wlib.waitForElementToBeClickable(driver, oip.getSuccesfullmsg());
		String msg = oip.getSuccesfullmsg().getText();
		Assert.assertTrue(msg.contains(orgName));
	
		/*Naviagate to contact */
		Homepage hp1=new Homepage(driver);
		hp1.getContactLink().click();
		Thread.sleep(5000);
		
		/*clicking on create new contactlookup*/
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactlookup().click();
		
		/*naviagte to create contact lookup*/
		CreatingNewContactpage cncp= new CreatingNewContactpage(driver);
		cncp.createLastName(lastname);
				
	/*verification*/
		ContactInfopage cip=new ContactInfopage(driver);
		String actmsg = cip.getSuccesfullmsg().getText();
		System.out.println(actmsg);
		Assert.assertTrue(actmsg.contains(lastname));
	}
}
