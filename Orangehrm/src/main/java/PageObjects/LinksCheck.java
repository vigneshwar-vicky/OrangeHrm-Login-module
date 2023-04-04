package PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import Orangehrm.Abstract;

public class LinksCheck extends Abstract {
WebDriver driver;
SoftAssert a=new SoftAssert();

	public LinksCheck(WebDriver driver) {
		super(driver);
		this.driver=driver;	
	    PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath = "(//div[contains(@class,'login-footer')]/a)[1]")
WebElement linkedin;

@FindBy(xpath="//h1[contains(@class,'top-card-layout__title')]")
WebElement successlinkedin;

@FindBy(xpath = "(//div[contains(@class,'login-footer')]/a)[2]")
WebElement facebook;

@FindBy(xpath="//a[text()='Forgotten account?']")
WebElement successfacebook;

@FindBy(xpath = "(//div[contains(@class,'login-footer')]/a)[3]")
WebElement twitter;

@FindBy(xpath="//div[text()='2,503 Tweets']")//span[text()='New to Twitter?']
WebElement successtwitter;

@FindBy(xpath = "(//div[contains(@class,'login-footer')]/a)[4]")
WebElement youtube;

@FindBy(xpath="//yt-formatted-string[text()='Shorts']")
WebElement successyoutube;

@FindBy(linkText = "OrangeHRM, Inc")
WebElement website;

@FindBy(xpath="//a[text()='Why OrangeHRM']")
WebElement officialsite;

By linked=By.cssSelector("[data-test-id='nav-logo']");
By fb=By.xpath("//a[@aria-label='Facebook']");
By tweet=By.xpath("//div[text()='2,503 Tweets']");
By yt=By.id("logo-icon");
By we=By.xpath("//a[text()='Why OrangeHRM']");


public String testlinkedin() throws InterruptedException
{
	 JavascriptExecutor js=(JavascriptExecutor)driver;
     js.executeScript("window.scrollBy(0,400)");
     Thread.sleep(2000);
     
     linkedin.click();
     //driver.switchTo().alert().dismiss();
     //String actual = driver.getTitle();
     Set<String> windows = driver.getWindowHandles();
 	 Iterator<String> address = windows.iterator();
      address.next();
      String tabtwo = address.next();
      driver.switchTo().window(tabtwo);
      waitforElementtoappear(linked);
      String success = successlinkedin.getText();
      return success;
}

public String testfacebook() throws InterruptedException
{
	 JavascriptExecutor js=(JavascriptExecutor)driver;
     js.executeScript("window.scrollBy(0,400)");
     Thread.sleep(2000);
     
     facebook.click();
    // String actual = driver.getTitle();
     Set<String> windows = driver.getWindowHandles();
     Iterator<String> address = windows.iterator();
       address.next();
       String tabtwo = address.next();
       driver.switchTo().window(tabtwo);
       waitforElementtoappear(fb);
       String success = successfacebook.getText();
       return success;
}

public String testyoutube() throws InterruptedException
{
	 JavascriptExecutor js=(JavascriptExecutor)driver;
     js.executeScript("window.scrollBy(0,400)");
     Thread.sleep(2000);
     
     youtube.click();
    // String actual = driver.getTitle();
     Set<String> windows = driver.getWindowHandles();
  	 Iterator<String> address = windows.iterator();
       address.next();
       String tabtwo = address.next();
       driver.switchTo().window(tabtwo);
       waitforElementtoappear(yt);
       String success = successyoutube.getText();
       return success;
}

public String testtwitter() throws InterruptedException
{
	 JavascriptExecutor js=(JavascriptExecutor)driver;
     js.executeScript("window.scrollBy(0,400)");
     Thread.sleep(2000);
     
     twitter.click();
    // String actual = driver.getTitle();
     Set<String> windows = driver.getWindowHandles();
     Iterator<String> address = windows.iterator();
       address.next();
       String tabtwo = address.next();
       driver.switchTo().window(tabtwo);
         waitforElementtoappear(tweet);
         String success = successtwitter.getText();
         return success;
}

public String testOFficialsite() throws InterruptedException
{
	 JavascriptExecutor js=(JavascriptExecutor)driver;
     js.executeScript("window.scrollBy(0,400)");
     Thread.sleep(2000);
     
     website.click();
    // String actual = driver.getTitle();
     Set<String> windows = driver.getWindowHandles();
     Iterator<String> address = windows.iterator();
       address.next();
       String tabtwo = address.next();
       driver.switchTo().window(tabtwo);
         waitforElementtoappear(we);
         String success = officialsite.getText();
         return success;
}
	
	
}











//  int res;
/* for(WebElement link:links)	
 {
	   String url = link.getAttribute("href");
     HttpURLConnection  con = (HttpURLConnection)new URL(url).openConnection();
     con.setRequestMethod("HEAD");
     con.connect();
   int  res= con.getResponseCode();
    a.assertTrue(res<400, "TEST IS FAILED "+link.getText()+" is "+res);
   }*/