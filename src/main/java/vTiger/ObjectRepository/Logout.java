package vTiger.ObjectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1:
public class Logout {
//Rule 2: - Declaration
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement AdministratorLnk;

@FindBy(linkText="Sign Out")
private WebElement SignOutLnk;

//Rule 3: - Initialization
public Logout(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//Rule 4: - Utilization
public WebElement getAdministratorLnk()
{
	return AdministratorLnk;
}
public WebElement getSignOutLink()
{
	return SignOutLnk;
}

//Rule 5: - Business Libraries
public void LogoutFromApp(WebDriver driver)
{
	
	Actions act=new Actions(driver);
	act.moveToElement(AdministratorLnk).perform();
	SignOutLnk.click();
}

}
