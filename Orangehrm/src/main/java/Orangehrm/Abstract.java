package Orangehrm;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstract {
WebDriver driver;
WebDriverWait wait;
	public Abstract(WebDriver driver) {
		this.driver=driver;
	}

	
	public void waitforElementtoappear(By FindBy)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
		
	}
	
	public void waitforWebElementtoappear(List<WebElement> webele)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(webele));
		
	}
	
}
