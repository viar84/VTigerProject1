package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelToMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	
	{
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("D:\\viji\\NewFolder\\ExcelTestData.xlsx");
		
		//open workbook
		Workbook wbook = WorkbookFactory.create(fis);
		
		//create sheet
		Sheet sheet = wbook.getSheet("Sheet2");
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		int rNum = sheet.getLastRowNum();
		for (int i = 0; i < rNum; i++)
		{
			String key = sheet.getRow(i).getCell(0).toString();
			String value = sheet.getRow(i).getCell(1).toString();
			map.put(key, value);
		}
		
		for ( Entry<String, String> m:map.entrySet())
		{
			System.out.println(m.getKey()+"--"+m.getValue());
		}
		

	}

}
