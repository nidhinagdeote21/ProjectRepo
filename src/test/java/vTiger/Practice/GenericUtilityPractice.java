package vTiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("username");
		System.out.println(value);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value2 = eUtil.ReadDataFromExcelSheet("Organizations", 4, 1);
		System.out.println(value2);
		int count = eUtil.getRowCount("Organizations");
		System.out.println(count);
		int count2 = eUtil.getRowCount("Contacts");
		System.out.println(count2);
		
		eUtil.writeDataIntoExcel("Organizations", 1, 8, "Nidhizzzzz");
		System.out.println("added to excelsheet");
		
		JavaUtility jUtil=new JavaUtility();
		int num=jUtil.getRandomNumber();
		System.out.println(num);
		
		String date = jUtil.getSystemDate();
		System.out.println(date);
		
		String date2 = jUtil.getSystemDateInFormat();
		System.out.println(date2);
	}

}
