package Orangehrm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.LoginPage;


public class Base {
public WebDriver driver;
public LoginPage loginpage;


  public WebDriver getBrowser() throws IOException
   {
	  Properties prop=new Properties();
	  FileInputStream fis= new FileInputStream("C://Users//Vigneshwar//eclipse-workspace//Orangehrm//src//main//java//Resources//GlobalData.properties");
	  prop.load(fis);
	  String browserName = prop.getProperty("browser");
	  
	  if(browserName.contains("chrome"))
	  {
		    ChromeOptions option=new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vigneshwar\\Desktop\\seljars\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver(option);
	  }
	  else if (browserName.contains("firefox")) 
	  {
		   System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vigneshwar\\Desktop\\seljars\\geckodriver\\geckodriver.exe");
	       driver=new FirefoxDriver();
	}
	  else if (browserName.contains("edge")) 
	  {
	      driver=new EdgeDriver();
	}
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	return driver;
   }
  
	@BeforeMethod(alwaysRun =true)
  public LoginPage launchApp() throws IOException  
	{
		/* Properties prop=new Properties();
		  FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//GlobalData.properties");
		  prop.load(fis);
		String website = prop.getProperty("url");*/
		String url = "https://opensource-demo.orangehrmlive.com/";
		
		driver=getBrowser();
		loginpage=new LoginPage(driver);
	    driver.get(url);
		return loginpage;
	}
	
	@AfterMethod(alwaysRun =true)
	public void quit()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
	}
	
	
	
  
  public List<HashMap<String,String>> getJsondata(String filepath) throws IOException
  {
	  String jsoncontent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
	  ObjectMapper mapper=new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>() {
	});
	  return data;
  }
 
	
}
