package Generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		test = report.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS,result.getThrowable());
		 
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		
		String screenShot = null;
		System.out.println("ScreenShot enter"+result.getName());
		try 
		{
			screenShot= WebDriver_Utility.takeScreenShot(BaseClass.sDriver, result.getMethod().getMethodName());
			System.out.println("ScreenShot Path: "+screenShot);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		 test.addScreenCaptureFromPath(screenShot);
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP,result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context)
	{
		Java_Utility jUtil = new Java_Utility();
		int rNo = jUtil.getRandomNumber();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report_"+rNo+".html");
		spark.config().setDocumentTitle("Testing");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("VTiger");
		
		//System config
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows11");
		report.setSystemInfo("ExecutedBy", "Viji");
		report.setSystemInfo("ReviewedBy", "viji");
	 
	}

	@Override
	public void onFinish(ITestContext context)
	{
	 report.flush();
	}

}
