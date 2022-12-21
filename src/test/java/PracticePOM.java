import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.Logout;

public class PracticePOM {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToWebPage("admin", "admin");
		
		Logout log=new Logout(driver);
		log.LogoutFromApp(driver);
				
	//	Actions act=new Actions(driver);
		//act.moveToElement(AdministratorLnk).perform();
	}

}
