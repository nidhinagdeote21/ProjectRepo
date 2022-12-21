package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(".\\data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//Sheet sh = wb.getSheet("sheet1");
		Sheet sh = wb.getSheet("sheet1");
		Row r = sh.createRow(3);
		Cell cn = r.createCell(0);
		cn.setCellValue("Cherry");
		
		FileOutputStream fos = new FileOutputStream(".\\data.xlsx");
		wb.write(fos);
		System.out.println("added data");
		wb.close();

	}

}
