package ObectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerification
{
	//instantiation
	public ValidationAndVerification(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method ill validate the campaign name entered is valid or not
	 * @param driver
	 * @param actData
	 */
	public void validateCampaignName(WebDriver driver, String actData)
	{
		String inputData = driver.findElement(By.xpath("//input[@name='campaignname']")).getText();
		if(actData.contains(inputData))
		{
			System.out.println("Campaign Data is matching");
		}
		else
			System.out.println("Campaign Data is not matching");
	}
	
	/**
	 * This method will validate the product name entered is valid or not
	 * @param driver
	 * @param actData
	 */
	public void validateProductName(WebDriver driver, String actData)
	{
		String inputData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product\"]")).getText();
		if(actData.contains(inputData))
		{
			System.out.println("product Data is matching");
		}
		else
			System.out.println("Product Data is not matching");
	}

}
