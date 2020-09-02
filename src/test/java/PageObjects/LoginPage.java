package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtmail;
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpassword;
	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement login;
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement logout;
	
	public void setUsername(String username) throws InterruptedException
	{
		txtmail.clear();
		Thread.sleep(5000);
		txtmail.sendKeys(username);
	}
	public void setPassword(String password) throws InterruptedException
	{
		txtpassword.clear();
		Thread.sleep(5000);
		txtpassword.sendKeys(password);
	}
	
	public void btnLogin()
	{
		login.click();
	}
	
	public void btnlogout()
	{
		logout.click();
	}
	
	
	

}
