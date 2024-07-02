package Campaign;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObectRepository.CreateCampainPage;
import ObectRepository.HomePage;
import ObectRepository.VTigerLoginPage;
import ObectRepository.ValidationAndVerification;

@Listeners(Generic_Utilities.ExtentReportImplementation.class)
public class CreateCampaignsTest extends BaseClass 
{

	@Test(groups = { "smokeTest","regressionTest"})
	//@Test(retryAnalyzer  =Generic_Utilities.RetryImplementation.class)
	public void CreateCampaignsTest() throws Throwable
	{

		int ranNum = javaUtil.getRandomNumber();
		String CGName= elib.getDataFromExcelUsingDataFormatter("Campaign", 0, 0) +ranNum;
		//Assert.fail();
		HomePage homePage = new HomePage(driver);
		homePage.clickMoreLink();
		homePage.clickCampaignLink();
		 
		CreateCampainPage campPage = new CreateCampainPage(driver);
		campPage.clickCreatecamp();
		campPage.addCampaign(CGName);
		Thread.sleep(2000);
		
		//ValidationAndVerification vlidation = new ValidationAndVerification(driver);
		//vlidation.validateCampaignName(driver, CGName);
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		//Assert.assertEquals(actData, CGName);
		//Assert.assertTrue(actData.contains(CGName));
		//Assert.assertTrue(actData.contains(CGName),CGName +" Campaign name is not verified");
		/*SoftAssert soft = new SoftAssert();
		soft.assertEquals(actData, CGName);
		soft.assertAll();*/
	}

}
