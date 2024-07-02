package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getDataFromExcel(String sheetName,int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream("D:\\viji\\AdvancedSelenium\\DataFiles\\ExcelInputData.xlsx");
	Workbook wbook = WorkbookFactory.create(fis);
	Sheet sheet = wbook.getSheet(sheetName);
	String value = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	return value;
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcelUsingDataFormatter(String sheetName,int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream("D:\\viji\\AdvancedSelenium\\DataFiles\\ExcelInputData.xlsx");
	Workbook wbook = WorkbookFactory.create(fis);
	Sheet sheet = wbook.getSheet(sheetName);

	DataFormatter format = new DataFormatter();
	String value = format.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
	return value;
	}
	
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @param Data
	 * @throws Throwable
	 */
	public void insertDataToExcel(String sheetName,int rowNum,int colNum,String Data) throws Throwable
	{
		FileInputStream fis =  new FileInputStream("./src\\test\\resources\\Exceldata.xlsx");
		
		Workbook wbook = WorkbookFactory.create(fis);
		
		Sheet sht = wbook.getSheet(sheetName);
		Row row = sht.createRow(rowNum);
		Cell col = row.createCell(colNum);
		col.setCellValue(Data);
		 FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\Exceldata.xlsx");
		 wbook.write(fos);
		 wbook.close();
	
	}
	/**
	 * This method is for dataprovider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] readDataUsingDataProvider(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("D:\\viji\\AdvancedSelenium\\DataFiles\\ExcelInputData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rowNo = sheet.getLastRowNum()+1;
		int cellNo = sheet.getRow(0).getLastCellNum();
		 
		Object objArr[][]  = new Object[rowNo][cellNo];
		for (int i = 0; i < rowNo; i++) 
		{
			for (int j = 0; j < cellNo; j++) 
			{
				objArr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
			
		}
		return objArr;
	
	}
	
}
