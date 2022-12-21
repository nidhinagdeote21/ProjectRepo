package vTiger.VendorTests;

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
import org.openqa.selenium.interactions.Actions;

public class CreateVendor {

		public static void main(String[] args) throws IOException {
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties p = new Properties();
			p.load(fis);
			String BROWSER = p.getProperty("browser");
			String URL = p.getProperty("url");
			String USERNAME = p.getProperty("username");
			String PASSWORD = p.getProperty("password");
			
			FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis2);
			Sheet sh = wb.getSheet("Vendors");
			Row r = sh.getRow(1);
			Cell c = r.getCell(2);
			String value = c.getStringCellValue();
			
			
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
			driver.manage().window().maximize();
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			WebElement ele = driver.findElement(By.xpath("//a[text()='More']"));
			Actions a=new Actions(driver);
			a.moveToElement(ele).perform();
			driver.findElement(By.xpath("//a[text()='Vendors']")).click();
			driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
			driver.findElement(By.name("vendorname")).sendKeys(value);
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			
	}

}
