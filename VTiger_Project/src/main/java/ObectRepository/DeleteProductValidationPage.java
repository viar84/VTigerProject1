package ObectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductValidationPage 
{
	//Initialization
	public DeleteProductValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;

	//Getters
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	//Business Logic
	/**
	 * This method will click delete product button
	 */
	public void clickDeleteButton()
	{
		deleteButton.click();
	}
	
	/**
	 * This method will check the checkbox of product to be deleted
	 * @param driver
	 * @param prodName
	 */
	public void selectProductTobeDeleted(WebDriver driver,String prodName)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prodName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}
	
	/**
	 * This method will check whether the selected product is deleted or not
	 * @param driver
	 * @param prodName
	 */
	public void validateProductDeleted(WebDriver driver,String prodName)
	{
		 List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		 
			boolean flag = false;
			for (WebElement product : productList)
			{
				String actData = product.getText();
				
				if(actData.contains(prodName))
				{
					flag= true;
					break;
				}
				 
			}
			
			if(flag)
			{
				System.out.println("Product is  deleted");
			}
			else
				System.out.println("Product is not deleted");
			
	}

}
