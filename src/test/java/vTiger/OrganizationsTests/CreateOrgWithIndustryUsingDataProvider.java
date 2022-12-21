package vTiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrgWithIndustryUsingDataProvider {

	
	PropertyFileUtility pUtil=new PropertyFileUtility();
	JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	@Test(dataProvider = "IndustryName")
	public void createMultipleOrg(String ORG, String INDUSTRY) throws EncryptedDocumentException, IOException {
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	String ORGNAME = ORG+jUtil.getRandomNumber();
	

	WebDriver driver = null;

	// Step 2: Launch Browser - run time polymorphism - driver
	
	if (BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	} else if (BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	} else {
		System.out.println("invalid browser name");
	}
	wUtil.maximizeWindow(driver);
	wUtil.waitForPageToBeLoaded(driver);
	driver.get(URL);
	
	// Step 3: Login To Application
	
	LoginPage lp=new LoginPage(driver);
	lp.LoginToWebPage(USERNAME, PASSWORD);
	
	// Step 4: Click on Organizations Link
	
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationLink();
	
	// Step 5: click on create organization lookup image
	
	OrganizationsPage op = new OrganizationsPage(driver);
	op.clickOnCreateOrgLookUpImg();
	
	// Step 6: click on create new organization
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrganization(ORGNAME, INDUSTRY);
	
	// Step 7: Validate
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String headerText = oip.getOrganizationHeaderText();
	
	if(headerText.contains(ORGNAME))
	{
		System.out.println("The Organization is created successfully");
	}
	else
	{
		System.out.println("The Organization is not created");
	}
	
	// Step 8: logout
	hp.logoutOfApp(driver);
	driver.quit();
	}
	//Step 9: quit browser
	
	
	@DataProvider(name="IndustryName")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleDataIntoDataProvider("MultipleOrganization");
		
	}
}
