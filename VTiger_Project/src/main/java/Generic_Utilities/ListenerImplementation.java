package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.time.LocalDateTime;


public class ListenerImplementation extends BaseClass implements ITestListener 
{

	@Override
	public void onTestStart(ITestResult result) {
	 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("--------------I am Listening-------------");
		System.out.println("--------------I am Listening-------------");
		 
		TakesScreenshot sShot = (TakesScreenshot)BaseClass.sDriver;
		File src = sShot.getScreenshotAs(OutputType.FILE);
		LocalDateTime dtTime = LocalDateTime.now();
		String currentDtTime = dtTime.toString().replace(":", "_").replace(":", "_");
		File tgt = new File("./ScreenShots/"+"ScreenShotName"+currentDtTime+".png");
		try
		{
			FileUtils.copyFile(src, tgt);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 
	}

	@Override
	public void onStart(ITestContext context) {
		 
	}

	@Override
	public void onFinish(ITestContext context) {
		 
	}

}
