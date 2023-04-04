package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Orangehrm.Abstract;

public class Homepage extends Abstract {
WebDriver driver;

	public Homepage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy()
	List<WebElement> dashboard;

	public void home()
	{
		waitforWebElementtoappear(dashboard);	
	
	}
	
	
}
