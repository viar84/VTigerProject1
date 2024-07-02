package Practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import DDT.DataUtility;

public class CreateContact {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
		DataUtility dataUtil= new DataUtility();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get(dataUtil.getDataFromProperties("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String parent = driver.getWindowHandle();
		//random numer
		Random radm= new Random();
		int rNo = radm.nextInt(1000);
		
		//login
		driver.findElement(By.name("user_name")).sendKeys(dataUtil.getDataFromProperties("username"));
		driver.findElement(By.name("user_password")).sendKeys(dataUtil.getDataFromProperties("password"));
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		String contact = dataUtil.getDataFromExcel("Contact", 0, 0)+rNo;
		String orgName = dataUtil.getDataFromExcel("Organization", 0, 0);
		
		driver.findElement(By.name("lastname")).sendKeys(contact);
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		Set<String> winds = driver.getWindowHandles();
	     Iterator<String> its = winds.iterator();
		while(its.hasNext())
		{
			String win = its.next();
		   driver.switchTo().window(win);
			 
			if(driver.getCurrentUrl().contains("module=Accounts&action=Popup"))
			{		 
				driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
				break;
			}
		}
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
