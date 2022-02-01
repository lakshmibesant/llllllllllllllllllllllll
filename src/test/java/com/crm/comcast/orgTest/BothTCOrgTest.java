package com.crm.comcast.orgTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositorylib.CreateNewOrganizationPage;
import com.vtiger.comcast.pomrepositorylib.Homepage;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfopage;
import com.vtiger.comcast.pomrepositorylib.Organizationspage;
@Listeners(com.crm.GenericLibrary.ListImpClass.class)


public class BothTCOrgTest extends BaseAnnotationClass  
{
	@Test(groups="smokeTest")
	public void contactTest() throws Throwable{
		
	/*read data from excel*/
	String orgName = Elib.getDataFromExcel("org",1,2)+"_"+Jlib.getRandamNumber();
	

	/*Navigate to Organization*/
	Homepage hp=new Homepage(driver);
	hp.getOrganizationsLink().click();
	Thread.sleep(4000);
	
	
    /*navigate to create organization*/
	Organizationspage op=new Organizationspage(driver);
	op.getCreateOrgImg().click();
	
   /*Creating new organization page */
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createOrg(orgName);
	
   /*verification*/
	OrganizationInfopage oip=new OrganizationInfopage(driver);
	String msg = oip.getSuccesfullmsg().getText();
	Assert.assertTrue(msg.contains(orgName));
}
	
	
	@Test(groups="regressionTest")
	  public void createOrgwithIndustry() throws Throwable{
		/*read data from excel*/
		String orgName = Elib.getDataFromExcel("org",4,2)+"_"+Jlib.getRandamNumber();
		String industry = Elib.getDataFromExcel("org", 4, 3);
		
		
		/*Navigate to Organization*/
		Homepage hp=new Homepage(driver);
		hp.getOrganizationsLink().click();
		Thread.sleep(5000);
		
		/*navigate to create organization*/
		Organizationspage op=new Organizationspage(driver);
		op.getCreateOrgImg().click();
		
		/*Creating new organization page  */
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry);
		
		
		
	/*verification*/	
		OrganizationInfopage oip=new OrganizationInfopage(driver);
		String msg = oip.getSuccesfullmsg().getText();
		Assert.assertTrue(msg.contains(orgName));
	}
}


  
