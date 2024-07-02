package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcelUsingMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("D:\\viji\\NewFolder\\ExcelTestData.xlsx");
		
		//open workbook
		Workbook wbook = WorkbookFactory.create(fis);
		
		//create sheet
		Sheet sheet = wbook.getSheet("Sheet2");
		
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		
		map.put("10", "TN");
		map.put("20", "UP");
		map.put("30", "KL");
		map.put("40", "AP");
		map.put("50", "BL");
		
		int rNum = 0;
		
		for (Entry<String, String> val : map.entrySet())
		{
			Row row = sheet.createRow(rNum++);
			row.createCell(0).setCellValue((String)val.getKey());
			row.createCell(1).setCellValue((String)val.getValue());
		}
		
		FileOutputStream fos = new FileOutputStream("D:\\viji\\NewFolder\\ExcelTestData.xlsx");
		wbook.write(fos);
		wbook.close();
		
		
		//If one parameter is integer
     /*LinkedHashMap<String,String> map = new LinkedHashMap<Integer,String>();
		
		map.put("10", "TN");
		map.put("20", "UP");
		map.put("30", "KL");
		map.put("40", "AP");
		map.put("50", "BL");
		
		int rNum = 0;
		
		for (Entry<String, String> val : map.entrySet())
		{
			Row row = sheet.createRow(rNum++);
			row.createCell(0).setCellValue((Integer)val.getKey());
			row.createCell(1).setCellValue((String)val.getValue());
		}
		*/
		
	}

}
