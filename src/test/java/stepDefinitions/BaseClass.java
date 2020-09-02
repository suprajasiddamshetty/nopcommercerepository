package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;

public class BaseClass {
public WebDriver driver;

	
	LoginPage lp;
	AddCustomerPage addcustom;
	SearchCustomerPage scp;
	public Logger log;
	Properties p;
	
	public static String randomStringGeneration()
	{
		String randomString= RandomStringUtils.randomAlphabetic(5);
		return randomString;
		
	}
}
