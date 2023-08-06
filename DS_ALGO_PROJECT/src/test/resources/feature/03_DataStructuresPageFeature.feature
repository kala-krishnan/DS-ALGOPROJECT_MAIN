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
	Feature: User is logged into DS-Algo page and checking the DataStructures module
		Scenario: User is Logged into DS-Algo page
    Given The user is on signon page of the DS-Algo page
    When 	The user enter valid username "coolcukes" and password "Selenium@123"
    Then  It should display "You are logged in"
    
    Scenario: User is able to navigate to Data Structures introduction page
    Given The user is on the home page after successful login
    When  The user clicks the Get Started button under Data Structures introduction panel
    Then  The user should be redirected to Data Structures introduction page
    
    Scenario: User is able to navigate to Time Complexity page
    Given  The user is on Data Structures introduction page
    When The user clicks the Time Complexity link
    Then The user should be redirected to the Time Complexity page  
    
    Scenario: User is able to navigate to a page having a tryEditor from the Time Complexity page
    Given The user is on the Time Complexity page after login
    When  The user click Try Here on the Time Complexity page
    Then  The user should be redirected to the TryEditor page
    
    Scenario Outline: User is able to run code in tryEditor
    Given The user is in a page having a tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<SheetName>" and <RowNumber>
   Then The user should be presented with the run result
    
    Examples:
    | SheetName  | RowNumber |
    |DataStructures| 1|
    
   Scenario Outline: The User is able to run code with invalid syntax in tryEditor
   	Given The user is in a page having a tryEditor with a Run button to test 
    When The user enter invalid python code in tryEditor from sheet "<SheetName>" and <RowNumber>
    Then The user should be presented with the error message box
    
    Examples:
    | SheetName       | RowNumber|
    | DataStructures  | 2  |  
    
    
    
    