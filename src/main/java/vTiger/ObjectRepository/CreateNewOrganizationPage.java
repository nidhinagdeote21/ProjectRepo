package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(css = "input.crmbutton.small.save")
	private WebElement saveBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAccountNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Logic
	/**
	 * This method creates organization with mandatory fields
	 * @param OrgName
	 */
	public void createNewOrganization(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	/**
	 * This method creates organization with industry type
	 * @param OrgName
	 * @param IndustryType
	 */
	public void createNewOrganization(String OrgName, String IndustryType)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(industryDropDown, IndustryType);
		saveBtn.click();
	}
	
}
