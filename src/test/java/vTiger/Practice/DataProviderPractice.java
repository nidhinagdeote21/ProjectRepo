package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test (dataProvider = "getData")
	public void dataProviderPractice(String name, String modelNum, int price, int Qty)
	{
		System.out.println(name+" "+modelNum+" "+price+" "+Qty);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][4];
		
		data[0][0]="Samsung";
		data[0][1]="A80";
		data[0][2]=43000;
		data[0][3]=13;
		
		data[1][0]="Apple";
		data[1][1]="13 Pro Max";
		data[1][2]=70000;
		data[1][3]=78;
		
		data[2][0]="Nokia";
		data[2][1]="1100";
		data[2][2]=21000;
		data[2][3]=20;
		
		return data;
		
	}
}
