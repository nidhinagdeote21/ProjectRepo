package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateContactImg()
	{
		return contactHeader;
	}
	
	//Business Logic
	/**
	 * This method clicks on the create contact Lookup image
	 * @return 
	 * @return
	 */
	public String getContactHeaderText()
	{
		return contactHeader.getText();
	}
	
	
}
