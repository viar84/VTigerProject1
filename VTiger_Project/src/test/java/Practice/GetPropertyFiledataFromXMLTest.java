package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetPropertyFiledataFromXMLTest
{
	
	@Parameters({"URL","UserName","Password"})
	@Test
	public void  GetPropertyFiledataFromXMLTest(String URL,String UserName,String Password)
	{
		ChromeDriver driver  = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
	}

}
