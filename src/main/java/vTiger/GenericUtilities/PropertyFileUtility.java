package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods related to property file.
 * @author nidhi
 *
 */
public class PropertyFileUtility {
	/**
	 * This generic method will read the data from the property file and return the value
	 * @param key
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readDataFromPropertyFile(String key) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
}
}
