package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility {
@FindBy(name="productname")
public WebElement ProductNameEdt;

public CreateNewProductPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//img[@alt='Select']")
public WebElement VendorNameBtn;

@FindBy(id="search_txt")
public WebElement SearchTextEdt;

@FindBy (name="search")
public WebElement SearchNowBtn;

@FindBy (xpath="//input[@type='submit']")
public WebElement SaveBtn;

public WebElement getProductNameEdt() {
	return ProductNameEdt;
}

public WebElement getVendorNameBtn() {
	return VendorNameBtn;
}

public WebElement getSearchTextEdt() {
	return SearchTextEdt;
}

public WebElement getSearchNowBtn() {
	return SearchNowBtn;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}

//Business Logic
/**
 * This method let you create a product with Product name and vendor
 * @param productName
 * @param vendor
 * @param driver
 */
public void createNewProduct(String productName, String vendor, WebDriver driver)
{
	ProductNameEdt.sendKeys(productName);
	VendorNameBtn.click();
	switchToWindow(driver, "Vendors");
	SearchTextEdt.sendKeys(vendor);
	SearchNowBtn.click();
	driver.findElement(By.xpath("//a[text()='"+vendor+"']"));
	switchToWindow(driver, "Products");
	SaveBtn.click();
	
}
}
