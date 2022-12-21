package vTiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;
@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateOrganizationsTestWithTestNG extends BaseClass {
@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplementation.class)
public void createOrgTest() throws EncryptedDocumentException, IOException
{	/*Excel File - Test Data*/
	String ORGNAME = eUtil.ReadDataFromExcelSheet("Organizations", 1, 2)+jUtil.getRandomNumber();
	//Step: 1 - Click on Organizations Link
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationLink();
	Reporter.log("Homepage is displayed",true);
	
	//Step: 2 - Click on Organizations Lookup Image
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrgLookUpImg();	
	Reporter.log("Organization page is displayed",true);
	//Step: 3 - Create on Organization with mandatory information and save
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrganization(ORGNAME);
	Reporter.log("Organization",true);
	//Step: 4 - Validate
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String HEADER = oip.getOrganizationHeaderText();
	///Assert.fail();
	/*if(HEADER.contains(ORGNAME))
	{
		System.out.println(HEADER);
		System.out.println("Organization is created");
	}*/
	Assert.assertEquals(HEADER.contains(ORGNAME), true);
	
	
	
	
}
}
