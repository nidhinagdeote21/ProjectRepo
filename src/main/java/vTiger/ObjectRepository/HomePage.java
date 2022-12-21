package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
@FindBy(linkText="Calendar")
private WebElement CalenderLnk;

@FindBy(linkText="Leads")
private WebElement LeadsLnk;

@FindBy(linkText="Organizations")
private WebElement OrganizationsLnk;

@FindBy(linkText = "Contacts")
private WebElement ContactsLnk;

@FindBy(linkText = "Opportunities")
private WebElement OpportunitiesLnk;

@FindBy(linkText = "Products")
private WebElement ProductsLnk;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement AdministratorImg;

@FindBy(linkText = "Sign Out")
private WebElement SignOutLnk;


public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


public WebElement getCalenderLnk() {
	return CalenderLnk;
}

public WebElement getLeadsLnk() {
	return LeadsLnk;
}

public WebElement getOrganizationsLnk() {
	return OrganizationsLnk;
}

public WebElement getContactsLnk() {
	return ContactsLnk;
}

public WebElement getOpportunitiesLnk() {
	return OpportunitiesLnk;
}

public WebElement getProductsLnk() {
	return ProductsLnk;
}

public WebElement getAdministratorImg() {
	return AdministratorImg;
}

public WebElement getSignOutLnk() {
	return SignOutLnk;
}

//Business Library
/**
 *  This method will click on the calender Link in home page 
 */
public void clickOnCalenderLink()
{
	CalenderLnk.click();
}
/**
 *  This method will click on the leads Link in home page 
 */
public void clickOnLeadsLink()
{
	LeadsLnk.click();
}
/**
 *  This method will click on the organisations Link in home page 
 */
public void clickOnOrganizationLink()
{
	OrganizationsLnk.click();
}
/**
 *  This method will click on the contacts Link in home page 
 */
public void clickOnContactsLink()
{
	ContactsLnk.click();
}
/**
 * This method will click on the opportunities Link in home page 
 */ 
public void clickOnOpportunitiesLink()
{
	OpportunitiesLnk.click();
}
/**
 * This method will click on the products Link in home page
 */
public void clickOnProductsLink()
{
	ProductsLnk.click();
}
/**
 * This method will sign out from the app
 * @param driver
 */
public void logoutOfApp(WebDriver driver)
{
	mouseHoverAction(driver, AdministratorImg);
	SignOutLnk.click();
}
}


