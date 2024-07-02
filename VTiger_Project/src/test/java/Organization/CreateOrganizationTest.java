package Organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObectRepository.CreateOrganizationPage;
import ObectRepository.CreateProductPage;
import ObectRepository.HomePage;
import ObectRepository.VTigerLoginPage;

public class CreateOrganizationTest extends BaseClass
{
	//WebDriver driver = null;	
	@Test(groups = "smokeTest")
	public   void CreateOrganizationTest() throws Throwable
	{
		
		int ranNum = javaUtil.getRandomNumber();
		String orgName= elib.getDataFromExcelUsingDataFormatter("Organization", 0, 0) +ranNum;
		String phone =elib.getDataFromExcelUsingDataFormatter("Organization", 1, 0);
		String email =elib.getDataFromExcelUsingDataFormatter("Organization", 2, 0);
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOrganizationLink();
	
		CreateOrganizationPage orgCreate = new CreateOrganizationPage(driver);
		orgCreate.clickOrgPlusSign();
		orgCreate.orgData(orgName, phone, email);
		
		orgCreate.clickOnSaveButton();
		Thread.sleep(2000);
	   
	}
	
/*	
	@Test
	public   void CreateProductTest() throws InterruptedException, IOException
	{
	 
		int ranNum = javaUtil.getRandomNumber();
		String prodName= elib.getDataFromExcelUsingDataFormatter("Product", 0, 0) +ranNum;
		HomePage homePage = new HomePage(driver);
		homePage.clickProductsLink();
		Thread.sleep(2000);
		CreateProductPage createProd = new CreateProductPage(driver);
		createProd.clickCreateProductSign();
		createProd.addProduct(prodName);	 
		Thread.sleep(2000);
  
	}*/

}
