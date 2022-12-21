package vTiger.GenericUtilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass  {
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil= new ExcelFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public JavaUtility jUtil=new JavaUtility();
	public static WebDriver sdriver=null;
	public WebDriver driver=null;
	
@BeforeSuite (groups = {"SmokeSuite","RegressionSuite"})
public void bsConfig()
{
	System.out.println("Database connection successful");
}
//@Parameters("BROWSER")
@BeforeClass (groups = {"SmokeSuite","RegressionSuite"})
public void bcConfig(/*String BROWSER*/) throws IOException
{
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	
	if(BROWSER.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("======== "+BROWSER+"--- launched--- ========");
	}
	else if(BROWSER.equalsIgnoreCase("Firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		System.out.println("======== "+BROWSER+"--- launched--- ========");
	}
	else
	{
		System.out.println("Invalid Browser");
	}
	sdriver=driver;
	driver.get(URL);
	wUtil.maximizeWindow(driver);
	wUtil.waitForPageToBeLoaded(driver);

}
@BeforeMethod (groups = {"SmokeSuite","RegressionSuite"})
public void bmConfig() throws EncryptedDocumentException, IOException
{
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	LoginPage lp=new LoginPage(driver);
	lp.LoginToWebPage(USERNAME, PASSWORD);
	System.out.println("==========Login to App Successful===========");
}

@AfterMethod (groups = {"SmokeSuite","RegressionSuite"})
public void amConfig()
{
	HomePage hp=new HomePage(driver);
	hp.logoutOfApp(driver);
	System.out.println("=======Logout of App Successful========");
}

@AfterClass (groups = {"SmokeSuite","RegressionSuite"})
public void acConfig()
{ 	
	driver.quit();
	System.out.println("=========Browser is closed========");
}

@AfterSuite (groups = {"SmokeSuite","RegressionSuite"})
public void asConfig()
{
	System.out.println("Database disconnected successfully");
}

}
