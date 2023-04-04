package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Orangehrm.Abstract;

public class LoginPage extends Abstract {
	WebDriver driver;
public ForgotPass forget;
		
	public LoginPage(WebDriver driver) 
		{
		    super(driver);
		    this.driver=driver;	
		    PageFactory.initElements(driver,this);
		}
	
	@FindBy(name = "username")
	WebElement uname;
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy (css = "button[type='submit']")
	WebElement log;
	
	@FindBy(xpath="//p[contains(@class,'alert-content-text')]")
	WebElement errormsg;
	
	@FindBy(xpath = "//div[@class='orangehrm-login-forgot']/p")       
	WebElement forgot;
	
	@FindBy(xpath="//span[contains(@class,'field-error-message')]")
	WebElement required;
	
	@FindBy(css="[class='oxd-userdropdown']")
	WebElement drop;
	
	@FindBy(css="[class*='login-title']")
	WebElement logTitle;
	
	@FindBy(xpath = "(//ul[@role='menu']//li)[4]")
	WebElement selectone;
	
	By forr=By.cssSelector("p[class*='login-forgot'])");
	By error=By.cssSelector("[class*='content--error']");
	
	public String dologin(String username,String password) throws InterruptedException
	{
	      uname.sendKeys(username);
	      pwd.sendKeys(password);
	      log.click();
	      Thread.sleep(3000);
	      drop.click();;
	      selectone.click();
	      Thread.sleep(2000);
	      String actualtitle = logTitle.getText();
	      return actualtitle;
	}
	
	public String invalidlogin(String username,String password)
	{
		
	      uname.sendKeys(username);
	      pwd.sendKeys(password);
	      log.click();
	      String match = errormsg.getText();
	      return match;
	}
	
	public String errorlogin(String username,String password) throws InterruptedException
	{
		 uname.sendKeys(username);
	      pwd.sendKeys(password);
	      log.click();
	      Thread.sleep(2000);
	      String require = required.getText();
	      return require;
	}
	public String errormsg()
	{
		waitforElementtoappear(error);
		return errormsg.getText();
	}
	
	public String forgotPass() throws InterruptedException
	{
		forgot.click();
	    forget=new ForgotPass(driver);
	    Thread.sleep(2000);
		String actt = forget.forgetpass();
		return actt;
	}
	
	public int logo() throws InterruptedException
	{
		Img pic=new Img(driver);
		int actualsize = pic.logoimg();
		return actualsize;
		
	}
	
	public String checkfb() throws InterruptedException
	{
	   LinksCheck linnk=new LinksCheck(driver);
	   String status = linnk.testfacebook();
	   return status;
	}
	
	public String checktweet() throws InterruptedException
	{
	   LinksCheck linnk=new LinksCheck(driver);
	   String status = linnk.testtwitter();
	   return status;
	}
	
	public String checkutube() throws InterruptedException
	{
	   LinksCheck linnk=new LinksCheck(driver);
	   String status = linnk.testyoutube();
	   return status;
	}
	
	public String checklinkedin() throws InterruptedException
	{
	   LinksCheck linnk=new LinksCheck(driver);
	   String status = linnk.testlinkedin();
	   return status;
	}
	
	public String checkweb() throws InterruptedException
	{
	   LinksCheck linnk=new LinksCheck(driver);
	   String status = linnk.testOFficialsite();
	   return status;
	}

}
