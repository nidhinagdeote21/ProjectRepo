package vTiger.Practice;

import org.testng.annotations.Test;

public class PracticeData {

	
	@Test
	public void readData()
	{
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("Username");
		
		
		System.out.println(BROWSER);
		System.out.println(USERNAME);
	}
}
