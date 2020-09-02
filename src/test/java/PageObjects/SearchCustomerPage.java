package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver driver;
	WaitHelper waithelper;
	 public SearchCustomerPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 waithelper=new WaitHelper(driver);
	 }
	 @FindBy(id="SearchEmail")
	 @CacheLookup
	 WebElement txtemail;
	 @FindBy(id="search-customers")
	 @CacheLookup
	 WebElement btnSearch;
	 public void setEmail(String email)
	 {
		 waithelper.waitForElement(txtemail,30);
		 txtemail.clear();
		 txtemail.sendKeys(email); 
	 }
	 @FindBy(xpath="//table[@id='customers-grid']/tbody/tr")
	 @CacheLookup
	 List<WebElement>tableRows;
	 public void clcikSearch()
	 {
		 btnSearch.click();
		 waithelper.waitForElement(btnSearch, 30);
	 }
	 public int getNoOfRows()
	 {
		return tableRows.size();
	 }
	 public boolean searchCustomerByEmail(String email)
	 {
		 boolean flag=false;
		 
		 
		 for(int i=1;i<=getNoOfRows();i++)
		 {
		String emailid=driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
		if(emailid.equals(email))
		{
			flag=true;
		}
		
		
		
		
		 
	 }
		 return flag;
	 }
	 @FindBy(id="SearchFirstName")
		@CacheLookup
		WebElement txtfirstname;
	 public void setFirstname(String firstname)
	 {
		txtfirstname.clear();
		txtfirstname.sendKeys(firstname);
	 }
	 @FindBy(xpath="//input[@id='SearchLastName']")
		@CacheLookup
		WebElement txtlastname;
	 public void setLastname(String lastname)
	 {
	txtlastname.clear();
	
		txtlastname.sendKeys(lastname);
	 }
	 public boolean searchCustomerByname()
	 {
		 boolean flag=false;
		 
		 
		 for(int i=1;i<=getNoOfRows();i++)
		 {
		String name1=driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
		String name2[]=name1.split(" ");
		if(name2[0].equals("Victoria") && name2[1].equals("Terces") )
		{
			flag=true;
		}
		
		
		
		 
	 }
		 return flag;
	 }
	 

}
