package ObectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchingToProductPage 
{
	//Initialization
	public WindowSwitchingToProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchTextbox;
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchButton;
	
	//Getter method
	public WebElement getSearchTextbox() {
		return searchTextbox;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	/**
	 * This method will enete the prod name in search textbox
	 * @param prodName
	 */
	public void enterSearchText(String prodName)
	{
		searchTextbox.sendKeys(prodName);
	}
	/**
	 * This method will click search button
	 */
	public void clickSearch()
	{
		searchButton.click();
	}
	
	/**
	 * This method will select the product searched from the result grid
	 * @param driver
	 * @param prodName
	 */
	public void selectCreatedProduct(WebDriver driver,String prodName)
	{
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
		
	}
}
