package TestNG;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;

public class DataProviderEample4
{

	@Test(dataProvider ="getData" )
	public void data(String orgName,String phNo,String email) throws IOException, Throwable
	{
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
	    driver.findElement(By.id("submitButton")).click();
	    driver.findElement(By.linkText("Organizations")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(orgName);
	    driver.findElement(By.id("phone")).sendKeys(phNo);
	    driver.findElement(By.id("email1")).sendKeys(email);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    Thread.sleep(1000);
	    driver.quit();
		
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		
		Excel_Utility eUtil = new Excel_Utility();
		Object[][] values = eUtil.readDataUsingDataProvider("DataProvider");
				
		return values;
	}
}
