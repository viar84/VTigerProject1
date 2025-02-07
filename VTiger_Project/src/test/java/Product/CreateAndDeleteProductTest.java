package Product;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import DDT.DataUtility;
import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObectRepository.CreateProductPage;
import ObectRepository.DeleteProductValidationPage;
import ObectRepository.HomePage;
import ObectRepository.VTigerLoginPage;

public class CreateAndDeleteProductTest extends BaseClass {

	@Test
	public   void CreateAndDeleteProductTest() throws IOException, InterruptedException 
	{
		 
		int ranNum = javaUtil.getRandomNumber(); 
		String prodName= elib.getDataFromExcelUsingDataFormatter("Product", 0, 0)+ranNum;
     
		HomePage homePage = new HomePage(driver);
		homePage.clickProductsLink();
		Thread.sleep(2000);
		CreateProductPage createProd = new CreateProductPage(driver);
		createProd.clickCreateProductSign();
		createProd.addProduct(prodName);
		Thread.sleep(2000);
		//delete product
		homePage.clickProductsLink();
		DeleteProductValidationPage deleteProdPage = new DeleteProductValidationPage(driver);
		deleteProdPage.selectProductTobeDeleted(driver, prodName);
		deleteProdPage.clickDeleteButton();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		deleteProdPage.validateProductDeleted(driver, prodName);
		Thread.sleep(2000);
 
	}

}
