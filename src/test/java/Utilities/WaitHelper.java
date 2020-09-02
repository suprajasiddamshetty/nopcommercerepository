package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper { 
	public WebDriver ldriver;
	 public WaitHelper(WebDriver driver)
	 {
		 this.ldriver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 public void waitForElement(WebElement element,long timeOutInSeconds)
	 {
		 WebDriverWait wait=new WebDriverWait(ldriver,timeOutInSeconds);
		 wait.until(ExpectedConditions.visibilityOf(element));
		 
	 }

}
