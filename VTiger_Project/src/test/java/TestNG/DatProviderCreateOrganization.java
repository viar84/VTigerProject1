package TestNG;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DDT.DataUtility;

public class DatProviderCreateOrganization
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
	public Object[][] getData()
	{
		
		Object[][] obj = new Object[3][3];
		Random ran = new Random();
		int ranNo = ran.nextInt(1000);
		obj[0][0] = "AAA"+ranNo;
		obj[0][1] = "425632156";
		obj[0][2] = "aa@gmail.com";
		
		obj[1][0] = "BBB"+ranNo;
		obj[1][1] = "425632156";
		obj[1][2] = "bb@gmail.com";
		
		obj[2][0] = "CCC"+ranNo;
		obj[2][1] = "425632156";
		obj[2][2] = "CC@gmail.com";
		return obj;
		
	}
}
