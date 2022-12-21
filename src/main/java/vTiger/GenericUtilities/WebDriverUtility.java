package vTiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class contains the Web driver related methods
 * @author nidhi
 *
 */
public class WebDriverUtility {
	/**
	 * This method will maximize the window when it is called
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
/**
 * This method will minimize the window when it is called
 * @param driver
 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for entire page to load for 20 seconds
	 * @param driver
	 */
	public void waitForPageToBeLoaded(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method is used to wait for a element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForelementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This is a custom wait for a second to wait for element to be clickable
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitForSecond(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<5) 
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This method will handle dropdown based on the value
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method will handle dropdown based on visible text
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method will handle the drop down on visible text
	 * @param visibleText
	 * @param element
	 */
	public void handleDropDown(String visibleText, WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform mouse hover action based on Offset.
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element, int x, int y)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element, x, y).perform();
	}
	/**
	 * This method will perform right click randomly on web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will perform right click on particular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform double click randomly on web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform double click on particular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will drag and drop from source element to target element
	 * @param driver
	 * @param srcElement
	 * @param tarElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement tarElement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement, tarElement);
	}
	/**
	 * This method will press and release the enter key
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch to frame based on Name or ID
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * This method will switch to frame based on web element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This will switch to the default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method helps in scrolling to 500 units vertically downward
	 * @param driver
	 */
public void scrollAction(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)", "");
}
/**
 * This method helps in scrolling
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver, WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	int y = element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
}


/**
 * This method helps to take a screenshot and save it in screenshot folder
 * @param driver
 * @param screenShotName 
 * @return
 * @throws IOException
 */
public String taketheScreenshot(WebDriver driver, String screenShotName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	 File src = ts.getScreenshotAs(OutputType.FILE);
	 File dst = new File(".\\Screenshots\\"+screenShotName+".png");
	 Files.copy(src, dst);
	 return dst.getAbsolutePath();	 //used for extent reports
}
/**
 * This method will switch to window based on Partial Window Title Text
 * @param driver
 * @param PartialWinTitle
 */
public void switchToWindow(WebDriver driver, String PartialWinTitle)
{
	Set<String> allWindows = driver.getWindowHandles();
	for(String InWindow:allWindows)
	{
		String CurrentwinTitle = driver.switchTo().window(InWindow).getTitle();
		if(CurrentwinTitle.contains(PartialWinTitle))
		{
			break;
		}
	}
}
}
