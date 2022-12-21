package vTiger.OrganizationsTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
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

public class CreateOrganizationWithIndustryAndType2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pp = new Properties();
		pp.load(fis);
		String BROWSER = pp.getProperty("browser");
		String URL = pp.getProperty("url");
		String USERNAME = pp.getProperty("username");
		String PASSWORD = pp.getProperty("password");
		
		//select the xlsx file
		
		FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet s = wb.getSheet("Organizations");
		Row r = s.getRow(10);
		Cell c1 = r.getCell(2);
		String val1 = c1.getStringCellValue();
		
		Cell c2 = r.getCell(3);
		String val2 = c2.getStringCellValue();
		
		Cell c3 = r.getCell(4);
		String val3 = c3
				.getStringCellValue();
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
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
		driver.findElement(By.name("accountname")).sendKeys(val1);
		WebElement ele = driver.findElement(By.name("industry"));
		
		Select ss=new Select(ele);
		
		ss.selectByValue(val2);
		WebElement ele2 = driver.findElement(By.name("accounttype"));
		
		Select ss2=new Select(ele2);
		ss2.selectByValue(val3);
		driver.findElement(By.cssSelector("input.crmbutton.small.save")).click();
	}

}
