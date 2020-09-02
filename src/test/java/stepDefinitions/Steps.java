package stepDefinitions;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Steps extends BaseClass{
	
	@Before
	public void setup() throws IOException
	{
		
		
		FileInputStream fis=new FileInputStream("config.properties");
		 p=new Properties();
		p.load(fis);
		log=log.getLogger("Practice1");
		PropertyConfigurator.configure("log4j.properties");
		String browser1=p.getProperty("browser");
		if(browser1.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", p.getProperty("chromepath"));
		 driver=new ChromeDriver();
		}
	}
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		log.info("launch chrome browser");
		
		 lp=new LoginPage(driver);
		
		}

	@When("User opens url {string}")
	 
	public void user_opens_url(String url) {
		log.info("open url");
	    driver.get(url);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) throws InterruptedException {
		log.info("enter serid and password");
	    lp.setUsername(username);
	    lp.setPassword(password);
	}

	@When("Click on Login button")
	public void click_on_login_button() throws InterruptedException {
		log.info("clcik on login button");
	   Thread.sleep(5000);
	   lp.btnLogin();
	   
	}

	@Then("Page Title should be displayed as {string}")
	public void page_title_should_be_displayed_as(String string) {
		if(driver.getPageSource().contains("Login was unsuccessful."))
		{
			log.info("login was unsuccessful");
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			log.info("login was successful");
	   Assert.assertEquals(string, driver.getTitle());
		}
	}

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
		log.info("click on logout");
	    lp.btnlogout();
	    Thread.sleep(5000);
	}


	@Then("Close Browser")
	public void close_browser() throws InterruptedException {
		Thread.sleep(5000);
		log.info("close browser");
	    driver.close();
	}
	@Then("User view the Dashboard")
	public void user_view_the_dashboard() {
		addcustom=new AddCustomerPage(driver);
	   String title=addcustom.getPageTitle();
	   driver.manage().window().maximize();
	   Assert.assertEquals("Dashboard / nopCommerce administration",title);
	}

	@When("user click on Customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
	  addcustom.clickOncustomersMenu();
	}

	@When("user click on customers menu item")
	public void user_click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(5000);
	  addcustom.clickOncustomersMenuItem();
	}

	@When("user clcik on Add new button")
	public void user_clcik_on_add_new_button() throws InterruptedException {
	    addcustom.clickOnAddNew();
	    Thread.sleep(3000);
	}

	@Then("user view the Add a new Customer page")
	public void user_view_the_add_a_new_customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration",addcustom.getPageTitle());
	}
	@When("user enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		//addcustom.clickOnPlusIcon();
		String email=randomStringGeneration()+"@nopCommerce.com";
	   addcustom.setEmail(email);
	   addcustom.setPassword("password@123");
	   //addcustom.setCustomerRole("Vendors");
	   Thread.sleep(5000);
	   addcustom.setCustomerRole("Administrators");
	  // addcustom.setManagerOfVendors("Vendor 2");
	   Thread.sleep(5000);
	   addcustom.setGender("Female");
	   addcustom.setFirstName("supraja");
	   addcustom.setLastName("siddamshetty");
	   addcustom.setDob("7/24/1994");
	   addcustom.setCoampanyName("abc");
	   addcustom.setAdminContent("This is for testing...");
	   
	}

	@When("user click on save button")
	public void user_click_on_save_button() throws InterruptedException {
	   addcustom.clickOnSave();
	   Thread.sleep(5000);
	}

	@Then("user view the confirmation message as {string}")
	public void user_view_the_confirmation_message_as(String string) {
	  Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	}
	@And("Enter customer Email")
	public void enter_customer_email() {
		scp=new SearchCustomerPage(driver);
	    scp.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("click on serach button")
	public void click_on_serach_button() throws InterruptedException {
		Thread.sleep(5000);
	   scp.clcikSearch();
	   Thread.sleep(5000);
	}

	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status=scp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		
		Assert.assertEquals(true,status);
	   
	}
	@When("Enter customer first name")
	public void enter_customer_first_name() throws InterruptedException {
		scp=new SearchCustomerPage(driver);
		Thread.sleep(5000);
		scp.setFirstname("Victoria");
	  
	}

	@When("Enter customer last name")
	public void enter_customer_last_name() throws InterruptedException {
		scp=new SearchCustomerPage(driver);
        Thread.sleep(5000);
		scp.setLastname("Terces");
	    
	}

	@Then("User should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
		boolean status=scp.searchCustomerByname();
		Assert.assertEquals(true, status);
	   
	}

	

}
