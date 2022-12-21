package vTiger.ContactsTests;

import java.io.FileInputStream;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateContactExistingOrganization {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("Organizations");
		Row r = sh.getRow(1);
		Cell c = r.getCell(2);
		String val1 = c.getStringCellValue();

		Sheet sh2 = wb.getSheet("Contacts");
		Row r2 = sh2.getRow(1);
		Cell c2 = r2.getCell(2);
		String value2 = c2.getStringCellValue();

		WebDriver driver = null;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else

		{
			System.out.println("Invalid Browser Option");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		/*
		 * driver.findElement(By.linkText("Organizations")).click();
		 * driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		 * driver.findElement(By.name("accountname")).sendKeys(val1);
		 * driver.findElement(By.cssSelector("input.crmbutton.small.save")).click();
		 */

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(value2);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		String one = it.next();
		String two = it.next();
		driver.switchTo().window(two);
		driver.findElement(By.id("search_txt")).sendKeys(val1);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(val1)).click();
		Thread.sleep(2000);
		driver.switchTo().window(one);
		driver.findElement(By.cssSelector("input.crmButton.small.save")).click();
		driver.quit();
		
	}

}
