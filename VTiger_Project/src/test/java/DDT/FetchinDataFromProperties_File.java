package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchinDataFromProperties_File {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		/*driver.get("https://www.saucedemo.com/v1/ ");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");	
		driver.findElement(By.id("login-button")).click();*/
		
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\CommonData.Properties");
		Properties fload = new Properties();
		fload.load(fis);
		
		String url = fload.getProperty("url");
		driver.get(url);
		String uname = fload.getProperty("username");
		String password = fload.getProperty("password");
		driver.findElement(By.id("user-name")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(password);	
		
		}

}
