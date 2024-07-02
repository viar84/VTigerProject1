package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;;

public class FetchingDataFromExcelUsingDataFormatter {

	public static void main(String[] args)  throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
  FileInputStream fis = new FileInputStream("./src\\test\\resources\\Exceldata.xlsx");
		
		//open workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//create sheet
		Sheet sheet = wb.getSheet("Sheet1");
		Row rr = sheet.getRow(0);//get row
		Cell cel = rr.getCell(0);//get coloumn
		//System.out.println(cel.getStringCellValue());-- This will give error if cell value is number
		
		
		//This class is used to avoid exception while reading numeric values or others---convert it inbuuild
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(cel);
		System.out.println(data); 

	}

}
