package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement organizationImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(css = "input.crmButton.small.save")
	private WebElement saveBtn;

	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrganizationImg() {
		return organizationImg;
	}

	public WebElement getSeachEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Logic
	/**
	 * This method creates a contact with mandatory fields
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	public void createNewContact(String lastname, String OrgName, WebDriver driver)
	{
		lastNameEdt.sendKeys(lastname);
		organizationImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	
}
