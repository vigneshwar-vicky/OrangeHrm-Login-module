package Resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

	
	public static ExtentReports getReport()
	{
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//index.html");
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Vicky");
		return extent;
		
	}
	
	
	
}
