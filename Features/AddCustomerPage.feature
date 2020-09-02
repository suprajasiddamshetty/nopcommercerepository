Feature: AddCustomer

Background: Below are the common steps for each scenario
	Given User Launch Chrome browser
	When User opens url "https:\\admin-demo.nopcommerce.com\\login" 
	And User enters email as "admin@yourstore.com" and password as "admin"
	And Click on Login button
	Then User view the Dashboard

Scenario: Add a new customer
    
	When user click on Customers menu
	And user click on customers menu item
	And user clcik on Add new button
	Then user view the Add a new Customer page
	When user enters customer info
	And user click on save button
	Then user view the confirmation message as "The new customer has been added successfully"
	And Close Browser
	

Scenario: Search a customer by Email
    
	Then User view the Dashboard
	When user click on Customers menu
	And user click on customers menu item
	And Enter customer Email
	And click on serach button
	Then User should found email in the search table
    And Close Browser
    

    Scenario: Search a customer by name
	When user click on Customers menu
	And user click on customers menu item
	And Enter customer first name
    And Enter customer last name
	And click on serach button
	Then User should found name in the search table
    And Close Browser



	
