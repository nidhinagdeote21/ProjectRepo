package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods related to Excel Sheet 
 * @author nidhi
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will take the value from excel sheet for respective sheet name, row number and cell number
	 * @param SheetName
	 * @param RowNum
	 * @param CellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String ReadDataFromExcelSheet(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	 Row r = sh.getRow(RowNum);
	  Cell c = r.getCell(CellNum);
	  String value = c.getStringCellValue();
	  wb.close();
	  return value;
	}
/**
 * This method will give the total row count in the sheet
 * @param SheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	int rowCount = sh.getLastRowNum();
	return rowCount;
}
/**
 * This method will write data into the excel sheet
 * @param SheetName
 * @param RowNum
 * @param CellNum
 * @param data
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void writeDataIntoExcel(String SheetName, int RowNum, int CellNum, String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	Row r = sh.getRow(RowNum);
	Cell cn = r.createCell(CellNum);
	cn.setCellValue(data);
	
	FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFilePath);
	wb.write(fos);
	wb.close();	
}
/**
 * This method will read the multiple data from excel file to the data provider 
 * @param SheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public Object[][] readMultipleDataIntoDataProvider(String SheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	int LastRow=sh.getLastRowNum();
	int LastCell = sh.getRow(LastRow).getLastCellNum();
	Object[][] data= new Object[LastRow][LastCell];
	for(int i=0;i<LastRow;i++)
	{
		for(int j=0;j<LastCell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
}
}
