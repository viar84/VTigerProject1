package ObectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{
	//Initialization
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(css = "[alt='Create Product...']")
	private WebElement createProductPlusSign;
	
	@FindBy(name = "productname")
	private WebElement productNameText;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveButton;

	//Getter Methods
	public WebElement getCreateProductPlusSign() {
		return createProductPlusSign;
	}

	public WebElement getProductNameText() {
		return productNameText;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	//Business Logic
	/**
	 * This method will navigate to create product page
	 */
	public void clickCreateProductSign()
	{
		createProductPlusSign.click();
	}
	  
	/**
	 * This method will add product and save
	 * @param prodName
	 */
	public void addProduct(String prodName)
	{
		productNameText.sendKeys(prodName);
		saveButton.click();
	}
	
}
