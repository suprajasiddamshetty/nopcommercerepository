package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class AddCustomerPage {
	
	public WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	By link_customersmenu=By.xpath("//a[@href='#']//span[text()='Customers']");
	By link_customersmenuitem=By.xpath("//a[@href='/Admin/Customer/List']//span[text()='Customers']");
	By btnAddNew =By.xpath("//a[@class='btn bg-blue']");
	By toggleClick=By.xpath("//i[@class='fa-plus toggle-icon fa']");
	By txtEmail=By.id("Email");
	By txtpassword=By.id("Password");
	By txtFirstname=By.id("FirstName");
	By txtLastname=By.id("LastName");
	By rdMaleGender=By.cssSelector("input#Gender_Male");
	By rdFemaleGender =By.cssSelector("input#Gender_Female");
	By txtCompanyname=By.id("Company");
	By txtCustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstItemAdministrators=By.xpath("//li[text()='Administrators']");
	By lstItemForumModerators=By.xpath("//li[text()='Forum Moderators']");
	By lstItemRegistered=By.xpath("//li[text()='Registered']");
	By lstItemVendors=By.xpath("//li[text()='Vendors']");
	By lstItemGuests=By.xpath("//li[text()='Guests']");
	By drpmngrofVendors=By.xpath("//select[@id='VendorId']");
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	By btnSave=By.name("save");
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	//Action methods
	public String getPageTitle()
	{
		return ldriver.getTitle();
		
	}
	public void clickOncustomersMenu()
	{
		ldriver.findElement(link_customersmenu).click();
	}
	
	public void clickOncustomersMenuItem()
	{
		ldriver.findElement(link_customersmenuitem).click();
	}
	
	public void clickOnAddNew()
	{
		ldriver.findElement(btnAddNew).click();
	}
	public void clickOnPlusIcon()
	{
		ldriver.findElement(toggleClick).click();
	}
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String password)
	{
		ldriver.findElement(txtpassword).sendKeys(password);
	}
	public void setFirstName(String firstname)
	{
		ldriver.findElement(txtFirstname).sendKeys(firstname);
	}
	public void setLastName(String lastname)
	{
		ldriver.findElement(txtLastname).sendKeys(lastname);
	}
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else
		{
			ldriver.findElement(rdFemaleGender).click();
		}
	}
	public void setCoampanyName(String company)
	{
		ldriver.findElement(txtCompanyname).sendKeys(company);
	}
	public void setCustomerRole(String role)
	{
		//ldriver.findElement(By.xpath("//li[@class='k-button']//span[@class='k-select']")).click();
		ldriver.findElement(txtCustomerRoles).click();
		WebElement listitem;
		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(lstItemAdministrators);
		}
		else if(role.equals("Forum Moderators"))
		{
			listitem=ldriver.findElement(lstItemForumModerators);
		}
		else if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(lstItemRegistered);
		}
		else if(role.equals("Vendors"))
		{
			listitem=ldriver.findElement(lstItemVendors);
		}
		else
		{
			listitem=ldriver.findElement(lstItemGuests);
		}
		
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();",listitem);
	}
	
	public void setManagerOfVendors(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmngrofVendors));
		drp.selectByVisibleText(value);
		
	}
		public void setAdminContent(String content)
		{
			ldriver.findElement(txtAdminContent).sendKeys(content);
		}
		public void setDob(String dob)
		{
			ldriver.findElement(txtDob).sendKeys(dob);
		}
		public void clickOnSave()
		{
			ldriver.findElement(btnSave).click();
		}
	}
	
	


