package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertingSingleDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		 FileInputStream fis = new FileInputStream("./src\\test\\resources\\Exceldata.xlsx");
		 
		 Workbook wb = WorkbookFactory.create(fis);
		 
		 Sheet seet = wb.getSheet("Sheet1");
		 
		 Row rw = seet.createRow(5);
		 
		 Cell cell = rw.createCell(5);
		 cell.setCellValue("Welcome");
		 
		 FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\Exceldata.xlsx");
		 wb.write(fos);
		 wb.close();
	}

}
