package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritingMultipleDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		// TODO Auto-generated method stub
		//Read mode
		FileInputStream fis = new FileInputStream("D:\\viji\\NewFolder\\ExcelTestData.xlsx");
		Workbook wbook = WorkbookFactory.create(fis);
		Sheet sheet = wbook.getSheet("Sheet1");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
		
		List<WebElement> elements = driver.findElements(By.xpath("//a"));
		
		for(int i=0;i<elements.size();i++)
		{
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(elements.get(i).getAttribute("href"));
		}
		
		//Write mode
		FileOutputStream fos = new FileOutputStream("D:\\viji\\NewFolder\\ExcelTestData.xlsx");
		wbook.write(fos);
		wbook.close();
		

	}

}
