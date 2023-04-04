package Orangehrm;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReportsNG;

public class Listeners extends Base implements ITestListener {
      ExtentTest test;
      ExtentReports extent=ExtentReportsNG.getReport();
	// ThreadLocal<ExtentTest> extentTest=new  ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		//extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String filepath=null;
		
	try {
		filepath=getScreenshot(result.getMethod().getMethodName(),driver);
	} catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}	
	
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
