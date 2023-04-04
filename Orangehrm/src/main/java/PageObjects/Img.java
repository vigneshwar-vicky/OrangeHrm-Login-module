package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Orangehrm.Abstract;

public class Img extends Abstract {
WebDriver driver;
	public Img(WebDriver driver) {
		super(driver);
		this.driver=driver;	
	    PageFactory.initElements(driver,this);
	}
@FindBy(xpath = "//img")
List<WebElement> logos;

public int logoimg() throws InterruptedException
{
	Thread.sleep(2000);
	int actual = logos.size();
	return actual;

}


	
}
