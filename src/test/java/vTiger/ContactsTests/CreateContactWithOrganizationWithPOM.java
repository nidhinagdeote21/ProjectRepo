package vTiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizationWithPOM {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	WebDriver driver=null;
	String LASTNAME = eUtil.ReadDataFromExcelSheet("Contacts", 4, 2);
	String ORGNAME = eUtil.ReadDataFromExcelSheet("Contacts", 4, 3)+jUtil.getRandomNumber();
	
	if(BROWSER.equalsIgnoreCase("Chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("FireFox"))
	{
		driver=new FirefoxDriver();
	}
	else {
		
		System.out.println("Invalid Browser");
	}
	wUtil.maximizeWindow(driver);
	wUtil.waitForPageToBeLoaded(driver);
	driver.get(URL);
	
	LoginPage lp=new LoginPage(driver);
	lp.LoginToWebPage(USERNAME, PASSWORD);
	
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationLink();
	
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrgLookUpImg();
	
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrganization(ORGNAME);
	
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String OrganizationHeader = oip.getOrganizationHeaderText();
	/*if(OrganizationHeader.contains(ORGNAME))
	{
		System.out.println(OrganizationHeader);
		System.out.println("Organization Created");
	}
	else
	{
		System.out.println("Organization Not Created");
	}*/
	Assert.assertTrue(OrganizationHeader.contains(ORGNAME));
	
	hp.clickOnContactsLink();
	
	ContactsPage cp=new ContactsPage(driver);
	cp.clickOnCreateContactLookUpImg();
	
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.createNewContact(LASTNAME, ORGNAME, driver);
	
	ContactInfoPage cip=new ContactInfoPage(driver);
	String ContactHeader = cip.getContactHeaderText();
	
/*	if(ContactHeader.contains(LASTNAME))
	{
		System.out.println(ContactHeader);
		System.out.println("Contact Created");
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Contact Not Created");
		System.out.println("Fail");
	}*/
	Assert.assertEquals(ContactHeader.contains(LASTNAME), true);
	hp.logoutOfApp(driver);
	
	
	
	
	
	
	}

}
