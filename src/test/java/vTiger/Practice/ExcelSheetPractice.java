package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//load file into fis
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//create a workbook
		Workbook wb= WorkbookFactory.create(fis);
		
		//navigate to required sheet
		Sheet sh = wb.getSheet("Organizations");
		
		//navigate to required row
		Row rw = sh.getRow(7);
		
		//navigate to required cell
		
		 Cell c = rw.getCell(4);
		 
		 //capture the data present in the cell
		 
		String value = c.getStringCellValue();
		System.out.println(value);
		
		String value1 = rw.getCell(2).getStringCellValue();
		System.out.println(value1);
		
		 
		 
		
		
	}

}
