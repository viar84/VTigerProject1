package Campaign;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

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
import ObectRepository.CreateCampainPage;
import ObectRepository.CreateProductPage;
import ObectRepository.HomePage;
import ObectRepository.VTigerLoginPage;
import ObectRepository.ValidationAndVerification;
import ObectRepository.WindowSwitchingToProductPage;

public class CreateCampaignWithProductTest extends BaseClass {

	@Test(groups = "smokeTest")
	public   void CreateCampaignWithProductTest() throws InterruptedException, IOException 
	{

		String parent = driver.getWindowHandle();
		int ranNum = javaUtil.getRandomNumber();
		String CGName= elib.getDataFromExcelUsingDataFormatter("Campaign", 0, 0) +ranNum;
		String prodName = elib.getDataFromExcelUsingDataFormatter("Product", 0, 0) +ranNum;
		
		HomePage homePage = new HomePage(driver);
		homePage.clickProductsLink();
		
		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.clickCreateProductSign();
		prodPage.addProduct(prodName);
		homePage.clickMoreLink();
		homePage.clickCampaignLink();
		 
		CreateCampainPage campPage =new CreateCampainPage(driver);
		campPage.clickCreatecamp();
		campPage.setCampaignName(CGName);
		campPage.clickWindowSwitchProduct();
		
		Thread.sleep(2000);
		wLib.switchWindow(driver,"Products&action");
		WindowSwitchingToProductPage prodWindow = new WindowSwitchingToProductPage(driver);
		prodWindow.enterSearchText(prodName);
		prodWindow.clickSearch();
		prodWindow.selectCreatedProduct(driver, prodName);
		
		wLib.switchWindow(driver, "Campaigns&action");
		campPage.clickSaveButton();
		
		ValidationAndVerification vlidation = new ValidationAndVerification(driver);
		vlidation.validateCampaignName(driver, CGName);
		vlidation.validateProductName(driver, prodName);
		 
	}

}
