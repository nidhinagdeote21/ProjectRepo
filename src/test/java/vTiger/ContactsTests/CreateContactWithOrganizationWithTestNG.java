package vTiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;
@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganizationWithTestNG extends BaseClass{


@Test(groups = "SmokeSuite")
public void CreateContactWithOrgTestNG() throws EncryptedDocumentException, IOException
{
	String LASTNAME = eUtil.ReadDataFromExcelSheet("Contacts", 4, 2);
	String ORGNAME = eUtil.ReadDataFromExcelSheet("Contacts", 4, 3)+jUtil.getRandomNumber();
	String INDUSTRY = eUtil.ReadDataFromExcelSheet("Organizations", 7, 3);
	
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationLink();
	Reporter.log("Organization button is clicked",true);
	//Assert.fail();
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrgLookUpImg();
	Reporter.log("Organization page is opened",true);
	//Assert.fail();
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrganization(ORGNAME, INDUSTRY);
	Reporter.log("Organization is created with "+ORGNAME+" and "+INDUSTRY,true);
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String Header = oip.getOrganizationHeaderText();
	/*if(Header.contains(ORGNAME))
	{
		System.out.println("org created/ pass");
	}*/
	Assert.assertTrue(Header.contains(ORGNAME));
	hp.clickOnContactsLink();
	ContactsPage cp=new ContactsPage(driver);
	cp.clickOnCreateContactLookUpImg();
	Reporter.log("Contact page is opened",true);
	CreateNewContactPage ccp=new CreateNewContactPage(driver);
	ccp.createNewContact(LASTNAME);
	
	ContactInfoPage cip=new ContactInfoPage(driver);
	String contactHeader = cip.getContactHeaderText();
	/*if(contactHeader.contains(LASTNAME))
	{
		System.out.println("Contact created successfully/Passed");
	}*/
	Assert.assertTrue(contactHeader.contains(LASTNAME));
	
}

@Test(groups = "RegressionSuite")
public void Test1Demo()
{
	System.out.println("this is a demo test");
}

}
