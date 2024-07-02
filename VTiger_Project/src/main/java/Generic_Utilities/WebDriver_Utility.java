package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {

	/**
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @param driver
	 */
	public void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForPage(WebDriver driver , String partailPageURL) {
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.urlContains(partailPageURL));
	}
	
	/**
	 * Switch the window from parent
	 * @param driver
	 * @param testData
	 */
	public void switchWindow(WebDriver driver,String testData)
	{
		Set<String> winds = driver.getWindowHandles();
		Iterator<String> it = winds.iterator();
		while(it.hasNext())
		{
			String win = it.next();
		   driver.switchTo().window(win);
			 
			if(driver.getCurrentUrl().contains(testData))
			{		 
				//driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
				break;
			}
		}
	}
	
	/**
	 * accept alert message
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * calcel the alert
	 * @param driver
	 */
	public void alertDissmiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	

	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver , String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	
	/**
	 * 	 used to right click  on specified element

	 * @param driver
	 * @param elemnet
	 */
	
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver , String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	
	  	   
   /**
	     * pass enter Key appertain in to Browser
	     * @param driver
	     */
	   public void passEnterKey(WebDriver driver) {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   } 


/**
	 * This method is used to move the cursor to a particular element
	 * @param driver
	 * @param ele
	 */
	public void moveToElement(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	/**
	 * This method will takescreenshot in specified file name
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException 
	 */
	public static String takeScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot sshot =(TakesScreenshot)driver;
		File src = sshot.getScreenshotAs(OutputType.FILE);
		File tgt = new File("./ScreenShots/"+screenshotName+".png");
		FileUtils.copyFile(src, tgt);
		
		return tgt.getAbsolutePath();
		
	}
	
}
