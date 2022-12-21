package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
@FindBy(xpath="//span[@class='lvtHeaderText']")
public WebElement ProductHeader;

public ProductInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getProductHeader()
{
	return ProductHeader;
}

//Business Logic
/**
 * This method returns the Header of Product Info Page
 * @return
 */
public String getProductHeaderText()
{
	return ProductHeader.getText();
}
}
