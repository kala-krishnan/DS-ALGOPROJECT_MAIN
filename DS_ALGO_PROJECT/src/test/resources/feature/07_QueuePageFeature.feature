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
Feature: To test the Queue Data Structure Page
   		
   Scenario: The user navigates to the Queue Data Structure Page
    Given The user is on the home page
    When 	the user is able to click on the drop down menu to select Queue
   	Then 	the user is navigating to the Queue data structure page
   	
		Scenario Outline: The user is able to navigate to Queue Page and run code in tryEditor page
		Given The user is in Queue Data Structure Page
		When  The user click "<Queueoption>" in Queue Data Structure Page
		And   click Try Here button and enter valid "<PythonCode>" in TryEditor
		And   the user clicks the run button for valid Python code
		Then  the user gets the valid "<output>"
		
	Examples:
 | Queueoption                            | PythonCode | output |
 | Implementation of Queue in Python      | print('Hello, World!') | Hello, World! |
 | Implementation using collections.deque | print('Hello, World!') | Hello, World! |
 | Implementation using array             | print('Hello, World!') | Hello, World! |
 | Queue Operations                       | print('Hello, World!') | Hello, World! |
 
 	Scenario Outline: The user is able to navigate to Queue Page and runs invalid code in tryEditor page
			Given The user is in Queue Data Structures Page
			When 	The user clicks "<QueueoptionValue>" in Queue Data Structure Page
			And 	The user clicks Try Here button and enter inValid "<PythonCode>" in TryEditor
			And 	The user runs inValid code in the TryEditor by clicking run button.
			Then 	the user gets the invalid "<errormessage>"
 	Examples:
 	| QueueoptionValue  													 | PythonCode | errormessage |
 	| Implementation of Queue in Python 					 | HelloPeople   	|NameError: name 'HelloPeople' is not defined on line 1 |
 	| Implementation using collections.deque 			 | HelloPeople    |NameError: name 'HelloPeople' is not defined on line 1 |
 	| Implementation using array                   | HelloPeople  	|NameError: name 'HelloPeople' is not defined on line 1 |
 	| Queue Operations														 | HelloPeople 		|NameError: name 'HelloPeople' is not defined on line 1 |
 
 
 