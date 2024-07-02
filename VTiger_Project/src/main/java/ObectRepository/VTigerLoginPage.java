package ObectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VTigerLoginPage
{
	@FindBy(name = "user_name")
	private WebElement userTextField;
	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	public VTigerLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	/**
	 * This method is used to login into application
	 * @param userName
	 * @param password
	 */
	public void logInToApp(String userName,String password)
	{
		userTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}

}
