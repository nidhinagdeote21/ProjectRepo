package vTiger.OrganizationsTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateOrganizationWithIndustryUsingDDT {

	
		public static void main(String[] args) throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			//select the property file
			
			PropertyFileUtility pUtil=new PropertyFileUtility();
			JavaUtility jUtil=new JavaUtility();
			ExcelFileUtility eUtil=new ExcelFileUtility();
			WebDriverUtility wUtil=new WebDriverUtility();
			
			/*FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pp = new Properties();
			pp.load(fis);*/
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String URL = pUtil.readDataFromPropertyFile("url");
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");
			
			//select the xlsx file
			
			/*FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis2);
			Sheet s = wb.getSheet("Organizations");
			Row r = s.getRow(4);
			Cell c = r.getCell(2);
			Cell c2 = r.getCell(3);*/
			String value1 = eUtil.ReadDataFromExcelSheet("Organizations", 4, 2);
			String value2 = eUtil.ReadDataFromExcelSheet("Organizations", 4, 3);
			
			//System.out.println(value);
			
			//invoking browser
			WebDriver driver=null;
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
				
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else
			{
				System.out.println("Invalid Browser");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(value1);
			WebElement ele = driver.findElement(By.name("industry"));
			Select ss=new Select(ele);
			ss.selectByValue(value2);
			driver.findElement(By.cssSelector("input.crmbutton.small.save")).click();
			//Thread.sleep(3000);
			driver.close();
			
	}

}
