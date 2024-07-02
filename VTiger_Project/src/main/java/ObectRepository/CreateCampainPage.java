package ObectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampainPage
{
	//Initialization
	public CreateCampainPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(css = "[alt=\"Create Campaign...\"]")
	private WebElement createCampaignPlusSign;
	
	@FindBy(name = "campaignname")
	private WebElement campaignName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveButton;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement windowSwitchProduct;

	//getter methods
	public WebElement getCreateCampaignPlusSign() {
		return createCampaignPlusSign;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getSaveButton() 
	{
		return saveButton;
	}
	
	
	public WebElement getWindowSwitchProduct() {
		return windowSwitchProduct;
	}

	//Business Logic
	/**
	 * This method will save given campaign
	 * @param campName
	 */
	public void addCampaign(String campName)
	{
		campaignName.sendKeys(campName);
		saveButton.click();
	}
	public void clickSaveButton()
	{
		saveButton.click();
	
	}
	/**
	 * This method will navigate to create campaign page
	 */
	public void clickCreatecamp()
	{
		createCampaignPlusSign.click();
	}
	
	/**
	 * This method will switch thw window to product page
	 */
	public void clickWindowSwitchProduct()
	{
		windowSwitchProduct.click();
	}
	/**
	 * Enter campaign name
	 * @param campName
	 */
	public void setCampaignName(String campName)
	{
		campaignName.sendKeys(campName);
	}

}
