package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleDataFromXLS {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("D:\\viji\\NewFolder\\ExcelTestData.xlsx");
		
		//open workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//create sheet
		Sheet sheet = wb.getSheet("Sheet1");
		
		int rownum = sheet.getLastRowNum();
		System.out.println(rownum);
		
		for (int i = 0; i < rownum; i++) 
		{
			Row row = sheet.getRow(rownum);
			
			for (int j = 0; j < row.getLastCellNum(); j++) 
			{
				Cell cell = row.getCell(j);
				
				//String link = cell.getStringCellValue();
				DataFormatter formatter = new DataFormatter();///formate the whatever data(number,string,specialcharacter) in cell
				
				String link = formatter.formatCellValue(cell);
				
				System.out.println(link);
			}
			
		}
		 
	}

}
