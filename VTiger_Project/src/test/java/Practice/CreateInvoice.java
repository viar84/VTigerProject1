package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateInvoice {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		

		WebDriver_Utility wLib = new WebDriver_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility javaUtil = new Java_Utility();
	    File_Utility fLib = new File_Utility();
		
	    WebDriver driver = null;
	    String Browser = fLib.getKeyAndValueData("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
			driver = new ChromeDriver();
		
		wLib.maximizeWindow(driver);
		wLib.waitForElementToLoad(driver);
		
		String URL = fLib.getKeyAndValueData("url");
		String userNam = fLib.getKeyAndValueData("username");
		String password = fLib.getKeyAndValueData("password");
		driver.get(URL);
		String parent = driver.getWindowHandle();
		//login
		driver.findElement(By.name("user_name")).sendKeys(userNam);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		int ranNum = javaUtil.getRandomNumber();
		String CGName= elib.getDataFromExcelUsingDataFormatter("Campaign", 0, 0) +ranNum;
		String inVoiceSubject = elib.getDataFromExcelUsingDataFormatter("Invoice", 0, 0)+ranNum;
		
		WebElement  element = driver.findElement(By.linkText("More")) ;
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
		Thread.sleep(2000);
		driver.findElement(By.name("Invoice")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Invoice...\"]")).click();
		driver.findElement(By.cssSelector("alt=''")).click();
		driver.findElement(By.cssSelector("[name=\"subject\"]")).sendKeys(inVoiceSubject);
		
	}

}
