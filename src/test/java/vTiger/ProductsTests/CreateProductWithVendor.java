package vTiger.ProductsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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

public class CreateProductWithVendor {

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
	Sheet sh = wb.getSheet("Products");
	Row r = sh.getRow(1);
	Cell c = r.getCell(2);
	String value1 = c.getStringCellValue();
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
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	driver.findElement(By.name("productname")).sendKeys(value1);
	WebElement ele = driver.findElement(By.xpath("//img[@title='Select']"));
	ele.click();
	Set<String> handles = driver.getWindowHandles();
	Iterator<String> it = handles.iterator();
	String windowadd1 = it.next();
	String windowadd2 = it.next();
	driver.switchTo().window(windowadd2);
	driver.findElement(By.name("search_text")).sendKeys(value1);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='Sahil D']")).click();
	driver.switchTo().window(windowadd1);
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	
	
	}

}
