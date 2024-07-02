package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class INsertingDataintoPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Writing Data
		Properties pro = new Properties();
		pro.setProperty("url","https://www.saucedemo.com/v1/ ");
		pro.setProperty("username","standard_user");
		pro.setProperty("password","secret_sauce");
		
		FileOutputStream fos = new FileOutputStream("./src\\test\\resources\\CommonData.Properties");
		pro.store(fos, "CommonData");
		System.out.println("Data written Successfully");
		
		//Fetching Data
		
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
