#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
	Feature: Navigating to Login page of DS Algo
  	Scenario: The user clicks on register link on signin page
    Given The user opens the Login page
    When 	The user clicks on the Login page with incorrect username and password
    Then  It should display an error message "Invalid Username and Password"
    
   	Scenario: The user is presented with error message for "Invalid Username and Password"
   	Given  The user opens the Login page
    When The user enters the correct username and password and clicks Login button
    Then The user can see the  message "You are logged in"
   
    When 	The user clicks on the Signout button
    Then 	It should display a logoutmessage "Logged out successfully"
 