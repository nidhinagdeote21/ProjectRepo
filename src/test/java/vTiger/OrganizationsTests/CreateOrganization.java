package vTiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrganization {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	WebDriverUtility wUtil=new WebDriverUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	JavaUtility jUtil=new JavaUtility();
	
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	String ORGNAME = eUtil.ReadDataFromExcelSheet("Organizations", 4, 2)+jUtil.getRandomNumber();
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("Chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")){
		driver=new FirefoxDriver();		
	}
	else
	{
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
	String OrgHeader = oip.getOrganizationHeaderText();
	
	if(OrgHeader.contains(ORGNAME))
	{
		System.out.println(OrgHeader);
		System.out.println("Organization Created");
		System.out.println("pass");
	}
	else
	{
		System.out.println("Organization Not Created");
	}
	
	hp.logoutOfApp(driver);
	
	
	}

}
