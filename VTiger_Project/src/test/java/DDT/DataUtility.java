package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {

	 public String getDataFromProperties(String key) throws IOException 
	 {
		 FileInputStream fis = new FileInputStream("D:\\viji\\AdvancedSelenium\\DataFiles\\CommonData.properties");
		 Properties prop = new Properties();
		 prop.load(fis);
		 
		 String value = prop.getProperty(key);
		 return value;
	 }
	 
	 public String getDataFromExcel(String sheetName,int rowNo,int colNo) throws EncryptedDocumentException, IOException
	 {
		 String value;
		 FileInputStream fis = new FileInputStream("D:\\viji\\AdvancedSelenium\\DataFiles\\InsertintoDatabase.xlsx");
		 Workbook wbook=WorkbookFactory.create(fis);
		 Sheet sheet = wbook.getSheet(sheetName);
		 value = sheet.getRow(rowNo).getCell(colNo).toString();
		 return value;
	 }

}
