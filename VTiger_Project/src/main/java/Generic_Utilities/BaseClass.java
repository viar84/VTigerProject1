package Generic_Utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import ObectRepository.HomePage;
import ObectRepository.VTigerLoginPage;

public class BaseClass 
{
	public static  WebDriver sDriver;
	public WebDriver driver ;
	public WebDriver_Utility wLib = new WebDriver_Utility();
	public Excel_Utility elib = new Excel_Utility();
	public Java_Utility javaUtil = new Java_Utility();
    public File_Utility fLib = new File_Utility();
    public DataBase_Utility dLib= new DataBase_Utility();
    
	@BeforeSuite(groups = { "smokeTest","regressionTest"})
	public void beforeSuite() throws SQLException
	{
		dLib.databaseconnection();
		System.out.println("connection established with server");
	}
	
	@BeforeTest(groups = { "smokeTest","regressionTest"})
	public void beforeTest()
	{
		System.out.println("connection established with db");
	}
	
	/*@Parameters("BROWSER") --- Cross Browser
	@BeforeClass(groups = { "smokeTest","regressionTest"})
	public void beforeClass(String Browser) throws IOException
	{
	 
		//String Browser = fLib.getKeyAndValueData("browser");
		 
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
			driver = new ChromeDriver();
		 
		System.out.println("Browser launghed");
	}*/
	
	 
	@BeforeClass(groups = { "smokeTest","regressionTest"})
	public void beforeClass( ) throws IOException
	{
	 
		String Browser = fLib.getKeyAndValueData("browser");
		//String Browser = System.getProperty("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
			driver = new ChromeDriver();
		sDriver = driver;
		System.out.println("Browser launghed");
		 
	}
	
	
	@BeforeMethod(groups = { "smokeTest","regressionTest"})
	public void beforeMethod() throws Throwable
	{
		 
		 
		wLib.maximizeWindow(driver);
		wLib.waitForElementToLoad(driver);
		
		String userNam = fLib.getKeyAndValueData("username");
		String password = fLib.getKeyAndValueData("password");
		String URL = fLib.getKeyAndValueData("url");
		driver.get(URL);
		
		//login
		 VTigerLoginPage loginPage = new VTigerLoginPage(driver);
		 loginPage.logInToApp(userNam, password);
		System.out.println("logged in");
	}
	
	@AfterMethod(groups = { "smokeTest","regressionTest"})
	public void afterMethod()
	{
		HomePage homePage = new HomePage(driver);
		 homePage.logOut(driver);
		System.out.println("logged out");
	}
	
	@AfterClass(groups = { "smokeTest","regressionTest"})
	public void afterClass()
	{
		driver.quit();
		System.out.println("browser closed");
	}
	
	@AfterTest(groups = { "smokeTest","regressionTest"})
	public void afterTest() throws SQLException
	{
		dLib.databaseClose();
		System.out.println("disconnected with db");
	}
	
	@AfterSuite(groups = { "smokeTest","regressionTest"})
	public void afterSuite()
	{
		System.out.println("disconnected with server");
	}
	
}
