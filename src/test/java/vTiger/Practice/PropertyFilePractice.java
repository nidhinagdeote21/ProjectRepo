package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties p= new Properties();
		p.load(fis);
		 String val = p.getProperty("browser");
		 System.out.println(val);
	}

}
