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
Feature: Testing the Stack Page
 Scenario: User navigates to "Stack" Page
    Given The user is on the home page after being logged in
    When The user selects the stack item from the drop-down menu
    Then The user should be directed to the "Stack" Page

Scenario Outline: The user is able to navigate to Stack topic page and run code in the tryeditor
Given The user is in the Stack Data Structure Page
When the user clicks "<Stackoption>" in Stack Data Structure page
And the user enter valid "<PythonCode>" for Stack
And the user clicks Run button for the Python code for Stack module
Then the user see the Stack module excepted "<output>"

Examples:
 | Stackoption               	|   PythonCode           |  output  |
 | Operations in Stack       	| print('Hello, World!') |  Hello, World! |
 | Implementation          		| print('Hello, World!') |  Hello, World! |
 | Applications          			| print('Hello, World!') |  Hello, World! |
 
 Scenario Outline: The user is able to navigate to Stack topic page and runs code in the tryeditor page
Given The user is present in the Stack Data Structure Page
When the user click "<StackoptionValue>" in Stack Data Structure page
And the user enters inValid "<PythonCode>" for Stack
And the user clicks Run button in the tryEditor Page for the Python code for Stack module
Then the user will get the Stack module "<errormessage>"

Examples:
 | StackoptionValue          |   PythonCode   		|  	errormessage  |
 | Operations in Stack       | abcd        				| NameError: name 'abcd' is not defined on line 1               |
 | Implementation          	 | abcd        				| NameError: name 'abcd' is not defined on line 1               |
 | Applications          		 | abcd        				| NameError: name 'abcd' is not defined on line 1               |
 

