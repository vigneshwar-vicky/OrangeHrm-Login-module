package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Orangehrm.Abstract;

public class ForgotPass extends Abstract {
WebDriver driver;
	public ForgotPass(WebDriver driver) {
		super(driver);
		this.driver=driver;	
	    PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//h6[text()='Reset Password']")
	WebElement forgotmsg;
	
	By tag=By.xpath("//h6[text()='Reset Password']");

	public String forgetpass()
	{
		waitforElementtoappear(tag);
		String actual = forgotmsg.getText();
		return actual;
	}
	
}
