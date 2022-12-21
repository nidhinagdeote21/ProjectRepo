package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1:
public class LoginPage {
	//Rule 2: - Declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	
	//Rule 3: - Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Rule 4: - Utilization
	
	public WebElement getusernameEdt()
	{
		return usernameEdt;
	}
	public WebElement getpasswordEdt()
	{
		return passwordEdt;
	}
	public WebElement getLoginBtn()
	{
		return LoginBtn;
	}
	//Rule 5: - Business libraries
	/**
	 * This business library will perform login action
	 * @param username
	 * @param password
	 */
	public void LoginToWebPage(String username, String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		LoginBtn.click();
	}
}
