Feature: Login

@smoke
Scenario: Successful Login with User Credentials

	Given User Launch Chrome browser
	When User opens url "https:\\admin-demo.nopcommerce.com\\login" 
	And User enters email as "admin@yourstore.com" and password as "admin"
	And Click on Login button
	Then Page Title should be displayed as "Dashboard / nopCommerce administration"
	When User clicks on Logout link
	Then Page Title should be displayed as "Your store. Login"
	And  Close Browser
	
Scenario Outline: Login Data Driven
    
    Given User Launch Chrome browser
	When User opens url "https:\\admin-demo.nopcommerce.com\\login" 
	And User enters email as "<email>" and password as "<password>"
	And Click on Login button
	Then Page Title should be displayed as "Dashboard / nopCommerce administration"
	When User clicks on Logout link
	Then Page Title should be displayed as "Your store. Login"
	And  Close Browser
	
	Examples:
	|email|password|
	|admin@yourstore.com|admin|
	|admin@yourstore.com|admin123|
	
	
  